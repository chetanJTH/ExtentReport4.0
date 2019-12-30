package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.TextButton;
import pageObject.myDesignPage;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;
import java.io.IOException;
import java.util.NoSuchElementException;

public class FontParagraph  extends BaseProduct {
    public FontParagraph(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontParagraphTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Font Paragraph");
        test.assignCategory("Sanity");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);
        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);


        D.MYDESIGN.click();
        Log.addLog("My Design Button Clickable");
        test.log(Status.INFO, "My Design Button Is Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(D.CreateOwn));

        D.CreateOwn.click();
        Log.addLog("Create Own Button Clickable");
        test.log(Status.INFO, "Create Own Button Is Clicked");

//        wait.until(ExpectedConditions.elementToBeClickable(B.Editbutton));
//        B.Editbutton.click();
//        Log.addLog("Select Edit Button");

        wait.until(ExpectedConditions.elementToBeClickable(D.IstaPortrait));
        D.IstaPortrait.click();
        Log.addLog("Custom Size Selected");

        T.AddTextButton.click();
        Log.addLog("AddText Button Clickable");
        test.log(Status.INFO, "AddText Button Is Clicked");

        Thread.sleep(2000);

        T.iText.click();
        Log.addLog("Click On Text Feild");
        test.log(Status.INFO, "Text Input Feild Clicked");

        PragraphButton();

        T.iText.sendKeys(" The crafting of clear, coherent paragraphs is the subject of considerable stylistic debate. The form varies among different types of writing. ");
        Log.addLog("Text is Entered");
        test.log(Status.INFO, "Text Is Entered");

        Thread.sleep(1000);
        String screenShotPath2 = MobileActions.Screenshot("Edit Paragraph Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.OkButton.click();
        Log.addLog("Press Ok Button");
        test.log(Status.INFO, "Ok Button Pressed");

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("Edit Paragraph Text Done");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void PragraphButton(){
        TextButton T = new TextButton(driver);

        if (T.Paragraph != null) {
            if ((T.Paragraph).isDisplayed()) {
                Log.addLog("Paragraph CheckBox Is Visible");
                T.Paragraph.click();
                Log.addLog("Paragraph CheckBox Is Clickable");
                test.log(Status.INFO, "Paragraph CheckBox Is Clicked");
            } else {
                Log.addLog("Paragraph CheckBox Is Not Visible");
            }
        }
    }
}
