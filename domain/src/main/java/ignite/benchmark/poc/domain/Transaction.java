package ignite.benchmark.poc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/20
 */
public class Transaction implements Serializable {

    private String reference;
    private String type;
    private BigDecimal amount;
    private LocalDate date;

}
