package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class SizeLock extends BaseProduct {
    public SizeLock(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void SizeLockTest() throws InterruptedException {
        test = extent.createTest("Verify Font Size Lock");
        test.assignCategory("Functionality");


        AllButtons B = new AllButtons(driver);
        TopScreenButton TS = new TopScreenButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);


        B.Size.click();
        Log.addLog("Size button clicked");
        test.log(Status.INFO, "Size Button Clicked");

        B.ZoomInButton.click();
        Log.addLog("Zoom in button clicked");
        test.log(Status.INFO, "Zoom In Button Clicked");

        String screenShotPath = MobileActions.Screenshot("Max Size Lock");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.ZoomOutButton.click();
        Log.addLog("Zoom out button Clicked");
        test.log(Status.INFO, "Zoom Out Button Clicked");

        String screenShotPath1 = MobileActions.Screenshot("Min Size Lock");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.LockButton.click();
        Log.addLog("Unlock Element");
        test.log(Status.INFO, "Unlock Element By Pressing Lock Button Again");

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
