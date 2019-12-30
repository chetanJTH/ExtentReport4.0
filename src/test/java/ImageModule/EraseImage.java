package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.ImageButtons;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class EraseImage extends BaseProduct {
    public EraseImage(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void EraseImageTest() throws InterruptedException{
        test = extent.createTest("Erase Image or Sticker");
        test.assignCategory("Smoke");

        AllSeekBar S = new AllSeekBar(driver);
        MobileActions M = new MobileActions(driver);
        TopScreenButton T = new TopScreenButton(driver);

        EraseEditorButton();

        EraseImageButton();

        AndroidElement seekbar = (AndroidElement) S.SizeSeekBar;
        M.swipeSeekbarForward(seekbar,100);

        AndroidElement seekbar1 = (AndroidElement) S.OffsetSeekbar;
        M.swipeSeekbarBack(seekbar1,100);

        AndroidElement seekbar2 = (AndroidElement) S.ImgTouchView;
        M.viewGroupForward(seekbar2,50,50);

        SaveButton();

        String screenShotPath = MobileActions.Screenshot("Erase Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        T.UndoButton.click();
        Log.addLog("Undo Button Clicked");
        test.log(Status.INFO, "Undo Button Clicked");

    }

    public void EraseEditorButton() {
        ImageButtons I = new ImageButtons(driver);

        if (I.EraseImageButton != null && I.EraseImageButton.isDisplayed()) {
                Log.addLog("Erase Button Is Visible");
                I.EraseImageButton.click();
                Log.addLog("Erase Button Clickable");
                test.log(Status.INFO, "Erase Button Clicked");
            } else {

            Log.addLog("Erase Button Not Visible");
            test.log(Status.FAIL, "Erase Button Not Visible");
        }
    }

    public void EraseImageButton() {
        ImageButtons I = new ImageButtons(driver);

            if (I.EraseImage != null && I.EraseImage.isDisplayed()) {
                Log.addLog("EraseImage Button Is Visible");
                I.EraseImage.click();
                Log.addLog("EraseImage Button Clickable");
                test.log(Status.INFO, "Erase Image Button Clicked");
            } else {

            Log.addLog("EraseImage Button Not Visible");
            test.log(Status.FAIL, "Erase Image Button Not Visible");
        }
    }

    public void SaveButton() {
        AllButtons B = new AllButtons(driver);

        if (B.Save != null && B.Save.isDisplayed()) {
            Log.addLog("Save Button Is Visible");
            B.Save.click();
            Log.addLog("Save Button Clickable");
            test.log(Status.INFO, "Save Button Clicked");
        } else {

            Log.addLog("Save Button Not Visible");
            test.log(Status.FAIL, "Save Button Not Visible");
        }
    }




}
