import com.zawartkawoj.page.DropdownListPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownListPageTest extends BaseTest {

    @Test(priority = 100, enabled = true, description = "Check if clicked options is displayed")
    public void chooseOptionTest() {
        //Pick only options 1 or 2
        int optionId = 1;

        DropdownListPage dropdownListPage = new HomePage(driver)
                .openDropdownListPage()
                .chooseOption(optionId);

        Assert.assertTrue(dropdownListPage.getListOptions().get(optionId - 1).isDisplayed());
    }

}
