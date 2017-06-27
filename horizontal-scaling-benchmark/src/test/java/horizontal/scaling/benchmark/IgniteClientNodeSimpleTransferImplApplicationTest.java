package horizontal.scaling.benchmark;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IgniteClientNodeApplication.class, SimpleTransferService.class})
public class IgniteClientNodeSimpleTransferImplApplicationTest {

    @Autowired
    private SimpleTransferService transferService;

}