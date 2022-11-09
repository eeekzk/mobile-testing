package eeetests.buyListTests;

import eeetests.BaseTest;
import eeetests.data.TestData;
import eeetests.pageObjects.BuyPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBuyListTest extends BaseTest {
    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkCreateBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        BuyPageObjects objects = new BuyPageObjects(this.driver);
        objects.editNameBuyList.sendKeys(nameBuyList);
        objects.addBuyListButton.click();
        Assert.assertEquals(objects.listName.getText(),nameBuyList);
        this.driver.navigate().back();
        this.driver.navigate().back();
        Assert.assertEquals(objects.listTitle.getText(),nameBuyList);
    }
}
