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
import pageObject.ImageButtons;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.time.Duration;

public class EraseMinimize extends BaseProduct {
    public EraseMinimize(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void EraseMinimizeTest() throws InterruptedException{
        test = extent.createTest("Erase Image Minimize");
        test.assignCategory("Smoke");


        ImageButtons I = new ImageButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        MobileActions M = new MobileActions(driver);
        AllButtons B = new AllButtons(driver);
        TopScreenButton T = new TopScreenButton(driver);

        I.EraseImageButton.click();
        Log.addLog("Erase Button Clickable");
        test.log(Status.INFO, "Erase Button Clicked");

        I.EraseImage.click();
        Log.addLog("EraseImage Button Clickable");
        test.log(Status.INFO, "Erase Image Button Clicked");

        AndroidElement seekbar = (AndroidElement) S.SizeSeekBar;
        M.swipeSeekbarForward(seekbar,100);

        AndroidElement seekbar1 = (AndroidElement) S.OffsetSeekbar;
        M.swipeSeekbarBack(seekbar1,100);

        AndroidElement seekbar2 = (AndroidElement) S.ImgTouchView;
        M.viewGroupForward(seekbar2,50,50);

        B.Save.click();
        Log.addLog("Save Button Clickable");
        test.log(Status.INFO, "Save Button Clicked");

        driver.runAppInBackground(Duration.ofSeconds(5));
        Log.addLog("App Minimize");
        test.log(Status.INFO, "App Minimiz");

        String screenShotPath = MobileActions.Screenshot("App Minimize");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.currentActivity();

        String screenShotPath1 = MobileActions.Screenshot("Erase Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        T.UndoButton.click();
        Log.addLog("Undo Button Clicked");
        test.log(Status.INFO, "Undo Button Clicked");
    }
}
