package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.TextButton;
import pageObject.myDesignPage;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;
import java.io.IOException;
import java.util.NoSuchElementException;

public class FontSave extends BaseProduct {
    public FontSave(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontSaveTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Font Save");

        test.assignCategory("Sanity");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllSeekBar S = new AllSeekBar(driver);
        myDesignPage D = new myDesignPage(driver);
        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);


        T.AddTextButton.click();
        Log.addLog("AddText Button Clickable");
        test.log(Status.INFO, "AddText Button Is Clicked");

        Thread.sleep(2000);

        T.iText.click();
        Log.addLog("Click On Text Feild");
        test.log(Status.INFO, "Text Input Feild Clicked");


        T.iText.sendKeys(" SAVE ");
        Log.addLog("Text is Entered");
        test.log(Status.INFO, "Text Is Entered");

        Thread.sleep(1000);
        String screenShotPath = MobileActions.Screenshot("Text Enter");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.OkButton.click();
        Log.addLog("Press Ok Button");
        test.log(Status.INFO, "Ok Button Pressed");

        Thread.sleep(1000);
        String screenShotPath1 = MobileActions.Screenshot(" Text Is Enter");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.Size.click();
        Log.addLog("Size Button is Clickable");
        test.log(Status.INFO, "Size Button Clicked");

        AndroidElement seekbar = (AndroidElement) S.RotationSeekBar;

        if (actions.swipeSeekbarForward(seekbar, 30)) {
            Log.addLog("Text Zoom In");
        } else {
            Log.addLog("Text Does Not Zoom");
        }

        String screenShotPath2 = MobileActions.Screenshot("Text Size Increase");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
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

        wait.until(ExpectedConditions.elementToBeClickable(D.MYDESIGN));
        D.MYDESIGN.click();
        Log.addLog("Select MyDesign Page");

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("My Design View");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveButtonClick() {
        AllButtons B = new AllButtons(driver);

        if (B.Save != null) {
            if ((B.Save).isDisplayed()) {
                Log.addLog("Save Button Is Visible");
                B.Save.click();
                Log.addLog("Save Button Clicked");
                test.log(Status.INFO, "Save Button Clicked");
            } else {
                Log.addLog("Save Button Is Not Visible");
                test.log(Status.FAIL, "Save Button Is Not Visible");
            }
        }
    }

    public void SelectSaveOption() {
        AllButtons B = new AllButtons(driver);

        if (B.Original != null) {
            if ((B.Original).isDisplayed()) {
                Log.addLog("Original Option Visible");
                B.Original.click();
                Log.addLog("Original Option Clicked");
                test.log(Status.INFO, "Original Option Clicked");
            } else {
                Log.addLog("Original Option Is Not Visible");
                test.log(Status.FAIL, "Original Option Is Not Visible");
            }
        }
    }

    public void SaveCardClick() {
        myDesignPage M = new myDesignPage(driver);

        if (M.CardView != null) {
            Log.addLog("Card Is Present In My Design");
            if (M.CardView.isDisplayed()) {
                M.CardView.click();
                Log.addLog("Saved Card Is Present In My Design");
                test.log(Status.INFO, "Saved Card Is Present In My Design");
                } else{
                    Log.addLog("Card Is Not Present In My Design");
                    test.log(Status.FAIL, "Card Is Not Present In My Design");
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



