package ignite.benchmark.poc.domain;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
public class Account implements Serializable {

    @QuerySqlField(index = true)
    private String accountNumber;
    @QuerySqlField
    private BigDecimal balance;

    public Account(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
