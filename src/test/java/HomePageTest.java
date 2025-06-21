import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 100, description = "Check if homepage loads successfully")
    public void homePageLoadTest() {
        HomePage homePage = new HomePage(driver);

        Assert.assertEquals("Welcome to the-internet", homePage.getHeadingText());
    }
}
