package quoters;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
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