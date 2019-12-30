package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AllSeekBar {
    public AllSeekBar(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/uiControl")
    public WebElement RotationSeekBar;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/hueBar")
    public WebElement ColorSeekBar;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/satValBox")
    public WebElement ColorViewGroup;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/sbControl")
    public WebElement ShadowSeekBar;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/seekbar_size")
    public WebElement SizeSeekBar;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/seekbar_offset")
    public WebElement OffsetSeekbar;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/imgTouchView")
    public WebElement ImgTouchView;





}
