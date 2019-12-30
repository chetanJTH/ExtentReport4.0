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
import pageObject.AllSeekBar;
import pageObject.ShapeCropLibrary;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class CropAdjustSize extends BaseProduct {
    public CropAdjustSize(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void CropAdjustSizeTest() throws InterruptedException {
        test = extent.createTest("Check Shape Size Adjustment");

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

        C.Adjustment.click();
        Log.addLog("Adjustment Button Clickable");
        test.log(Status.INFO, "Adjustment Button Clicked");


        AdjustSizeButton();

        B.ZoomInButton.click();
        Log.addLog("ZoomInButton button is Clickable");
        test.log(Status.INFO, "ZoomInButton Button Clicked");

        B.ZoomOutButton.click();
        Log.addLog("ZoomOutButton button is Clickable");
        test.log(Status.INFO, "ZoomOutButton Button Clicked");


        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (actions.swipeSeekbarForward(seekbar, 70)) {
            Log.addLog("Image Zoom In");
        } else {
            Log.addLog("Image Does Not Zoom");
        }

        String screenShotPath = MobileActions.Screenshot("Image Max");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);

        if (actions.swipeSeekbarBack(seekbar, 25)) {
            Log.addLog("Image Zoom Out");
        } else {
            Log.addLog("Image Does Not Zoom Out");
        }
        String screenShotPath1 = MobileActions.Screenshot("Image Min");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);
        C.SaveCrop.click();
        Log.addLog("Save Croped Shape");
        test.log(Status.INFO, "Save Croped Shape");

        String screenShotPath2 = MobileActions.Screenshot("Shape Size Change");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
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
