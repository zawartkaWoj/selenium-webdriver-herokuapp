import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.page.LoggedUserPage;
import com.zawartkawoj.page.LoginPage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInOutTest extends BaseTest {

    @Test(priority = 0, description = "Signing in with valid credentials.")
    @Description("Check if correct credentials will sign in to the system.")
    public void signUpTest() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        LoggedUserPage loggedUserPage = new HomePage(driver)
                .openLoginPage()
                .loginWithValidCredentials(username, password);

        Assert.assertTrue(loggedUserPage.getMainHeading().isDisplayed());
    }

    @Test(priority = 0, description = "Signing in with empty form.")
    @Description("Check if empty log in form will result in unsuccessful log in attempt.")
    public void signUpEmptyFormTest() {
        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .loginWithInvalidCredentials("", "");

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
    }

    @Test(priority = 0, description = "Signing in with incorrect password.")
    @Description("Check if wrong password will result in unsuccessful log in attempt and correct error message.")
    public void signUpWrongPassword() {
        String username = "tomsmith";
        String password = "WrongPassword";

        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .loginWithInvalidCredentials(username, password);

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
        Assert.assertTrue(loginPage.getInvalidPasswordError().isDisplayed());
    }

    @Test(priority = 0, description = "Signing out.")
    @Description("Check if log out option successfully logs user out and returns to log in page.")
    public void logOutTest() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .loginWithValidCredentials(username, password)
                .logout();

        Assert.assertTrue(loginPage.getMainHeading().isDisplayed());
    }

}
