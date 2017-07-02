package horizontal.scaling.benchmark;

import ignite.benchmark.poc.domain.Account;
import ignite.benchmark.poc.domain.Transaction;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ignite.Ignite;
import org.apache.ignite.cache.query.SqlQuery;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.cache.Cache;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static horizontal.scaling.benchmark.CacheHelper.accountCache;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
@Component
public class SimpleTransferServiceImpl implements TransferService {

    public static final String TRANSACTION_CACHE = "transactionCache";
    public static final String ACCOUNT_CACHE = "accountCache";

    @Autowired
    private Ignite ignite;

    @Override
    public void transfer(@NotNull String fromAccount, @NotNull String toAccount, @NotNull BigDecimal amount) {
        final Cache.Entry<String, Account> fromAccountDetail = findAccount(fromAccount);
        final Cache.Entry<String, Account> toAccountDetail = findAccount(toAccount);
        checkValidation(amount, fromAccountDetail);

        //Subtract and Add amount from cache
        fromAccountDetail.getValue().setBalance(fromAccountDetail.getValue().getBalance().subtract(amount));
        toAccountDetail.getValue().setBalance(toAccountDetail.getValue().getBalance().add(amount));

        //Save Transaction
        CacheHelper.transactionCache(ignite).put(UUID.randomUUID().toString(), buildTransaction(fromAccount, toAccount, amount));

        //Update amount in accounts
        CacheHelper.accountCache(ignite).put(toAccountDetail.getKey(), toAccountDetail.getValue());
        CacheHelper.accountCache(ignite).put(fromAccountDetail.getKey(), fromAccountDetail.getValue());
    }

    @NotNull
    private Transaction buildTransaction(@NotNull String fromAccount, @NotNull String toAccount, @NotNull BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setFromAccount(fromAccount);
        transaction.setReference(RandomStringUtils.random(20));
        transaction.setDate(LocalDate.now());
        transaction.setType(System.nanoTime() % 2 == 0 ? "DEBIT" : "CREDIT");
        transaction.setToAccount(toAccount);
        return transaction;
    }

    private void checkValidation(@NotNull BigDecimal amount, Cache.Entry<String, Account> fromAccountDetail) {
        if (fromAccountDetail.getValue().getBalance().compareTo(amount) < 0)
            throw new IllegalArgumentException("Insufficient balance");
    }

    private Cache.Entry<String, Account> findAccount(String accountNumber) {
        List<Cache.Entry<String, Account>> entries = accountCache(ignite).query(new SqlQuery<String, Account>(Account.class,
                "from Account a WHERE a.accountNumber = :accNo").setArgs(accountNumber)
        ).getAll();
        if (!entries.isEmpty())
            return entries.get(0);
        throw new IllegalArgumentException("Account not exist. [accountNumber=" + accountNumber + "]");
    }


}
