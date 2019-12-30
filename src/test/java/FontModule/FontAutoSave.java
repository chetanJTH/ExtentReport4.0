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
import java.io.IOException;
import java.util.NoSuchElementException;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

public class FontAutoSave extends BaseProduct {
    public FontAutoSave(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontAutoSaveTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Font AutoSave");
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


        T.iText.sendKeys(" AutoSave ");
        Log.addLog("Text is Entered");
        test.log(Status.INFO, "Text Is Entered");

        Thread.sleep(1000);
        String screenShotPath = MobileActions.Screenshot("Text Enter");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.OkButton.click();
        Log.addLog("Press Ok Button");
        test.log(Status.INFO, "Ok Button Pressed");

        Thread.sleep(1000);
        String screenShotPath1 = MobileActions.Screenshot(" Text Enter Done");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.closeApp();
        driver.launchApp();

        wait.until(ExpectedConditions.elementToBeClickable(D.MYDESIGN));
        D.MYDESIGN.click();
        Log.addLog("Select MyDesign Page");

        Thread.sleep(1000);
        String screenShotPath2 = MobileActions.Screenshot("My Design Page");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AutoSaveCardClick();

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("Auto Save Edit Page");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.Editbutton.click();
        Log.addLog("Select Edit Button");

        Thread.sleep(1000);
        String screenShotPath4 = MobileActions.Screenshot("Auto Save Canvas View");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void AutoSaveCardClick() {
        myDesignPage M = new myDesignPage(driver);

        if (M.CardView != null) {
            if ((M.CardView).isDisplayed()) {
                Log.addLog("Card Is Present In My Design");
                if ((M.AutoSave).isDisplayed()) {
                    Log.addLog("AutoSave Card Is Present In My Design");
                    M.AutoSave.click();
                    Log.addLog("AutoSave Card Clicked");
                    test.log(Status.INFO, "AutoSave Card Clicked");
                } else {
                    Log.addLog("Card Is Not Present In My Design");
                    test.log(Status.FAIL, "Card Is Not Present In My Design");
                }
            }
        }
    }

}

