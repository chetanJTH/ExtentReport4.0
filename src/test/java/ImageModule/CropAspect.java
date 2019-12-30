package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.ShapeCropLibrary;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.List;

public class CropAspect extends BaseProduct {
    public CropAspect(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void CropAspectTest() throws InterruptedException {
        test = extent.createTest("Verify Crop Aspect");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        CropButton();

        String screenShotPath = MobileActions.Screenshot("Crop Menu");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CropAspectButton();

        String screenShotPath1 = MobileActions.Screenshot("Ratio Editor");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.addLog("Aspect Crop Editor Visible");
        test.log(Status.INFO, "Aspect Crop Editor Visible");


    }

    public void CropButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.CropButton != null && C.CropButton.isDisplayed()) {
            Log.addLog("Crop Button Is Visible");
            C.CropButton.click();
            Log.addLog("Crop Button Clickable");
            test.log(Status.INFO, "Crop Button Clicked");
        } else {

            Log.addLog("Crop Button Not Visible");
            test.log(Status.FAIL, "Crop Button Not Visible");
        }
    }


    public void CropAspectButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);
        if (C.CropAspect != null && C.CropAspect.isDisplayed()) {
            Log.addLog("CropAspect Button Is Visible");
            C.CropAspect.click();
            Log.addLog("CropAspect Button Clickable");
            test.log(Status.INFO, "CropAspect Button Clicked");
        } else {

            Log.addLog("CropAspect Button Not Visible");
            test.log(Status.FAIL, "CropAspect Button Not Visible");
        }
    }
}
