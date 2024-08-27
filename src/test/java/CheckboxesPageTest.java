import com.zawartkawoj.page.CheckboxesPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesPageTest extends BaseTest {

    @Test(priority = 0, description = "Checking if boxes are in their default state.")
    @Description("A check if box no. 1 is unchecked, and box no. 2 is checked.")
    public void checkDefaultBoxesStatusTest() {
        CheckboxesPage checkboxesPage = new HomePage(driver).openCheckboxesPage();

        Assert.assertFalse(checkboxesPage.isCheckboxChecked(1));
        Assert.assertTrue(checkboxesPage.isCheckboxChecked(2));
    }

    @Test(priority = 0, description = "Clicking each checkbox.")
    @Description("Checking if both boxes change their status by clicking on them.")
    public void clickBothBoxesOnceTest() {
        CheckboxesPage checkboxesPage = new HomePage(driver)
                .openCheckboxesPage()
                .clickCheckbox(1)
                .clickCheckbox(2);

        Assert.assertTrue(checkboxesPage.isCheckboxChecked(1));
        Assert.assertFalse(checkboxesPage.isCheckboxChecked(2));
    }

}
