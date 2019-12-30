package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
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

public class ParagraphEdit  extends BaseProduct {
    public ParagraphEdit(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ParagraphEditTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Font Paragraph Edit");
        test.assignCategory("Sanity");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);
        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);



        T.EditText.click();
        Log.addLog("Edit Text Is Clickable");
        test.log(Status.INFO, "Edit Text Button Is Clicked");

        T.iText.click();
        Log.addLog("Click On Text Feild");
        test.log(Status.INFO, "Text Input Feild Clicked");

        T.Paragraph.click();
        Log.addLog("Paragraph CheckBox Is Clickable");
        test.log(Status.INFO, "Paragraph CheckBox Is Clicked");

        T.iText.sendKeys("Although these ideas may look true in many instances, they don’t really define what the idea behind a paragraph is.");
        Log.addLog("Text is Edited");
        test.log(Status.INFO, "Text Is Edited");

        Thread.sleep(1000);
        String screenShotPath2 = MobileActions.Screenshot("Edit Font Paragraph Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.OkButton.click();
        Log.addLog("Press Ok Button");
        test.log(Status.INFO, "Ok Button Pressed");

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("Edit Font Paragraph Text Done");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
