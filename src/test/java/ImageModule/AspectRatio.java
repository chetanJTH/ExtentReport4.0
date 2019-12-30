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

public class AspectRatio extends BaseProduct {
    public AspectRatio(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void AspectRatioTest() throws InterruptedException {
        test = extent.createTest("Verify Crop Aspect Ratio");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);



        StateAspectRationButton();

        String screenShotPath = MobileActions.Screenshot("Aspect Ratio Option");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.findElementByXPath("//android.widget.TextView[@text='3:2']").click();

        String screenShotPath5 = MobileActions.Screenshot("Aspect Ratio Selection");
        try {
            test.addScreenCaptureFromPath(screenShotPath5);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void StateAspectRationButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.StateAspectRatio != null && C.StateAspectRatio.isDisplayed()) {
            Log.addLog("StateAspectRatio Button Is Visible");
            C.StateAspectRatio.click();
            Log.addLog("StateAspectRatio Button Clickable");
            test.log(Status.INFO, "StateAspectRatio Button Clicked");
        } else {

            Log.addLog("StateAspectRatio Button Not Visible");
            test.log(Status.FAIL, "StateAspectRatio Button Not Visible");
        }
    }
}
