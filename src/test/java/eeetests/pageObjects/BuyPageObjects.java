package eeetests.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPageObjects {

    public BuyPageObjects(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView")
    public WebElement listName;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]")
    public WebElement productNameInBuyList;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1]")
    public WebElement listTitle;

    @FindBy(id = "com.slava.buylist:id/editText1")
    public WebElement editNameBuyList;

    @FindBy(id = "com.slava.buylist:id/button2")
    public WebElement addBuyListButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[2]")
    public WebElement deleteBuyListButton;

    @FindBy(id = "com.slava.buylist:id/imageView2")
    public WebElement editBuyListButton;

    @FindBy(id = "android:id/button1")
    public WebElement okButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText")
    public WebElement changeNameBuyList;

    @FindBy(id = "com.slava.buylist:id/title")
    public WebElement newNameBuyList;

}
