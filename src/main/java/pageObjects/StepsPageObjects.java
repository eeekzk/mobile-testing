package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StepsPageObjects {
    public StepsPageObjects(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText")
    public WebElement productName;

    @FindBy(id = "com.slava.buylist:id/editText1")
    public WebElement editNameBuyList;

    @FindBy(id = "com.slava.buylist:id/button2")
    public WebElement addBuyListButton;

    @FindBy(id = "com.slava.buylist:id/editText2")
    public WebElement productPrice;

    @FindBy(id = "com.slava.buylist:id/editText3")
    public WebElement productAmount;

    @FindBy(id = "com.slava.buylist:id/editText4")
    public WebElement productComment;

    @FindBy(id = "com.slava.buylist:id/spinner1")
    public WebElement productValue;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[10]")
    public WebElement productUnit;

    @FindBy(id = "com.slava.buylist:id/spinner2")
    public WebElement productCategoryButton;

    @FindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[10]")
    public WebElement productCategory;
}
