import com.zawartkawoj.page.AddRemoveElementsPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddRemovePageTest extends BaseTest {

    //Adds
    @Test(priority = 100, enabled = true, description = "Check if a single element has been added")
    public void addOneElementTest() {
        int timesToClick = 1;

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);

        int timesClicked = addRemoveElementsPage.getAddedElementsCount();

        Assert.assertEquals(timesToClick, timesClicked);
    }

    @Test(priority = 110, enabled = true,
            description = "Check if a random number of clicks between 1 and 10 added the same amount of elements")
    public void addRandomAmountOfElementsTest() {
        int timesToClick = new Random().nextInt(1, 11);

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);

        int timesClicked = addRemoveElementsPage.getAddedElementsCount();

        Assert.assertEquals(timesToClick, timesClicked);
    }

    @Test(priority = 120, enabled = true,
            description = "Check if removing random amount of elements between 1 and 10 returns correct number")
    public void removeRandomAmountOfElementsTest() {
        int timesToClick = 10;
        int elementsToRemove = new Random().nextInt(1, 11);

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);
        addRemoveElementsPage.removeElements(elementsToRemove);

        Assert.assertEquals(addRemoveElementsPage.getAddedElementsCount(), timesToClick - elementsToRemove);
    }

    //Helper method that adds a specified amount of elements
    private AddRemoveElementsPage addElements(int timesToClick) {
        AddRemoveElementsPage addRemoveElementsPage = new HomePage(driver).openAddRemoveElementsPage();
        addRemoveElementsPage.addElement(timesToClick);
        return addRemoveElementsPage;
    }

}
