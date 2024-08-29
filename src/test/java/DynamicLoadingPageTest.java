import com.zawartkawoj.page.DynamicLoadingPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import com.zawartkawoj.utils.WaitForElement;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingPageTest extends BaseTest {

    @Test(priority = 0, description = "Check for 'Hello World' on Element One.")
    @Description("Checking if 'Hello World' for Element One exists and is not visible.")
    public void elementOneExistsButNotVisibleTest() {
        DynamicLoadingPage dynamicLoadingPage = new HomePage(driver)
                .openDynamicLoadingPage()
                .clickOnExampleOne();

        WebElement helloWorld = dynamicLoadingPage.getHelloWorldHidden();

        Assert.assertTrue(helloWorld.isEnabled());
        Assert.assertFalse(helloWorld.isDisplayed());
    }

    @Test(priority = 0, description = "Wait for Element One to appear.")
    @Description("Waiting for 'Hello World' to load and become visible.")
    public void waitForElementOneVisibility() {
        DynamicLoadingPage dynamicLoadingPage = new HomePage(driver)
                .openDynamicLoadingPage()
                .clickOnExampleOne()
                .clickStartButton();

        WebElement helloWorld = WaitForElement.waitForVisibilityOf(driver, dynamicLoadingPage.getHelloWorldHidden());
        Assert.assertTrue(helloWorld.isDisplayed());
    }

}
