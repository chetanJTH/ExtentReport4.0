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
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class UndoShadow  extends BaseProduct {
    public UndoShadow(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void UndoShadowTest() throws InterruptedException {
        test = extent.createTest("Check Undo Redo Shadow");
        test.assignCategory("Sanity");


        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        MobileActions M = new MobileActions(driver);
        TopScreenButton TS = new TopScreenButton(driver);




        B.ShadowButton.click();
        Log.addLog("Shadow Button Clickable");
        test.log(Status.INFO, "Shadow Button Clicked");

        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (M.shadowSeekBarForward(seekbar, 100)) {
            Log.addLog("Max Shadow");
        } else {
            Log.addLog("Shadow Not Applied");
        }

        TS.UndoButton.click();
        Log.addLog("Undo button clicked");
        test.log(Status.INFO, "Undo button clicked");

        String screenShotPath3 = MobileActions.Screenshot("Undo Text Shadow");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.RedoButton.click();
        Log.addLog("Redo button clicked");
        test.log(Status.INFO, "Redo button clicked");

        String screenShotPath4 = MobileActions.Screenshot("Redo Text Shadow");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
