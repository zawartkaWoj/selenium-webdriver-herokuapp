import com.zawartkawoj.page.DropdownListPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownListPageTest extends BaseTest {

    @Test
    public void listOpensSuccesfullyTest() {
        DropdownListPage dropdownListPage = new HomePage(driver)
                .openDropdownListPage()
                .clickOnList();

        for(WebElement option : dropdownListPage.getOptions()) {
            Assert.assertTrue(option.isDisplayed());
        }
    }

    @Test //Pick only options 1 or 2
    public void chooseOption(int optionId) {

        //clickOnList() method is called twice due to the dropdown list not closing upon clicking an option
        DropdownListPage dropdownListPage = new HomePage(driver)
                .openDropdownListPage()
                .clickOnList()
                .clickOption(optionId)
                .clickOnList();

        Assert.assertTrue(dropdownListPage.getOptions().get(optionId - 1).isDisplayed());
    }

}
