package eeetests.buyListTests;

import eeetests.BaseTest;
import eeetests.data.TestData;
import eeetests.pageObjects.BuyPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditBuyListTest extends BaseTest {
    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkEditBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        BuyPageObjects objects = new BuyPageObjects(this.driver);
        this.steps.addBuyList();
        Assert.assertEquals(objects.listName.getText(),nameBuyList);
        this.driver.navigate().back();
        this.driver.navigate().back();
        Assert.assertEquals(objects.listTitle.getText(),nameBuyList);
        objects.editBuyListButton.click();
        objects.changeNameBuyList.clear();
        objects.changeNameBuyList.sendKeys(edit);
        objects.okButton.click();
        Assert.assertEquals(objects.newNameBuyList.getText(),edit);
    }
}
