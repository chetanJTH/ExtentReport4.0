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
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class ImageRotation extends BaseProduct {
    public ImageRotation(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImageRotationTest() throws InterruptedException {
        test = extent.createTest("Verify Image TextRotationCase");

        test.assignCategory("Functionality");


        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        MobileActions M = new MobileActions(driver);


        B.Rotation.click();
        Log.addLog("TextRotationCase Button is Clickable");
        test.log(Status.INFO, "TextRotationCase Button Clicked");

        B.AntiClockRotate.click();
        Log.addLog("AntiClockRotate button is Clickable");
        test.log(Status.INFO, "AntiClockRotate Button Clicked");

        B.ClockWiseRotate.click();
        Log.addLog("ClockWiseRotate button is Clickable");
        test.log(Status.INFO, "ClockWiseRotate Button Clicked");


        AndroidElement seekbar = (AndroidElement) S.RotationSeekBar;

        if (M.swipeSeekbarForward(seekbar, 100)) {
            Log.addLog("Image Rotate Forward Successfully");
        } else {
            Log.addLog("Image Does Not Rotate");
        }

        String screenShotPath = MobileActions.Screenshot("TextRotationCase Forward");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (M.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Image Rotate  Backward Successfully");
        } else {
            Log.addLog("Image Does Not Rotate");
        }

        String screenShotPath1 = MobileActions.Screenshot("TextRotationCase BackWard");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}