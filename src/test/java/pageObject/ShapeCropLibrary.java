package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShapeCropLibrary {
    public ShapeCropLibrary(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='Crop']")
    public WebElement CropButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnLayShapeCrop")
    public WebElement CropShape;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnLayAspectCrop")
    public WebElement CropAspect;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/image_view_state_scale")
    public WebElement StateScale;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/scale_scroll_wheel")
    public WebElement StateScaleScroll;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/image_view_state_aspect_ratio")
    public WebElement StateAspectRatio;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/image_view_state_rotate")
    public WebElement StateRotate;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/rotate_scroll_wheel")
    public WebElement StateRotateScroll;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/save")
    public WebElement SaveCrop;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/menu_crop")
    public WebElement SaveEditPhoto;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnShape")
    public WebElement BtnShape;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnCancel")
    public WebElement BtnCancel;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnBackground")
    public WebElement BtnBkGround;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnAdjustment")
    public WebElement Adjustment;

    @AndroidFindBy(xpath = "//*[@content-desc='Rotate']")
    public WebElement AdjustRotate;

    @AndroidFindBy(xpath = "//*[@content-desc='Size']")
    public WebElement AdjustSize;



}
