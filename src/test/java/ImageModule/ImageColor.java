package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.ColorLibrary;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ImageColor extends BaseProduct {
    public ImageColor(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImageColorTest() throws InterruptedException {
        test = extent.createTest("Set color on Text");
        test.assignCategory("Sanity");


        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        ColorLibrary C = new ColorLibrary(driver);
        MobileActions M = new MobileActions(driver);

        try {

            AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.nra.productmarketingmaker:id/tabLayout");
            findAndSelectText(tabLayout, true,"Color"); // test scroll to last item

            C.Color.click();
            Log.addLog("Font Color Button Is Clickable");
            test.log(Status.INFO, "Font Color Button Is Clicked");

            selectColor(21);
            Log.addLog("Font Color is selected");
            test.log(Status.INFO, "Font Color Selected");

            String screenShotPath = MobileActions.Screenshot("Font Color List");
            try {
                test.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            C.ColorPicker.click();
            Log.addLog("FontColor Picker Is Clickable");
            test.log(Status.INFO, "FontColor Picker Button Clicked");

            AndroidElement seekbar = (AndroidElement) S.ColorSeekBar;

            M.colorSeekBarForward(seekbar, 80);
            String screenShotPath1 = MobileActions.Screenshot("Font Color SeekBar");
            try {
                test.addScreenCaptureFromPath(screenShotPath1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            CancelButtonClick();

            C.ColorPicker.click();

            AndroidElement colorseekbar = (AndroidElement) S.ColorViewGroup;

            M.viewGroupForward(colorseekbar, 60, 60);
            String screenShotPath2 = MobileActions.Screenshot("Font Color ViewGroup");
            try {
                test.addScreenCaptureFromPath(screenShotPath2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            C.ColorPickButton.click();
            test.log(Status.INFO, "FontColor Is Picked From ViewGroup");

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void CancelButtonClick() {
        ColorLibrary C = new ColorLibrary(driver);

        if (C.CancelButton != null) {
            if ((C.CancelButton).isDisplayed()) {
                Log.addLog("Cancel Button Is Visible");
                C.CancelButton.click();
                Log.addLog("Cancel Button Clicked");
                test.log(Status.INFO, "Cancel Button Clicked");
            } else {
                Log.addLog("Cancel Button Is Not Visible");
                test.log(Status.FAIL, "Cancel Button Is Not Visible");
            }
        }
    }

    int currentIndex = 0;

    private void selectColor(int _index) {

        int index = _index;
        String id = "com.nra.productmarketingmaker:id/color_picker_view";
        List<MobileElement> listItems = driver.findElementsById(id);

        AndroidElement firstElement = (AndroidElement) listItems.get(0);
        AndroidElement lastElement = (AndroidElement) listItems.get(listItems.size() - 1);


        Point fromPoint = lastElement.getCenter();
        Point endPoint = firstElement.getCenter();
        while (index > listItems.size()) {
            Log.addLog("swipe");

            actions.swipeOnScreen(fromPoint, endPoint);
            index -= listItems.size();
        }
        AndroidElement selectedItem = (AndroidElement) listItems.get(index);
        selectedItem.click();

        Log.addLog("total: " + listItems.size());
    }

    private int MAX_COUNT = 5;
    private int COUNT = 0;
    private void findAndSelectText(AndroidElement parent, boolean isNext, String text) {

        Log.addLog("finding...");
        while (!isPresent(getXpath(text)) && COUNT < MAX_COUNT) {
            actions.tapOn(parent, isNext ? 90 : 10);
            COUNT++;
            Log.addLog("COUNT "+ COUNT);
        }
        COUNT = 0;

        driver.findElementByXPath(getXpath(text)).click();
        Log.addLog("find completed...");
    }

    private String getXpath(String text) {
        String xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\""+ text +"\"]";
        Log.addLog(xpath);
        return xpath;
    }

    private boolean isPresent(String xpath) {

        try {

            AndroidElement element = (AndroidElement) driver.findElementByXPath(xpath);
            Log.addLog("isDisplayed: " + element.isDisplayed());
            return element.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.addLog("isDisplayed: false");
            return false;
        }
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }


}
