import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.page.LoggedUserPage;
import com.zawartkawoj.page.LoginPage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInOutTest extends BaseTest {

    @Test(priority = 100, description = "Check if entering correct credentials will result in a successful log-in attempt.")
    public void signUpTest() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        new HomePage(driver)
                .openLoginPage()
                .logInWithValidCredentials(username, password);

        Assert.assertTrue(new LoggedUserPage(driver).getMainHeading().isDisplayed());
    }

    @Test(priority = 110, description = "Check if entering empty fields will result in a failed log-in attempt.")
    public void signUpEmptyFormTest() {
        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .logInWithWrongCredentials("", "");

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
    }

    @Test(priority = 120, description = "Check if entering wrong password will result in a failed log-in attempt.")
    public void signUpWrongPasswordTest() {
        String username = "tomsmith";
        String password = "WrongPassword";

        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .logInWithWrongCredentials(username, password);

        Assert.assertTrue(loginPage.getInvalidPasswordError().isDisplayed());
    }

    @Test(priority = 130, description = "Check if log out option works on a logged-in user.")
    public void logOutTest() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .logInWithValidCredentials(username, password)
                .logout();

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
    }

}
