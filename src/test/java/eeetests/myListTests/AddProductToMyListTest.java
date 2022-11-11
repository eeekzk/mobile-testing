package eeetests.myListTests;

import eeetests.BaseTest;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import pageObjects.MyListPageObjects;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class AddProductToMyListTest extends BaseTest {

    public MyListPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new MyListPageObjects(driver);
    }

    @Test(dataProvider = "getData", dataProviderClass = TestData.class)
    public void checkAddProductToMyList(String nameBuyList, String productName, String price, String amount, String comment, String edit) {
        objects.actionMenuButton.click();
        objects.productInput.click();
        steps.addProductToBuyList();
        assertEquals(objects.productNameInBuyList.getText(),productName);
    }
}
