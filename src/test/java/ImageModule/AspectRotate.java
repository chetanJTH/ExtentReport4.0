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

public class AspectRotate extends BaseProduct {
    public AspectRotate(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void AspectRotateTest() throws InterruptedException {
        test = extent.createTest("Verify Crop Aspect Rotate");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);



        StateRotateButton();

        String screenShotPath = MobileActions.Screenshot("State Ratate ");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScaleRotate();

        AndroidElement seekbar1 = (AndroidElement) C.StateRotateScroll;

        if (actions.swipeSeekbarForward(seekbar1, 70)) {
            Log.addLog("Image Rotate Forward Successfully");
        } else {
            Log.addLog("Image Does Not Rotate");
        }

        String screenShotPath1 = MobileActions.Screenshot("State Roation Forward");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (actions.swipeSeekbarBack(seekbar1, 50)) {
            Log.addLog("Image Rotate  Backward Successfully");
        } else {
            Log.addLog("Image Does Not Rotate");
        }

        String screenShotPath2 = MobileActions.Screenshot("State Roation BackWard");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SaveMenuCrop();

    }

    public void StateRotateButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.StateRotate != null && C.StateRotate.isDisplayed()) {
            Log.addLog("StateRotate Button Is Visible");
            C.StateRotate.click();
            Log.addLog("StateRotate Button Clickable");
            test.log(Status.INFO, "StateRotate Button Clicked");
        } else {

            Log.addLog("StateRotate Button Not Visible");
            test.log(Status.FAIL, "StateRotate Button Not Visible");
        }
    }

    public void SaveMenuCrop() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);
        if (C.SaveEditPhoto != null && C.SaveEditPhoto.isDisplayed()) {
            Log.addLog("Save Button Is Visible");
            C.SaveEditPhoto.click();
            Log.addLog("Save Button Clickable");
            test.log(Status.INFO, "Save Button Clicked");
        } else {

            Log.addLog("Save Button Not Visible");
            test.log(Status.FAIL, "Save Button Not Visible");
        }
    }


    public void ScaleRotate() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);
        if (C.StateRotateScroll != null && C.StateRotateScroll.isDisplayed()) {
            Log.addLog("Scale Rotate Seekbar Is Visible");
            test.log(Status.INFO, "Scale Rotate Seekbar Is Visible");
        } else {
            Log.addLog("Scale Rotate Seekbar Is Not Visible");
            test.log(Status.FAIL, "Scale Rotate Seekbar Is Not Visible");
        }
    }
}
