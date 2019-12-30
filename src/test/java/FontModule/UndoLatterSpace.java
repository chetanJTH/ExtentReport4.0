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
import pageObject.TextButton;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class UndoLatterSpace extends BaseProduct {
    public UndoLatterSpace(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void UndoLatterSpaceTest() throws InterruptedException {
        test = extent.createTest("Check Undo Redo LatterSpace");

        test.assignCategory("Sanity");

        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);
        TopScreenButton TS = new TopScreenButton(driver);

        T.LetterSpacing.click();
        Log.addLog("Letter Spacing Button Is Clickable");
        test.log(Status.INFO, "Letter Spacing Button Clicked");

        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (M.swipeSeekbarForward(seekbar, 70)) {
            Log.addLog("Increase Spacing");
        } else {
            Log.addLog("Spacing SeekBar Not Working");
        }

        TS.UndoButton.click();
        Log.addLog("Undo button clicked");
        test.log(Status.INFO, "Undo button clicked");

        String screenShotPath3 = MobileActions.Screenshot("Undo Latter Space");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.RedoButton.click();
        Log.addLog("Redo button clicked");
        test.log(Status.INFO, "Redo button clicked");

        String screenShotPath4 = MobileActions.Screenshot("Redo Latter Space");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
