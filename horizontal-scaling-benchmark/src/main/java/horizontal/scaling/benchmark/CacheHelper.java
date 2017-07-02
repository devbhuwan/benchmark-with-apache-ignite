package horizontal.scaling.benchmark;

import ignite.benchmark.poc.domain.Account;
import ignite.benchmark.poc.domain.Transaction;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/07/02
 */
public class CacheHelper {

    public static IgniteCache<String, Account> accountCache(Ignite ignite) {
        return ignite.cache(SimpleTransferServiceImpl.ACCOUNT_CACHE);
    }

    public static IgniteCache<String, Transaction> transactionCache(Ignite ignite) {
        return ignite.cache(SimpleTransferServiceImpl.TRANSACTION_CACHE);
    }
}
