package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ColorLibrary {
    public ColorLibrary(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='Color']")
    public WebElement Color;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnColorPicker")
    public WebElement ColorPicker;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/pickButton")
    public WebElement ColorPickButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/cancelButton")
    public WebElement CancelButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/hexVal")
    public WebElement ColorCode;



}
