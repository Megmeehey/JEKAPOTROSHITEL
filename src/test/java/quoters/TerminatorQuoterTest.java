package quoters;

import lombok.Setter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Category(UnitTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context.xml"})
public class TerminatorQuoterTest {

    @Setter(onMethod = @__(@Autowired))
    Quoter terminator;

    @Test
    public void sayQuoteTest() throws InterruptedException {
        terminator.sayQuote();
    }
}