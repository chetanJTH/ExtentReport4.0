package ImageModule;


import ProductAdMaker.BaseProduct;

import actions.MobileActions;

import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.ImageButtons;
import pageObject.myDesignPage;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;
import java.io.IOException;


public class AddImage extends BaseProduct {
    public AddImage(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void AddImageTest() throws InterruptedException{
        test = extent.createTest("Add Image on Canvas");
        test.assignCategory("Functionality");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);

        wait.until(ExpectedConditions.elementToBeClickable(D.MYDESIGN));
        Log.addLog("Select Edit Button");

        D.MYDESIGN.click();
        Log.addLog("Navigate To My Design");
        test.log(Status.INFO, "Navigate To My Design");

        D.CreateOwn.click();
        Log.addLog("Select Create Your Own");
        test.log(Status.INFO, "Select Create Your Own");

        D.IstaPortrait.click();
        Log.addLog("Select Custom Template Card");
        test.log(Status.INFO, "Select Custom Template Card");

        AddImageButton();

        String screenShotPath = MobileActions.Screenshot("Add Image Option");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ChooseImageButton();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.android.documentsui:id/icon_thumb"))));

        String screenShotPath1 = MobileActions.Screenshot("Add Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.findElementById("com.android.documentsui:id/icon_thumb").click();
        Log.addLog("Select Image");
        test.log(Status.INFO, "Select Image");



//        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Show roots']").click();
//        Log.addLog("Open File Manager");
//
//        driver.findElementByXPath("//android.widget.TextView[@text='Gallery']").click();
//        Log.addLog("Select gallery");
//
//        driver.findElementById("com.sec.android.gallery3d:id/thumbnail").click();
//        Log.addLog("Select catalog");
//
//        driver.findElementById("com.sec.android.gallery3d:id/thumbnail").click();
//        Log.addLog("Select Image");


        String screenShotPath2 = MobileActions.Screenshot("Image On Canvas");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void AddImageButton() {
        ImageButtons I = new ImageButtons(driver);


            if (I.AddImage != null && I.AddImage.isDisplayed()) {
                Log.addLog("AddImage Button Is Visible");
                I.AddImage.click();
                Log.addLog("AddImage Button Clickable");
                test.log(Status.INFO, "Add Image Button Clicked");
            } else {
                Log.addLog("AddImage Button Not Visible");
                test.log(Status.FAIL, "AddImage Button Not Visible");
        }
    }

    public void ChooseImageButton() {
        ImageButtons I = new ImageButtons(driver);

            if (I.CameraOption != null && I.ChooseImage.isDisplayed()) {
                Log.addLog("Choose Image Button Is Visible");
                I.ChooseImage.click();
                Log.addLog("Choose Image Button Clickable");
                test.log(Status.INFO, "Choose Image Button Clicked");
            } else {

            Log.addLog("Choose Image Button Not Visible");
            test.log(Status.FAIL, "Choose Image Button Not Visible");
        }
    }
}
