package horizontal.scaling.benchmark;

import ignite.benchmark.poc.domain.Transaction;

import java.math.BigDecimal;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
public interface TransferService {

    void transfer(String fromAccount, String toAccount, BigDecimal amount);
}
