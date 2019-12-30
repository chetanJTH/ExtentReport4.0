package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.TopScreenButton;
import utils.Log;

import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class ImageSizeLock extends BaseProduct {
    public ImageSizeLock(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void ImageSizeLockTest() throws InterruptedException {
        test = extent.createTest("Verify Image Size Lock");
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

        String screenShotPath = MobileActions.Screenshot("ZoomIn Lock");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.ZoomOutButton.click();
        Log.addLog("Zoom out button Clicked");
        test.log(Status.INFO, "Zoom Out Button Clicked");

        String screenShotPath1 = MobileActions.Screenshot("ZoomIn Out");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.LockButton.click();
        Log.addLog("Unlock Element");
        test.log(Status.INFO, "Unlock Element By Pressing Lock Button Again");


    }


}
