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

public class Shadow extends BaseProduct {
    public Shadow(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void ShadowTest() throws InterruptedException{
        test = extent.createTest("Verify Font Shadow");
        test.assignCategory("Regression");

        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);

        ShadowButtonClick();

        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (M.shadowSeekBarForward(seekbar, 100)) {
            Log.addLog("Max Shadow");
        } else {
            Log.addLog("Shadow Not Applied");
        }

        String screenShotPath = MobileActions.Screenshot("Max Shadow");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Thread.sleep(1000);

        if (M.shadowSeekBarBack(seekbar, 30)) {
            Log.addLog("Min Shadow");
        } else {
            Log.addLog("Shadow Not Applied");
        }

        String screenShotPath1 = MobileActions.Screenshot("Min Shadow");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ShadowButtonClick() {
        AllButtons B = new AllButtons(driver);


            if (B.ShadowButton != null && B.ShadowButton.isDisplayed()) {
                Log.addLog("Shadow Button Is Visible");
                B.ShadowButton.click();
                Log.addLog("Shadow Button Clickable");
                test.log(Status.INFO, "Shadow Button Clicked");
            } else {

            Log.addLog("Shadow Button Not Visible");
            test.log(Status.FAIL, "Shadow Button Is Not Visible");
        }
    }
}
