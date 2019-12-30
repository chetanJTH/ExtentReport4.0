package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.ColorLibrary;
import utils.Log;
import java.io.IOException;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

public class FontColorCode extends BaseProduct {
    public FontColorCode(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontColorCodeTest() throws InterruptedException {
        test = extent.createTest("Color Code Test");
        test.assignCategory("Sanity");

        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        ColorLibrary C = new ColorLibrary(driver);
        MobileActions M = new MobileActions(driver);


        C.ColorPicker.click();
        Log.addLog("FontColor Picker Is Clickable");
        test.log(Status.INFO, "FontColor Picker Button Clicked");

        ColorCodeClick();

        Thread.sleep(1000);
        String screenShotPath = MobileActions.Screenshot("Color Code");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        C.ColorCode.clear();
        C.ColorCode.sendKeys("101DE7");

        Thread.sleep(1000);
        String screenShotPath1 = MobileActions.Screenshot("Enter Color Code");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        C.ColorPickButton.click();
        test.log(Status.INFO, "Font Color Is Picked From ViewGroup");

        Thread.sleep(1000);
        String screenShotPath2 = MobileActions.Screenshot("Set Color");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void ColorCodeClick() {
        ColorLibrary C = new ColorLibrary(driver);

        if (C.ColorCode != null) {

            if ((C.ColorCode).isDisplayed()) {
                Log.addLog("Color Code Button Is Visible");
                C.ColorCode.click();
                Log.addLog("Color Code Button Is Clickable");
                test.log(Status.INFO, "Color Code Button Is Clicked");
            } else {

                Log.addLog("Color Code Button Is Not Visible");
                test.log(Status.FAIL, "Color Code Button Is Not Clickable");
            }
        }
    }


}
