package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.*;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class UndoRotation extends BaseProduct {
    public UndoRotation(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void UndoRotationTest() throws InterruptedException {
        test = extent.createTest("Check Undo Redo Rotation");

        test.assignCategory("Sanity");

        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        MobileActions M = new MobileActions(driver);
        TopScreenButton TS = new TopScreenButton(driver);


        B.Rotation.click();
        Log.addLog("TextRotationCase button clicked");
        test.log(Status.INFO, "TextRotationCase button clicked");

        AndroidElement seekbar = (AndroidElement) S.RotationSeekBar;

        M.swipeSeekbarForward(seekbar,80);

        TS.UndoButton.click();
        Log.addLog("Undo button clicked");
        test.log(Status.INFO, "Undo button clicked");

        String screenShotPath3 = MobileActions.Screenshot("Undo Text Rotation Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.RedoButton.click();
        Log.addLog("Redo button clicked");
        test.log(Status.INFO, "Redo button clicked");

        String screenShotPath4 = MobileActions.Screenshot("Redo Text Rotation Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }


        }
}
