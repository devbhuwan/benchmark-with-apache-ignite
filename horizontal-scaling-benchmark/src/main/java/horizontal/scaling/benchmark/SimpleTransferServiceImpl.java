package horizontal.scaling.benchmark;

import org.apache.ignite.Ignite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
@Component
public class SimpleTransferServiceImpl implements TransferService {

    @Autowired
    private Ignite ignite;

    @Override
    public void transfer(String fromAccount, String toAccount, BigDecimal amount) {

    }
}
