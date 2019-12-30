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
import pageObject.ShapeCropLibrary;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.List;

public class CropBkGround extends BaseProduct {
    public CropBkGround(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void CropBkGroundTest() throws InterruptedException {
        test = extent.createTest("Check Shape Crop BkGround");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);



        C.CropShape.click();
        Log.addLog("ImgCropShape Button Clickable");
        test.log(Status.INFO, "ImgCropShape Button Clicked");

        driver.findElementById("com.nra.productmarketingmaker:id/stickerThumb").click();
        Log.addLog("Shape Selected");

        BtnBkGroundButton();

        driver.findElementByXPath("//*[@content-desc='Pattern']").click();
        Log.addLog("Click on Pattern");
        test.log(Status.INFO, "Click on Pattern");

        String screenShotPath = MobileActions.Screenshot("Shape BackGround");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        selectPattern(6);

        C.SaveCrop.click();
        Log.addLog("Save Croped Shape");
        test.log(Status.INFO, "Save Croped Shape");

        String screenShotPath1 = MobileActions.Screenshot("Shape Pattern BackGround ");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void BtnBkGroundButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.BtnBkGround != null && C.BtnBkGround.isDisplayed()) {
            Log.addLog("BkGround Button Is Visible");
            C.BtnBkGround.click();
            Log.addLog("BkGround Button Clickable");
            test.log(Status.INFO, "BkGround Button Clicked");
        } else {

            Log.addLog("BkGround Button Not Visible");
            test.log(Status.FAIL, "BkGround Button Not Visible");
        }
    }

    private void selectPattern(int _index) {

        int index = _index;
        String id = "com.nra.productmarketingmaker:id/sample1";
        List<MobileElement> listItems = driver.findElementsById(id);

        AndroidElement firstElement = (AndroidElement) listItems.get(0);
        AndroidElement lastElement = (AndroidElement) listItems.get(listItems.size() - 1);


        Point fromPoint = lastElement.getCenter();
        Log.addLog("fromPoint "+fromPoint);

        Point endPoint = firstElement.getCenter();
        Log.addLog("endPoint "+endPoint);

        while (index > listItems.size()) {
            Log.addLog("swipe");

            actions.swipeOnScreen(fromPoint, endPoint);
            index -= listItems.size();
        }
        AndroidElement selectedItem = (AndroidElement) listItems.get(index);
        selectedItem.click();

        Log.addLog("total: " + listItems.size());
    }
}
