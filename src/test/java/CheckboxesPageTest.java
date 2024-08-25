import com.zawartkawoj.page.CheckboxesPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesPageTest extends BaseTest {

    @Test
    public void checkDefaultBoxesStatusTest() {
        CheckboxesPage checkboxesPage = new HomePage(driver).openCheckboxesPage();

        Assert.assertFalse(checkboxesPage.isCheckboxChecked(1));
        Assert.assertTrue(checkboxesPage.isCheckboxChecked(2));
    }

    @Test
    public void clickBothBoxesOnceTest() {
        CheckboxesPage checkboxesPage = new HomePage(driver)
                .openCheckboxesPage()
                .clickCheckbox(1)
                .clickCheckbox(2);

        Assert.assertTrue(checkboxesPage.isCheckboxChecked(1));
        Assert.assertFalse(checkboxesPage.isCheckboxChecked(2));
    }

}
