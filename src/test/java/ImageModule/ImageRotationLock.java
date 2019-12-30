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

public class ImageRotationLock extends BaseProduct {
    public ImageRotationLock(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImageRotationLockTest() throws InterruptedException {
        test = extent.createTest("Verify Image TextRotationCase Lock");
        test.assignCategory("Functionality");



        AllButtons B = new AllButtons(driver);
        TopScreenButton TS = new TopScreenButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);



        B.Rotation.click();
        Log.addLog("TextRotationCase Button Clicked");
        test.log(Status.INFO, "TextRotationCase Button Clicked");

        B.AntiClockRotate.click();
        Log.addLog("AntiClockRotate Button Clicked");
        test.log(Status.INFO, "AntiClockRotate Button Clicked");

        String screenShotPath = MobileActions.Screenshot("Rotaion Lock");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.ClockWiseRotate.click();
        Log.addLog("ClockWiseRotate Button Clicked");
        test.log(Status.INFO, "ClockWiseRotate Button Clicked");

        String screenShotPath1 = MobileActions.Screenshot("Rotaion Locked");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AndroidElement seekbar = (AndroidElement) S.RotationSeekBar;

        if (M.swipeSeekbarForward(seekbar, 100)) {
            Log.addLog("Text Rotate Forward Successfully");
        } else {
            Log.addLog("Text Does Not Rotate");
        }

        String screenShotPath2 = MobileActions.Screenshot("TextRotationCase Forward");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (M.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Text Rotate  Backward Successfully");
        } else {
            Log.addLog("Text Does Not Rotate");
        }

        String screenShotPath3 = MobileActions.Screenshot("TextRotationCase BackWard");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
