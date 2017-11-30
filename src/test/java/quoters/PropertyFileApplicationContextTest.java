package quoters;

import org.junit.BeforeClass;
import org.junit.Test;

public class PropertyFileApplicationContextTest {
    public static PropertyFileApplicationContext context;

    @BeforeClass
    public static void setUp() {
        context = new PropertyFileApplicationContext("context.properties");
    }

    @Test
    public void testPropertyFileAppContext() {
        context.getBean(Quoter.class).sayQuote();
    }
}