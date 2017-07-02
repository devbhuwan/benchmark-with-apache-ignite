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

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getReference() {
        return reference;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }
}
