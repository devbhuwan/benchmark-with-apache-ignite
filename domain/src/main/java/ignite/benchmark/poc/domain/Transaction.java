package ignite.benchmark.poc.domain;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/20
 */
public class Transaction implements Serializable {

    @QuerySqlField(index = true)
    private String reference;
    @QuerySqlField
    private String type;
    @QuerySqlField
    private BigDecimal amount;
    @QuerySqlField
    private LocalDate date;
    @QuerySqlField
    private String fromAccount;
    @QuerySqlField
    private String toAccount;

}
