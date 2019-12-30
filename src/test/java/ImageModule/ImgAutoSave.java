package ImageModule;

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

public class ImgAutoSave extends BaseProduct {
    public ImgAutoSave(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImgAutoSaveTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Image AutoSave");

        test.assignCategory("Sanity");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);
        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);


        wait.until(ExpectedConditions.elementToBeClickable(D.MYDESIGN));
        D.MYDESIGN.click();
        Log.addLog("Select MyDesign Page");

        Thread.sleep(1000);
        String screenShotPath2 = MobileActions.Screenshot("MyDesignPage");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AutoSaveCardClick();

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("AutoSaveEditPage");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.Editbutton.click();
        Log.addLog("Select Edit Button");

        Thread.sleep(1000);
        String screenShotPath4 = MobileActions.Screenshot("AutoSaveCanvasView");
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
