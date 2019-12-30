package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TopScreenButton {
    public TopScreenButton(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnLayer")
    public WebElement LayerButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnCopy")
    public WebElement CopyButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnLock")
    public WebElement LockButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnUndo")
    public WebElement UndoButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnRedo")
    public WebElement RedoButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnSave")
    public WebElement SaveButton;
}
