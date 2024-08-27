import com.zawartkawoj.page.DropdownListPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownListPageTest extends BaseTest {

    @Test(priority = 0, description = "Checking if dropdown list opens.")
    @Description("Check if the list expands after clicking on it once.")
    public void listOpensSuccessfullyTest() {
        DropdownListPage dropdownListPage = new HomePage(driver)
                .openDropdownListPage()
                .clickOnList();

        for(WebElement option : dropdownListPage.getOptions()) {
            Assert.assertTrue(option.isDisplayed());
        }
    }

    @Test(priority = 0, description = "Choosing an option from the dropdown list.")
    @Description("Chose an option from the dropdown list, click on the list again to close it and make sure the chosen" +
            "option is visible.")
    public void chooseOptionTest() {
        //Pick only options 1 or 2
        int optionId = 1;

        //clickOnList() method is called twice due to the dropdown list not closing upon clicking an option
        DropdownListPage dropdownListPage = new HomePage(driver)
                .openDropdownListPage()
                .clickOnList()
                .clickOption(optionId)
                .clickOnList();

        Assert.assertTrue(dropdownListPage.getOptions().get(optionId - 1).isDisplayed());
    }

}
