import com.zawartkawoj.page.AddRemoveElementsPage;
import com.zawartkawoj.page.HomePage;
import com.zawartkawoj.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddRemovePageTest extends BaseTest {

    @Test
    public void addOneElementTest() {
        int timesToClick = 1;

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);

        int timesClicked = addRemoveElementsPage.getAddedElementsCount();

        Assert.assertEquals(timesToClick, timesClicked);
    }

    @Test
    public void addRandomAmountOfElementsTest() {
        int timesToClick = new Random().nextInt(1, 11);

        AddRemoveElementsPage addRemoveElementsPage = addElements(timesToClick);

        int timesClicked = addRemoveElementsPage.getAddedElementsCount();

        Assert.assertEquals(timesToClick, timesClicked);
    }

    @Test
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
