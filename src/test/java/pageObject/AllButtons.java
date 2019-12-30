package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AllButtons {
    public AllButtons(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnEdit")
    public WebElement Editbutton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnOk")
    public WebElement OkButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnControlTop")
    public WebElement TopPositionButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnControlBottom")
    public WebElement BottomPositionButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnControlLeft")
    public WebElement LeftPositionButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnControlRight")
    public WebElement RightPositionButton;

    @AndroidFindBy(xpath = "//*[@content-desc='Rotation']")
    public WebElement Rotation;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnAntiClockWiseRotate")
    public WebElement AntiClockRotate;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnClockWiseRotate")
    public WebElement ClockWiseRotate;

    @AndroidFindBy(xpath = "//*[@content-desc='Size']")
    public WebElement Size;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnZoomOut")
    public WebElement ZoomOutButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnZoomIn")
    public WebElement ZoomInButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnCancel")
    public WebElement BackButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnSkip")
    public WebElement Skip;

    @AndroidFindBy(xpath = "//*[@content-desc='Shadow']")
    public WebElement ShadowButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnSave")
    public WebElement Save;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnShapes")
    public WebElement Shape;

    @AndroidFindBy(xpath = "//*[@content-desc='Pick Your Own']")
    public WebElement PickYourOwn;

    @AndroidFindBy(xpath = "//*[@text='Original (1080 × 1350)']")
    public WebElement Original;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/dialog_rating_button_positive")
    public WebElement NotNow;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnHome")
    public WebElement Home;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnSetting")
    public WebElement Setting;

    @AndroidFindBy(xpath = "//*[@content-desc='FEATURED']")
    public WebElement FEATURED;

    @AndroidFindBy(xpath = "//*[@content-desc='CATEGORIES']")
    public WebElement CATEGORIES;

    @AndroidFindBy(xpath = "//*[@content-desc='TOOLS']")
    public WebElement TOOLS;

    @AndroidFindBy(xpath = "//*[@text='Original (650 × 800)']")
    public WebElement Portrait;



}
