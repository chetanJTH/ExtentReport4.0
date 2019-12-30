package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pageObject.TextButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;
import java.io.IOException;

public class FontStyle extends BaseProduct {
    public FontStyle(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontStyleTest() throws InterruptedException {
        test = extent.createTest("Font Style Change");
        test.assignCategory("Functionality");

        StyleButtonClick();

        UnderlineClick();

        String screenShotPath = MobileActions.Screenshot("Font Underline");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        UpperCaseClick();

        String screenShotPath1 = MobileActions.Screenshot("Font UpperCase");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LowerCaseClick();

        String screenShotPath2 = MobileActions.Screenshot("Font LowerCase");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TitleCaseClick();

        String screenShotPath3 = MobileActions.Screenshot("Font TitileCase");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StyleButtonClick() {
        TextButton T = new TextButton(driver);

        if (T.Stylebutton != null) {
            if ((T.Stylebutton).isDisplayed()) {
                    Log.addLog("FontStyleCase Button Is Visible");
                    T.Stylebutton.click();
                    Log.addLog("FontStyleCase Button Is Clickable");
                    test.log(Status.INFO, "FontStyleCase Button Is Clicked");
                } else {

                Log.addLog("FontStyleCase Button Is Not Visible");
                test.log(Status.FAIL, "FontStyleCase Button Is Not Visible");
            }
        }
    }

    public void UnderlineClick() {
        TextButton T = new TextButton(driver);
        if (T.Underline != null) {

                if ((T.Underline).isDisplayed()) {
                    Log.addLog("Underline Button Is Visible");
                    T.Underline.click();
                    Log.addLog("Underline Button Is Clickable");
                    test.log(Status.INFO, "Underline Button Is Clicked");
                } else {

                Log.addLog("Underline Button Is Not Visible");
                test.log(Status.FAIL, "Underline Button Is Not Visible");
            }
        }
    }

    public void UpperCaseClick() {
        TextButton T = new TextButton(driver);
        if (T.UpperCase != null) {

                if ((T.UpperCase).isDisplayed()) {
                    Log.addLog("UpperCase Button Is Visible");
                    T.UpperCase.click();
                    Log.addLog("UpperCase Button Is Clickable");
                    test.log(Status.INFO, "UpperCase Button Is Clicked");
                } else {

                Log.addLog("UpperCase Button Is Not Visible");
                test.log(Status.FAIL, "UpperCase Button Is Not Visible");
            }
        }
    }

    public void LowerCaseClick() {
        TextButton T = new TextButton(driver);
        if (T.LowerCase != null) {

                if ((T.LowerCase).isDisplayed()) {
                    Log.addLog("LowerCase Button Is Visible");
                    T.LowerCase.click();
                    Log.addLog("LowerCase Button Is Clickable");
                    test.log(Status.INFO, "LowerCase Button Is Clicked");
                } else {

                Log.addLog("LowerCase Button Is Not Visible");
                test.log(Status.FAIL, "LowerCase Button Is Not Visible");
            }
        }
    }

    public void TitleCaseClick() {
        TextButton T = new TextButton(driver);
        if (T.TitleCase != null) {

                if ((T.TitleCase).isDisplayed()) {
                    Log.addLog("TitleCase Button Is Visible");
                    T.TitleCase.click();
                    Log.addLog("TitleCase Button Is Clickable");
                    test.log(Status.INFO, "TitleCase Button Is Clicked");
                } else {

                Log.addLog("TitleCase Button Is Not Visible");
                test.log(Status.FAIL, "TitleCase Button Is Not Visible");
            }
        }
    }
}
