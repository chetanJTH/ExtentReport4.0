package FontModule;

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

public class TextSize extends BaseProduct {

    public TextSize(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void TextSizeTest() throws InterruptedException {
        test = extent.createTest("Verify Font Size Change");

        test.assignCategory("Functionality");

        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        MobileActions M = new MobileActions(driver);

        B.Size.isDisplayed();
        Log.addLog("Size Button is Displayed");

        B.Size.click();
        Log.addLog("Size Button is Clickable");
        test.log(Status.INFO, "Size Button Clicked");

        B.ZoomInButton.isDisplayed();
        Log.addLog("ZoomInButton Button is Displayed");

        B.ZoomInButton.click();
        Log.addLog("ZoomInButton button is Clickable");
        test.log(Status.INFO, "ZoomInButton Button Clicked");

        B.ZoomOutButton.isDisplayed();
        Log.addLog("ZoomOutButton Button is Displayed");

        B.ZoomOutButton.click();
        Log.addLog("ZoomOutButton button is Clickable");
        test.log(Status.INFO, "ZoomOutButton Button Clicked");

        AndroidElement seekbar = (AndroidElement) S.RotationSeekBar;

        if (M.swipeSeekbarForward(seekbar, 70)) {
            Log.addLog("Text Zoom In");
        } else {
            Log.addLog("Text Does Not Zoom");
        }

        String screenShotPath = MobileActions.Screenshot("Text Max Size");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);

        if (M.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Text Zoom Out");
        } else {
            Log.addLog("Text Does Not Zoom Out");
        }
        String screenShotPath1 = MobileActions.Screenshot("Text Min Size");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
