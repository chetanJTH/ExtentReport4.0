package pageObject;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class myDesignPage {
    public myDesignPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MY DESIGNS']")
    public WebElement MYDESIGN;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/categoryName")
    public WebElement CreateOwn;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnInstaPortrait")
    public WebElement IstaPortrait;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/card_view")
    public WebElement CardView;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/txt_preview_failed")
    public WebElement AutoSave;
}