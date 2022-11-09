package eeetests.myListTests;

import eeetests.BaseTest;
import eeetests.data.TestData;
import eeetests.pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakeProductFromMyListTest extends BaseTest {
    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkTakeProductFromMyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        MyListPageObjects objects = new MyListPageObjects(this.driver);
        this.steps.addBuyList();
        this.steps.addProductToBuyList();
        objects.productMyList.click();
        WebElement ele = objects.productMyList;
        this.elements.longPressAction(ele);
        objects.addToMyListButton.click();
        this.elements.longPressAction(ele);
        objects.deleteProductButton.click();
        objects.okButton.click();
        objects.actionMenuButton.click();
        objects.addFromMyListButton.click();
        Assert.assertEquals(objects.productNameInMyList.getText(),productName);
        objects.pickProduct.click();
        objects.saveProductButton.click();
        Assert.assertEquals(objects.productNameInBuyList.getText(),productName);
    }
}
