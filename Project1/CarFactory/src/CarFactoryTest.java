import java.io.IOException;

/**
 * @author parthpatel0426
 *
 * This <code>CarFactoryTest</code> class is used to execute <code>run</code>
 * method of the <code>Factory</code> class.
 *
 */
public class CarFactoryTest {
    public static void main(String[] args) throws IOException {
        Factory factory = new Factory();
        factory.run(1000);
    }

}
