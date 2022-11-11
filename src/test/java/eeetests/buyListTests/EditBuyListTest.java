package eeetests.buyListTests;

import eeetests.BaseTest;
import data.TestData;
import pageObjects.BuyPageObjects;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class EditBuyListTest extends BaseTest {

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkEditBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        BuyPageObjects objects = new BuyPageObjects(this.driver);
        this.steps.addBuyList();
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
