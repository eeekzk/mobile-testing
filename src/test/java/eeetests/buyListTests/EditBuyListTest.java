package eeetests.buyListTests;

import eeetests.BaseTest;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import pageObjects.BuyPageObjects;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class EditBuyListTest extends BaseTest {

    public BuyPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new BuyPageObjects(driver);
    }

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkEditBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        steps.addBuyList();
        assertEquals(objects.listName.getText(),nameBuyList);
        elements.back();
        elements.back();
        assertEquals(objects.listTitle.getText(),nameBuyList);
        objects.editBuyListButton.click();
        objects.changeNameBuyList.clear();
        objects.changeNameBuyList.sendKeys(edit);
        objects.okButton.click();
        assertEquals(objects.newNameBuyList.getText(),edit);
    }
}
