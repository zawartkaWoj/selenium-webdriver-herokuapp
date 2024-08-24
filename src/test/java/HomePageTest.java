import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageLoadTest() {
        HomePage homePage = new HomePage(driver);

        Assert.assertEquals("Welcome to the-internet", homePage.getHeadingText());
    }
}
