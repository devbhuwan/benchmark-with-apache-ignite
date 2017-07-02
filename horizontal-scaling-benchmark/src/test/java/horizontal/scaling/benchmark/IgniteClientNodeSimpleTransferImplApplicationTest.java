package horizontal.scaling.benchmark;

import ignite.benchmark.poc.domain.Account;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteDataStreamer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static horizontal.scaling.benchmark.SimpleTransferServiceImpl.ACCOUNT_CACHE;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IgniteClientNodeApplication.class, SimpleTransferServiceImpl.class})
public class IgniteClientNodeSimpleTransferImplApplicationTest {

    public static final int BALANCE = 100000;

    @Autowired
    private TransferService transferService;

    @Autowired
    private Ignite ignite;

    @Before
    public void setUp() {
        try (IgniteDataStreamer<String, Account> dataStreamer = ignite.dataStreamer(ACCOUNT_CACHE)) {
            IntStream.range(0, DataGiven.EIGHT_00_MILLIONS / DataGiven.ONE_MILLION)
                    .parallel().forEach(i -> {
                String uuid = i + "";
                dataStreamer.addData(uuid, new Account(uuid, BigDecimal.valueOf(BALANCE)));
            });
        }
    }

    @Test
    public void oneThousandMillionsTransactions() {

    }

}