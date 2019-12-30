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

public class ImgCropShape extends BaseProduct {
    public ImgCropShape(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImgCropShapeTest() throws InterruptedException {
        test = extent.createTest("Verify Shape Crop Library");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);


        CropShapeButton();

        String screenShotPath = MobileActions.Screenshot("Shape List");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.nra.productmarketingmaker:id/stickerThumb")));
        driver.findElementById("com.nra.productmarketingmaker:id/stickerThumb").click();
        Log.addLog("Shape Selected");

        String screenShotPath1 = MobileActions.Screenshot("Shape Selection");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.addLog("Crop Editor Visible");
        test.log(Status.INFO, "Crop Editor Visible");


    }


    public void CropShapeButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.CropShape != null && C.CropShape.isDisplayed()) {
            Log.addLog("ImgCropShape Button Is Visible");
            C.CropShape.click();
            Log.addLog("ImgCropShape Button Clickable");
            test.log(Status.INFO, "ImgCropShape Button Clicked");
        } else {

            Log.addLog("ImgCropShape Button Not Visible");
            test.log(Status.FAIL, "ImgCropShape Button Not Visible");
        }
    }
}