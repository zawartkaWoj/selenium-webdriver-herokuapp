import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.page.HoverPage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverPageTest extends BaseTest {

    @Test(priority = 0, description = "Check if correct Hover is displayed.")
    @Description("Checking if avatar no. 2 is correctly displayed upon mouse hover.")
    public void hoverOnUserTwoTest() {
        int userId = 2;

        HoverPage hoverPage = new HomePage(driver)
                .openHoverLink()
                .hoverOnAvatar(userId);

        Assert.assertTrue(hoverPage.getUsernames().get(userId - 1).isDisplayed());
        Assert.assertFalse(hoverPage.getUsernames().get(0).isDisplayed());
        Assert.assertFalse(hoverPage.getUsernames().get(2).isDisplayed());
    }

    @Test(priority = 0, description = "Check if hovers hide on mouse exit.")
    @Description("Checking if all hovers disappear correctly when shuffling through them with mouse cursor.")
    public void checkIfHoversRemainTest() {
        int userId = 1;

        HoverPage hoverPage = new HomePage(driver)
                .openHoverLink()
                .hoverOnAvatar(userId)
                .hoverOnAvatar(2)
                .hoverOnAvatar(3)
                .hoverOnAvatar(userId);

        Assert.assertTrue(hoverPage.getUsernames().get(userId - 1).isDisplayed());
        Assert.assertFalse(hoverPage.getUsernames().get(1).isDisplayed());
        Assert.assertFalse(hoverPage.getUsernames().get(2).isDisplayed());
    }

}
