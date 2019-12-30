package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageObject.AllSeekBar;
import pageObject.TextButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class FontOpacity extends BaseProduct {
    public FontOpacity(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void FontOpacityTest() throws InterruptedException{
        test = extent.createTest("Font Opacity");
        test.assignCategory("UI Testing");

        TextButton T = new TextButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);


        OpacityButtonClick();

        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (M.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Descrease Opacity");
        } else {
            Log.addLog("Opacity SeekBar Not Working");
        }

        String screenShotPath = MobileActions.Screenshot("Descrese Opacity");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);

        if (M.swipeSeekbarForward(seekbar, 100)) {
            Log.addLog("Increase Opacity");
        } else {
            Log.addLog("Opacity SeekBar Not Working");
        }

        String screenShotPath1 = MobileActions.Screenshot("Increase Opacity");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpacityButtonClick() {

        TextButton T = new TextButton(driver);
        if (T.Opacitybutton != null) {
            if ((T.Opacitybutton).isDisplayed()) {
                Log.addLog("Opacity Button Is Visible");
                T.Opacitybutton.click();
                Log.addLog("Opacity Button Is Clickable");
                test.log(Status.INFO, "Opacity Button Is Clicked");
            } else {
                Log.addLog("Opacity Button Is Not Visible");
                test.log(Status.FAIL, "Opacity Button Is Not Visible");
            }
        }
    }
}
