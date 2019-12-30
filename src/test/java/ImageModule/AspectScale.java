package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.ShapeCropLibrary;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class AspectScale extends BaseProduct {
    public AspectScale(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void AspectScaleTest() throws InterruptedException {
        test = extent.createTest("Verify Crop Aspect Scale");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);


        StateScaleButton();

        String screenShotPath = MobileActions.Screenshot("Scale Bar");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScaleScroll();

        Thread.sleep(1000);
        AndroidElement seekbar = (AndroidElement) C.StateScaleScroll;

        if (actions.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Aspect Ration Scale Scrolling");
        } else {
            Log.addLog("Aspect Ration Scale Not Scrolling");
        }

        Thread.sleep(1000);
        String screenShotPath1 = MobileActions.Screenshot("Scale Bar Change");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void StateScaleButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.StateScale != null && C.StateScale.isDisplayed()) {
            Log.addLog("StateScale Button Is Visible");
            C.StateScale.click();
            Log.addLog("StateScale Button Clickable");
            test.log(Status.INFO, "StateScale Button Clicked");
        } else {

            Log.addLog("StateScale Button Not Visible");
            test.log(Status.FAIL, "StateScale Button Not Visible");
        }
    }

    public void ScaleScroll() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);
        if (C.StateScaleScroll != null && C.StateScaleScroll.isDisplayed()) {
            Log.addLog("Scale Scroll Seekbar Is Visible");
            test.log(Status.INFO, "Scale Scroll Seekbar Is Visible");

        } else {
            Log.addLog("Scale Scroll Seekbar Is Not Visible");
            test.log(Status.FAIL, "Scale Scroll Seekbar Is Not Visible");
        }
    }

}
