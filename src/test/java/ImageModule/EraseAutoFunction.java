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

public class EraseAutoFunction extends BaseProduct {
    public EraseAutoFunction(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void EraseAutoFunctionTest() throws InterruptedException {
        test = extent.createTest("Erase Auto Function");
        test.assignCategory("Smoke");

        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        MobileActions M = new MobileActions(driver);
        TopScreenButton T = new TopScreenButton(driver);
        ImageButtons I = new ImageButtons(driver);


        I.EraseImageButton.click();
        Log.addLog("Erase Button Clickable");
        test.log(Status.INFO, "Erase Button Clicked");

        AutoEraseImageButton();

        AndroidElement seekbar2 = (AndroidElement) S.ImgTouchView;
        actions.tapOn(seekbar2);

//        AndroidElement seekbar2 = (AndroidElement) S.ImgTouchView;
//        M.viewGroupForward(seekbar2,50,50);

        B.Save.click();
        Log.addLog("Save Croped Shape");
        test.log(Status.INFO, "Save Button Clicked");

        String screenShotPath = MobileActions.Screenshot("Auto Erase Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        T.UndoButton.click();
        Log.addLog("Undo Button Clicked");
        test.log(Status.INFO, "Undo Button Clicked");

    }



    public void AutoEraseImageButton() {
        ImageButtons I = new ImageButtons(driver);

        if (I.AutoEraseImage != null && I.AutoEraseImage.isDisplayed()) {
            Log.addLog("AutoEraseImage Button Is Visible");
            I.AutoEraseImage.click();
            Log.addLog("AutoEraseImage Button Clickable");
            test.log(Status.INFO, "AutoEraseImage Button Clicked");
        } else {

            Log.addLog("AutoEraseImage Button Not Visible");
            test.log(Status.FAIL, "AutoEraseImage Button Not Visible");
        }
    }

}

