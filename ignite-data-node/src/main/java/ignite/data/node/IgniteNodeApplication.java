package ignite.data.node;

import org.apache.ignite.Ignition;

/**
 * @author Bhuwan Upadhyay
 * @date 2017/06/27
 */
public class IgniteNodeApplication {

    public static void main(String[] args) {
        Ignition.start("ignite-data-node.xml");
    }

}
