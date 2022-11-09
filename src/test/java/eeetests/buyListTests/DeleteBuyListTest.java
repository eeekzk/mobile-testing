package eeetests.buyListTests;

import eeetests.BaseTest;
import eeetests.data.TestData;
import eeetests.pageObjects.BuyPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBuyListTest extends BaseTest {
    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkDeleteBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        BuyPageObjects objects = new BuyPageObjects(this.driver);
        this.steps.addBuyList();
        Assert.assertEquals(objects.listName.getText(),nameBuyList);
        this.driver.navigate().back();
        this.driver.navigate().back();
        Assert.assertEquals(objects.listTitle.getText(),nameBuyList);
        objects.deleteBuyListButton.click();
        objects.okButton.click();
    }
}
