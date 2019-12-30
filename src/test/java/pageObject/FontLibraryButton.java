package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FontLibraryButton {
    public FontLibraryButton(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='Font']")
    public WebElement Font;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnSelectNewFont")
    public WebElement AddFontButton;

    @AndroidFindBy(xpath = "//*[@text='FREE']")
    public WebElement FreeFont;

   @AndroidFindBy(id = "com.nra.productmarketingmaker:id/txtFontName")
    public WebElement downloadedFont;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnGetMore")
    public WebElement GetMore;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnTutorialVideo")
    public WebElement HowTo;

    @AndroidFindBy(xpath = "//*[@text='YouTube']")
    public WebElement TutorialVideo;

    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up']")
    public WebElement NavigateBack;

}
