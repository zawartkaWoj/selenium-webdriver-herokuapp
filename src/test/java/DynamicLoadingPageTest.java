import com.zawartkawoj.page.DynamicLoadingPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import com.zawartkawoj.utils.WaitForElement;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingPageTest extends BaseTest {

    @Test(priority = 100, description = "Check if Element One is hidden")
    public void elementOneDisplayedTest() {
        DynamicLoadingPage dynamicLoadingPage = new HomePage(driver)
                .openDynamicLoadingPage()
                .clickOnExampleOne();

        WebElement helloWorld = dynamicLoadingPage.getHelloWorldHidden();

        Assert.assertFalse(helloWorld.isDisplayed());
    }

    @Test(priority = 110, description = "Check if Element One appears after loading")
    public void waitForElementOneVisibilityTest() {
        DynamicLoadingPage dynamicLoadingPage = new HomePage(driver)
                .openDynamicLoadingPage()
                .clickOnExampleOne()
                .clickStartButton();

        WebElement helloWorld = WaitForElement.waitForVisibilityOf(driver, dynamicLoadingPage.getHelloWorldHidden());
        Assert.assertTrue(helloWorld.isDisplayed());
    }

}
