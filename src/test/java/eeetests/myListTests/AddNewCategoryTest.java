package eeetests.myListTests;

import eeetests.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import pageObjects.MyListPageObjects;
import org.testng.annotations.Test;

public class AddNewCategoryTest extends BaseTest {

    public MyListPageObjects objects;

    @BeforeMethod
    public void setUp() {
        objects = new MyListPageObjects(driver);
    }

    @Test
    public void checkAddCategory() {
        //use Drag&Drop
        objects.actionMenuButton.click();
        objects.settingsButton.click();
        elements.scrollToText("Categories List");
        objects.categoriesListButton.click();
        objects.editCategoryName.sendKeys("New Category");
        objects.okButton.click();
        elements.scrollToText("New Category");
        WebElement ele = objects.sourceNewCategory;
        this.elements.dragDrop(ele);
    }
}
