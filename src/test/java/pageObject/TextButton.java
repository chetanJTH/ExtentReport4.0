package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TextButton {
    public TextButton(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnAddText")
    public WebElement AddTextButton;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/ipText")
    public WebElement iText;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnEditText")
    public WebElement EditText;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnUnderline")
    public WebElement Underline;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnUpperCase")
    public WebElement UpperCase;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnLowerCase")
    public WebElement LowerCase;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnTitleCase")
    public WebElement TitleCase;

    @AndroidFindBy(xpath = "//*[@content-desc='Style']")
    public WebElement Stylebutton;


    @AndroidFindBy(xpath = "//*[@content-desc='Opacity']")
    public WebElement Opacitybutton;

    @AndroidFindBy(xpath = "//*[@content-desc='Letter Spacing']")
    public WebElement LetterSpacing;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/isAutoParagraph")
    public WebElement Paragraph;

    @AndroidFindBy(xpath = "//*[@content-desc='Vertical Spacing']")
    public WebElement VerticalSpacing;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnLeftAlignment")
    public WebElement LeftAlignment;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnCenterAlignment")
    public WebElement CenterAlignment;

    @AndroidFindBy(id = "com.nra.productmarketingmaker:id/btnRightAlignment")
    public WebElement RightAlignment;
}
