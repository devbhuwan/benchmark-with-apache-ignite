package horizontal.scaling.benchmark;

import ignite.benchmark.poc.domain.Transaction;
import org.apache.ignite.Ignite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
@Component
public class SimpleTransferService {

    @Autowired
    private Ignite ignite;

    public void transfer(Transaction transaction) {

    }

}
