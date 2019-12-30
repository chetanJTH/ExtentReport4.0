package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.TextButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class ImageOpacity extends BaseProduct {
    public ImageOpacity(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImageOpacityTest() throws InterruptedException {
        test = extent.createTest("Image Opacity");
        test.assignCategory("UI Testing");


        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);


        AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.nra.productmarketingmaker:id/tabLayout");
        findAndSelectText(tabLayout, true,"Opacity"); // test scroll to last item

        T.Opacitybutton.click();
        Log.addLog("Opacity Button is Clickable");
        test.log(Status.INFO, "Opacity Button Is Clicked");

        AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

        if (M.swipeSeekbarBack(seekbar, 50)) {
            Log.addLog("Descrease Opacity");
        } else {
            Log.addLog("Opacity SeekBar Not Working");
        }

        String screenShotPath = MobileActions.Screenshot("Descrese Opacity");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);

        if (M.swipeSeekbarForward(seekbar, 100)) {
            Log.addLog("Increase Opacity");
        } else {
            Log.addLog("Opacity SeekBar Not Working");
        }

        String screenShotPath1 = MobileActions.Screenshot("Increase Opacity");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.Save.click();
        Log.addLog("Save Button Clicked");
        test.log(Status.INFO, "Save Button Clicked");

        B.Original.click();
        Log.addLog("Original Option Clicked");
        test.log(Status.INFO, "Original Option Clicked");


        try {
            clickRateUsDialog();
        } catch (Throwable e) {

            e.printStackTrace();
            Log.addLog("Rating button NOT Present");

            try {
                clickHomeButton();
            } catch (Throwable th) {
                th.printStackTrace();
                Log.addLog("HOME button NOT Present");
            }

        }
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

    private void clickRateUsDialog() {
        AllButtons B = new AllButtons(driver);
        if (B.NotNow != null) {
            if (B.NotNow.isDisplayed()) {
                B.NotNow.click();
                B.Home.click();
                Log.addLog("NotNow Button Clicked");
                test.log(Status.INFO, "NotNow Button Clicked");

            } else {

                Log.addLog("NotNow Button Not Present");
                test.log(Status.INFO, "NotNow Button Not Present");
            }
        }
    }

    private void clickHomeButton() {
        AllButtons B = new AllButtons(driver);
        if (B.Home != null) {
            if (B.Home.isDisplayed()) {
                B.Home.click();
                Log.addLog("Home Button Clicked");
                test.log(Status.INFO, "Home Button Clicked");
            } else {
                Log.addLog("Home Button Not Present");
                test.log(Status.INFO, "Home Button Not Present");
            }
        }
    }

}