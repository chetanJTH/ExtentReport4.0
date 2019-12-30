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
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class LatterSpace extends BaseProduct {
    public LatterSpace(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void LatterSpaceTest () throws InterruptedException{
        test = extent.createTest("Verify latter Spacing");
        test.assignCategory("Functionality");

        TextButton T = new TextButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);

        LatterSpacingButtonClick();

        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (M.swipeSeekbarForward(seekbar, 70)) {
            Log.addLog("Increase Spacing");
        } else {
            Log.addLog("Spacing SeekBar Not Working");
        }

        String screenShotPath = MobileActions.Screenshot("Increase Latter Spacing");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Thread.sleep(1000);

        if (M.swipeSeekbarBack(seekbar, 100)) {
            Log.addLog("Descrease Spacing");
        } else {
            Log.addLog("Spacing SeekBar Not Working");
        }

        String screenShotPath1 = MobileActions.Screenshot("Descrease Latter Spacing");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SaveButtonClick();

        SelectSaveOption();

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

    public void LatterSpacingButtonClick() {
        TextButton T = new TextButton(driver);

        if (T.LetterSpacing != null) {
            if ((T.LetterSpacing).isDisplayed()) {
                Log.addLog("Letter Spacing Button Is Visible");
                T.LetterSpacing.click();
                Log.addLog("Letter Spacing Button Is Clickable");
                test.log(Status.INFO, "Letter Spacing Button Clicked");
            } else {
                Log.addLog("Letter Spacing Button Is Not Visible");
                test.log(Status.FAIL, "Letter Spacing Button Is Not Visible");
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

    public void SaveButtonClick() {
        AllButtons B = new AllButtons(driver);

        if (B.Save != null) {
            if ((B.Save).isDisplayed()) {
                Log.addLog("Save Button Is Visible");
                B.Save.click();
                Log.addLog("Save Button Clicked");
                test.log(Status.INFO, "Save Button Clicked");
            } else {
                Log.addLog("Save Button Is Not Visible");
                test.log(Status.FAIL, "Save Button Is Not Visible");
            }
        }
    }

    public void SelectSaveOption() {
        AllButtons B = new AllButtons(driver);

        if (B.Original != null) {
            if ((B.Original).isDisplayed()) {
                Log.addLog("Original Option Visible");
                B.Original.click();
                Log.addLog("Original Option Clicked");
                test.log(Status.INFO, "Original Option Clicked");
            } else {
                Log.addLog("Original Option Is Not Visible");
                test.log(Status.FAIL, "Original Option Is Not Visible");
            }
        }
    }

}
