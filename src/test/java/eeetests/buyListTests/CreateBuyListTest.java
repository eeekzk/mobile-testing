package eeetests.buyListTests;

import eeetests.BaseTest;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import pageObjects.BuyPageObjects;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class CreateBuyListTest extends BaseTest {

    public BuyPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new BuyPageObjects(driver);
    }

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkCreateBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        objects.editNameBuyList.sendKeys(nameBuyList);
        objects.addBuyListButton.click();
        assertEquals(objects.listName.getText(),nameBuyList);
        elements.back();
        elements.back();
        assertEquals(objects.listTitle.getText(),nameBuyList);
    }
}
