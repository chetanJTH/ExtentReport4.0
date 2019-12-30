package FontModule;

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
import pageObject.TextButton;
import pageObject.myDesignPage;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.NoSuchElementException;

public class ParagraphStyle extends BaseProduct {
    public ParagraphStyle(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ParagraphStyleTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Font Paragraph Style Test");
        test.assignCategory("Sanity");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);
        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);



        AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.nra.productmarketingmaker:id/tabLayout");
        findAndSelectText(tabLayout, false,"Style"); // test scroll to last item

        LeftAlignmentButtonClick();

        Thread.sleep(1000);
        String screenShotPath2 = MobileActions.Screenshot("Left Alignment");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CenterAlignmentButtonClick();

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("Center Alignment");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RightAlignmentButtonClick();

        Thread.sleep(1000);
        String screenShotPath4 = MobileActions.Screenshot("Right Alignment");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);


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
            Log.addLog("COUNT " + COUNT);
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

    public void LeftAlignmentButtonClick() {
        TextButton T = new TextButton(driver);

        if (T.LeftAlignment != null) {
            if ((T.LeftAlignment).isDisplayed()) {
                Log.addLog("Left Alignment Button Is Visible");
                T.LeftAlignment.click();
                Log.addLog("Left Alignment Button Is Clickable");
                test.log(Status.INFO, "Left Alignment Button Clicked");
            } else {
                Log.addLog("Left Alignment Button Is Not Visible");
                test.log(Status.FAIL, "Left Alignment Button Is Not Visible");
            }
        }
    }

    public void CenterAlignmentButtonClick() {
        TextButton T = new TextButton(driver);
        if (T.CenterAlignment != null) {
            if ((T.CenterAlignment).isDisplayed()) {
                Log.addLog("Center Alignment Button Is Visible");
                T.CenterAlignment.click();
                Log.addLog("Center Alignment Button Is Clickable");
                test.log(Status.INFO, "Center Alignment Button Clicked");
            } else {
                Log.addLog("Center Alignment Button Is Not Visible");
                test.log(Status.FAIL, "Center Alignment Button Is Not Visible");
            }
        }
    }

    public void RightAlignmentButtonClick() {
        TextButton T = new TextButton(driver);
        if (T.RightAlignment != null) {
            if ((T.RightAlignment).isDisplayed()) {
                Log.addLog("Right Alignment Button Is Visible");
                T.RightAlignment.click();
                Log.addLog("Right Alignment Button Is Clickable");
                test.log(Status.INFO, "Right Alignment Button Clicked");
            } else {
                Log.addLog("Right Alignment Button Is Not Visible");
                test.log(Status.FAIL, "Right Alignment Button Is Not Visible");
            }
        }
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