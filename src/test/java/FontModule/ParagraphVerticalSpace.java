package FontModule;

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
import pageObject.TextButton;
import pageObject.myDesignPage;
import utils.Log;

import java.io.IOException;
import java.util.NoSuchElementException;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

public class ParagraphVerticalSpace extends BaseProduct {
    public ParagraphVerticalSpace(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ParagraphVerticalSpaceTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Font Paragraph Vertical Space");
        test.assignCategory("Sanity");

        MobileActions M = new MobileActions(driver);
        AllSeekBar S = new AllSeekBar(driver);

        try {
            AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.nra.productmarketingmaker:id/tabLayout");
            findAndSelectText(tabLayout, true, "Vertical Spacing"); // test scroll to last item

            VerticalSpacingButtonClick();

            AndroidElement seekbar = (AndroidElement) S.ShadowSeekBar;

            if (M.swipeSeekbarForward(seekbar, 70)) {
                Log.addLog("Increase Spacing");
            } else {
                Log.addLog("Spacing SeekBar Not Working");
            }

            String screenShotPath = MobileActions.Screenshot("Increase Vertical Spacing");
            try {
                test.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }


            Thread.sleep(1000);

            if (M.swipeSeekbarBack(seekbar, 100)) {
                Log.addLog("Descrease Spacing");
            } else {
                Log.addLog("Spacing SeekBar Not Working");
            }

            String screenShotPath1 = MobileActions.Screenshot("Descrease Vertical Spacing");
            try {
                test.addScreenCaptureFromPath(screenShotPath1);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private int MAX_COUNT = 6;
    private int COUNT = 0;

    private void findAndSelectText(AndroidElement parent, boolean isNext, String text) {

        Log.addLog("finding...");
        while (!isPresent(getXpath(text)) && COUNT < MAX_COUNT) {
            actions.tapOn(parent, isNext ? 90 : 10);
            COUNT++;
            //   Log.addLog("COUNT " + COUNT);
        }
        COUNT = 0;

        driver.findElementByXPath(getXpath(text)).click();
        Log.addLog("find completed...");
    }

    private String getXpath(String text) {
        String xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"" + text + "\"]";
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

    public void VerticalSpacingButtonClick() {
        TextButton T = new TextButton(driver);
        if (T.VerticalSpacing != null) {
            if ((T.VerticalSpacing).isDisplayed()) {
                Log.addLog("Vertical Spacing Button Is Visible");
                T.VerticalSpacing.click();
                Log.addLog("Vertical Spacing Button Is Clickable");
                test.log(Status.INFO, "Vertical Spacing Button Clicked");
            } else {
                Log.addLog("Vertical Spacing Button Is Not Visible");
                test.log(Status.FAIL, "Vertical Spacing Button Is Not Visible");
            }
        }
    }
}
