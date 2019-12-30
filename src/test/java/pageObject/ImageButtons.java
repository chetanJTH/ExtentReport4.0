package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImageButtons {
    public ImageButtons(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnAddImage")
    public WebElement AddImage;

    @AndroidFindBy(id = "android:id/content")
    public WebElement CameraOption;

    @AndroidFindBy(xpath = "//*[@text='Choose Image']")
    public WebElement ChooseImage;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnEraser")
    public WebElement EraseImageButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btn_eraser")
    public WebElement EraseImage;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/img_auto")
    public WebElement AutoEraseImage;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnAddToGallery")
    public WebElement EditImage;





}
