package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.TextButton;
import pageObject.myDesignPage;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.NoSuchElementException;

public class ImgSave extends BaseProduct {
    public ImgSave(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImgSaveTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Image Save");

        test.assignCategory("Sanity");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllSeekBar S = new AllSeekBar(driver);
        myDesignPage D = new myDesignPage(driver);
        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);



        B.Save.click();
        Log.addLog("Save Button Clicked");
        test.log(Status.INFO, "Save Button Clicked");

        B.Original.click();
        Log.addLog("Original Option Clicked");
        test.log(Status.INFO, "Original Option Clicked");



        try {
            clickRateUsDialog();
        } catch (Throwable e) {

            e.printStackTrace();
            Log.addLog("Rating button NOT Present");

            try {
                clickHomeButton();
            } catch (Throwable th) {
                th.printStackTrace();
                Log.addLog("HOME button NOT Present");
            }

        }

        wait.until(ExpectedConditions.elementToBeClickable(D.MYDESIGN));
        D.MYDESIGN.click();
        Log.addLog("Select MyDesign Page");

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("MyDesignView");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SaveCardClick();


        Thread.sleep(1000);
        String screenShotPath4 = MobileActions.Screenshot("SaveCanvasView");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public void SaveCardClick() {
        myDesignPage M = new myDesignPage(driver);

        if (M.CardView != null) {
            if ((M.CardView).isDisplayed()) {
                M.CardView.click();
                Log.addLog("Card Is Present In My Design");
                Log.addLog("Saved Card Is Present In My Design");
                    test.log(Status.INFO, "Saved Card Is Present In My Design");
                } else{
                    Log.addLog("Card Is Not Present In My Design");
                    test.log(Status.FAIL, "Card Is Not Present In My Design");
                }
            }
        }


    private void clickRateUsDialog() {
        AllButtons B = new AllButtons(driver);
        if (B.NotNow != null) {
            if (B.NotNow.isDisplayed()) {
                B.NotNow.click();
                B.Home.click();
                Log.addLog("NotNow Button Clicked");
                test.log(Status.INFO, "NotNow Button Clicked");

            } else {

                Log.addLog("NotNow Button Not Present");
                test.log(Status.INFO, "NotNow Button Not Present");
            }
        }
    }

    private void clickHomeButton() {
        AllButtons B = new AllButtons(driver);
        if (B.Home != null) {
            if (B.Home.isDisplayed()) {
                B.Home.click();
                Log.addLog("Home Button Clicked");
                test.log(Status.INFO, "Home Button Clicked");
            } else {
                Log.addLog("Home Button Not Present");
                test.log(Status.INFO, "Home Button Not Present");
            }
        }
    }
}
