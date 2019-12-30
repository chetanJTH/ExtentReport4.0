package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageObject.AllSeekBar;
import pageObject.TextButton;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class UndoOpacity extends BaseProduct {
    public UndoOpacity(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void UndoOpacityTest() throws InterruptedException {
        test = extent.createTest("Check Undo Redo Opacity");

        test.assignCategory("Sanity");


        TextButton T = new TextButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);
        TopScreenButton TS = new TopScreenButton(driver);

        T.Opacitybutton.click();
        Log.addLog("Opacity Button Is Clickable");
        test.log(Status.INFO, "Opacity Button Is Clicked");

        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (M.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Descrease Opacity");
        } else {
            Log.addLog("Opacity SeekBar Not Working");
        }

        TS.UndoButton.click();
        Log.addLog("Undo button clicked");
        test.log(Status.INFO, "Undo button clicked");

        String screenShotPath3 = MobileActions.Screenshot("Undo Text Opacity");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.RedoButton.click();
        Log.addLog("Redo button clicked");
        test.log(Status.INFO, "Redo button clicked");

        String screenShotPath4 = MobileActions.Screenshot("Redo Text Opacity");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
