import com.zawartkawoj.page.AddRemoveElementsPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddRemovePageTest extends BaseTest {

    @Test(priority = 0, description = "Adding one element.")
    @Description("Check if the element has been successfully added.")
    public void addOneElementTest() {
        int timesToClick = 1;

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);

        int timesClicked = addRemoveElementsPage.getAddedElementsCount();

        Assert.assertEquals(timesToClick, timesClicked);
    }

    @Test(priority = 0, description = "Adding random amount of elements between 1 and 10.")
    @Description("Check if added elements count is equal to the amount of clicks performed.")
    public void addRandomAmountOfElementsTest() {
        int timesToClick = new Random().nextInt(1, 11);

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);

        int timesClicked = addRemoveElementsPage.getAddedElementsCount();

        Assert.assertEquals(timesToClick, timesClicked);
    }

    @Test(priority = 0, description = "Adding 10 elements and then removing a random number of them ranging between 1 and 10.")
    @Description("Check if the difference between added and deleted elements is correct.")
    public void addTenElementsAndRemoveRandomAmountTest() {
        int timesToClick = 10;
        int elementsToRemove = new Random().nextInt(1, 11);

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);
        addRemoveElementsPage.removeElements(elementsToRemove);

        Assert.assertEquals(addRemoveElementsPage.getAddedElementsCount(), timesToClick - elementsToRemove);
    }

    private AddRemoveElementsPage addElements(int timesToClick) {
        AddRemoveElementsPage addRemoveElementsPage = new HomePage(driver).openAddRemoveElementsPage();
        addRemoveElementsPage.clickAddElementButton(timesToClick);
        return addRemoveElementsPage;
    }

}
