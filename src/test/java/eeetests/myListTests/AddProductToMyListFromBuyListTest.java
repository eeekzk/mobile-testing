package eeetests.myListTests;

import eeetests.BaseTest;
import data.TestData;
import pageObjects.MyListPageObjects;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class AddProductToMyListFromBuyListTest extends BaseTest {

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkAddProductToMyListFromBuyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        MyListPageObjects objects = new MyListPageObjects(this.driver);
        this.steps.addBuyList();
        this.steps.addProductToBuyList();
        WebElement ele = objects.productMyList;
        this.elements.longPressAction(ele);
        objects.addToMyListButton.click();
        objects.actionMenuButton.click();
        objects.addFromMyListButton.click();
        assertEquals(objects.productNameInMyList.getText(),productName);
    }
}
