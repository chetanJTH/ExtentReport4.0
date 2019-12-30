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
import pageObject.*;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class ImgPositionLock extends BaseProduct {
    public ImgPositionLock(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void ImgPositionLockTest() throws InterruptedException {
        test = extent.createTest("Verify Image Position Lock");
        test.assignCategory("Functionality");



        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        myDesignPage D = new myDesignPage(driver);
        TextButton T = new TextButton(driver);
        TopScreenButton TS = new TopScreenButton(driver);
        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);

        D.MYDESIGN.click();
        Log.addLog("My Design Button Clickable");
        test.log(Status.INFO, "My Design Button Is Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(D.CreateOwn));

        D.CreateOwn.click();
        Log.addLog("Create Own Button Clickable");
        test.log(Status.INFO, "Create Own Button Is Clicked");

        D.IstaPortrait.click();
        Log.addLog("Custom Size Selected");

        B.Shape.click();
        Log.addLog("Shape Button Is Clickable");
        test.log(Status.INFO, "Shape Button Is Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(B.PickYourOwn));

        AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.nra.productmarketingmaker:id/tabLayout");
        findAndSelectText(tabLayout, true,"Square"); // test scroll to last item

        driver.findElementByXPath("(//android.widget.RelativeLayout)[3]").click();

        TS.LockButton.click();
        Log.addLog("Lock Element");
        test.log(Status.INFO, "Image Locked By Pressing Lock Button");

        String screenShotPath = MobileActions.Screenshot(" Image Position Lock");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.TopPositionButton.click();
        Log.addLog("Top Position Button Clicked");
        test.log(Status.INFO, "Top Position Button Clicked");


        String screenShotPath1 = MobileActions.Screenshot("Image Position Button Lock");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.BottomPositionButton.click();
        Log.addLog("Bottom Position Button Clicked");
        test.log(Status.INFO, "Bottom Position Button Clicked");

        B.LeftPositionButton.click();
        Log.addLog("Left Position Button Clicked");
        test.log(Status.INFO, "Left Position Button Clicked");

        B.RightPositionButton.click();
        Log.addLog("Right Position Button Clicked");
        test.log(Status.INFO, "Right Position Button Clicked");

        String screenShotPath2 = MobileActions.Screenshot("Image Position Button Locked");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void LockUnlockButton() {
        TopScreenButton TS = new TopScreenButton(driver);

        if (TS.LockButton != null && TS.LockButton.isDisplayed()) {
            Log.addLog("Lock Button Is Visible");
            TS.LockButton.click();
            Log.addLog("Lock Button Clickable");
            test.log(Status.INFO, "Lock Button Clicked");
        } else {

            Log.addLog("Lock Button Not Visible");
            test.log(Status.FAIL, "Lock Button Is Not Visible");
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


}
