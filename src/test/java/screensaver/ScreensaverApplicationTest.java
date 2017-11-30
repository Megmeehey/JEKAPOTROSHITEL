package screensaver;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import quoters.IntegrationTest;

@Category(IntegrationTest.class)
public class ScreensaverApplicationTest {
    private static AnnotationConfigApplicationContext ctx;

    @BeforeClass
    public static void setUp() {
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void appTest() throws InterruptedException {
        while (true) {
            ctx.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
    }
}