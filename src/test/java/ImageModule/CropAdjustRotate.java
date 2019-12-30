package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.ShapeCropLibrary;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.List;

public class CropAdjustRotate extends BaseProduct {
    public CropAdjustRotate(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void CropAdjustRotateTest() throws InterruptedException {
        test = extent.createTest("Check Shape Rotation");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllSeekBar S = new AllSeekBar(driver);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);



        C.CropShape.click();
        Log.addLog("ImgCropShape Button Clickable");
        test.log(Status.INFO, "ImgCropShape Button Clicked");

        driver.findElementById("com.nra.productmarketingmaker:id/stickerThumb").click();
        Log.addLog("Shape Selected");

        AdjustmentButton();

        String screenShotPath = MobileActions.Screenshot("Shape Adjust Editor");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdjustRotateButton();

        B.AntiClockRotate.click();
        Log.addLog("AntiClockRotate button is Clickable");
        test.log(Status.INFO, "AntiClockRotate Button Clicked");

        B.ClockWiseRotate.click();
        Log.addLog("ClockWiseRotate button is Clickable");
        test.log(Status.INFO, "ClockWiseRotate Button Clicked");

        AndroidElement seekbar = (AndroidElement) S.RotationSeekBar;

        if (actions.swipeSeekbarForward(seekbar, 100)) {
            Log.addLog("Image Rotate Forward Successfully");
        } else {
            Log.addLog("Image Does Not Rotate");
        }

        String screenShotPath1 = MobileActions.Screenshot("Shape Image Rotate Forward");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (actions.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Image Rotate  Backward Successfully");
        } else {
            Log.addLog("Image Does Not Rotate");
        }

        String screenShotPath2 = MobileActions.Screenshot("Shape Image Rotate BackWard");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);
        C.SaveCrop.click();
        Log.addLog("Save Croped Shape");
        test.log(Status.INFO, "Save Croped Shape");

        String screenShotPath3 = MobileActions.Screenshot("Shape Rotation");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void AdjustmentButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.Adjustment != null && C.Adjustment.isDisplayed()) {
            Log.addLog("Adjustment Button Is Visible");
            C.Adjustment.click();
            Log.addLog("Adjustment Button Clickable");
            test.log(Status.INFO, "Adjustment Button Clicked");
        } else {

            Log.addLog("Adjustment Button Not Visible");
            test.log(Status.FAIL, "Adjustment Button Not Visible");
        }
    }

    public void AdjustRotateButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);
        if (C.AdjustRotate != null && C.AdjustRotate.isDisplayed()) {
            Log.addLog("Rotate Button Is Visible");
            C.AdjustRotate.click();
            Log.addLog("Rotate Button Clickable");
            test.log(Status.INFO, "Rotate Button Clicked");
        } else {

            Log.addLog("Rotate Button Not Visible");
            test.log(Status.FAIL, "Rotate Button Not Visible");
        }
    }

    public void AdjustSizeButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);
        if (C.AdjustSize != null && C.AdjustSize.isDisplayed()) {
            Log.addLog("Size Button Is Visible");
            C.AdjustSize.click();
            Log.addLog("Size Button Clickable");
            test.log(Status.INFO, "Size Button Clicked");
        } else {

            Log.addLog("Size Button Not Visible");
            test.log(Status.FAIL, "Size Button Not Visible");
        }
    }

}
