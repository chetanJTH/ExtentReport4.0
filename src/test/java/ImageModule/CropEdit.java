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

public class CropEdit extends BaseProduct {
    public CropEdit(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void CropEditTest() throws InterruptedException {
        test = extent.createTest("Check Shape Crop List");

        test.assignCategory("Functionality");
        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        ShapeCropLibrary C = new ShapeCropLibrary(driver);



            ShapeButton();

            String screenShotPath = MobileActions.Screenshot("Shape Button");
            try {
                test.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            selectShape(2);

            C.SaveCrop.click();
            Log.addLog("Save Croped Shape");
            test.log(Status.INFO, "Save Croped Shape");

            String screenShotPath1 = MobileActions.Screenshot("New Shape");
            try {
                test.addScreenCaptureFromPath(screenShotPath1);
            } catch (IOException e) {
                e.printStackTrace();
            }



    }

    int currentIndex = 0;

    private void selectShape(int _index) {

        int index = _index;
        String id = "com.nra.productmarketingmaker:id/imgShape";
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

    public void ShapeButton() {
        ShapeCropLibrary C = new ShapeCropLibrary(driver);

        if (C.BtnShape != null && C.BtnShape.isDisplayed()) {
            Log.addLog("Shape Button Is Visible");
            C.BtnShape.click();
            Log.addLog("Shape Button Clickable");
            test.log(Status.INFO, "Shape Button Clicked");
        } else {

            Log.addLog("Shape Button Not Visible");
            test.log(Status.FAIL, "Shape Button Not Visible");
        }
    }
}
