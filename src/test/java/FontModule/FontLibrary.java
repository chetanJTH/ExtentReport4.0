package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.FontLibraryButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;
import java.io.IOException;
import java.util.List;

public class FontLibrary extends BaseProduct {
    public FontLibrary(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontLibraryTest() throws InterruptedException {
        test = extent.createTest("Font Library Test");
        test.assignCategory("Smoke");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        FontLibraryButton F = new FontLibraryButton(driver);

        FontButtonClick();

        selectFont(5);
        Log.addLog("Font is selected");
        test.log(Status.INFO, "Font is selected");

        String screenShotPath = MobileActions.Screenshot("Font Selection");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddFontButtonClick();

        FreeFontButtonClick();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lato\"));").click();

        wait.until(ExpectedConditions.elementToBeClickable(B.BackButton));
        B.BackButton.click();
        Log.addLog("Back Button is Clicked");

        F.downloadedFont.getText();
        Log.addLog("Downloaded Font " + F.downloadedFont.getText());
        test.log(Status.INFO, "Free Font DownLoaded" + F.downloadedFont.getText());

        String screenShotPath1 = MobileActions.Screenshot("Font Download");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        F.AddFontButton.click();
        Log.addLog("Add Font Button Is Clickable");
        test.log(Status.INFO, " Add Font Button Is Clicked");

        HowToButtonClick();

        wait.until(ExpectedConditions.elementToBeClickable(F.TutorialVideo));
        TutorialVideoDisplay();

        BackButtonClick();

        BackBtnClick();


    }

    int currentIndex = 0;

    private void selectFont(int _index) {

        int index = _index;
        String id = "com.nra.productmarketingmaker:id/txtFontName";
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


    public void FontButtonClick() {

        FontLibraryButton F = new FontLibraryButton(driver);
        if (F.Font != null) {
            if ((F.Font).isDisplayed()) {
                Log.addLog("Font Button Is Visible");
                F.Font.click();
                Log.addLog("Font Button Is Clickable");
                test.log(Status.INFO, "Font Button Is Clicked");
            } else {
                Log.addLog("Font Button Is Not Visible");
                test.log(Status.INFO, "Font Button Is Not Visible");
            }
        }
    }

    public void AddFontButtonClick() {
        FontLibraryButton F = new FontLibraryButton(driver);
        if (F.AddFontButton != null) {

                if ((F.AddFontButton).isDisplayed()) {
                    Log.addLog("Add Font Button Is Visible");
                    F.AddFontButton.click();
                    Log.addLog("Add Font Button Is Clickable");
                    test.log(Status.INFO, "Add Font Button Is Clicked");
                } else {

                Log.addLog("Add Font Button Is Not Visible");
                test.log(Status.FAIL, "Add Font Button Is Not Visible");
            }
        }
    }



    public void FreeFontButtonClick() {
        FontLibraryButton F = new FontLibraryButton(driver);
        if (F.FreeFont != null) {

                if ((F.FreeFont).isDisplayed()) {
                    Log.addLog("Free Font Button Is Visible");
                    F.FreeFont.click();
                    Log.addLog("Free Font Button Is Clickable");
                    test.log(Status.INFO, "Free Font Button Is Clicked");
                } else {

                Log.addLog("Free Font Button Is Not Visible");
                test.log(Status.FAIL, "Free Font Button Is Not Visible");
            }
        }
    }

    public void BackBtnClick() {
        AllButtons B = new AllButtons(driver);
        if (B.BackButton != null) {
            if ((B.BackButton).isDisplayed()) {
                Log.addLog("Back Button Button Is Visible");
                B.BackButton.click();
                Log.addLog("Back Button Button Is Clickable");
                test.log(Status.INFO, "Back Button Button Clicked");

            } else {
                Log.addLog("Back Button Button Is Not Visible");
            }
        }
    }

    public void HowToButtonClick() {
        FontLibraryButton F = new FontLibraryButton(driver);
        if (F.HowTo != null) {
            if ((F.HowTo).isDisplayed()) {
                Log.addLog("HowTo Button Is Visible");
                F.HowTo.click();
                Log.addLog("HowTo Button Is Clickable");
                test.log(Status.INFO, "HowTo Button Is Clicked");
            } else {
                Log.addLog("HowTo Button Is Not Visible");
                test.log(Status.INFO, "HowTo Button Is Not Visible");
            }
        }
    }

    public void TutorialVideoDisplay() {
        FontLibraryButton F = new FontLibraryButton(driver);
        if (F.TutorialVideo != null) {
            if ((F.TutorialVideo).isDisplayed()) {
                Log.addLog("Tutorial Video Is Visible");
                test.log(Status.INFO, "Tutorial Video Is Visible");
            } else {
                Log.addLog("Tutorial Video Is Not Visible");
                test.log(Status.INFO, "Tutorial Video Is Not Visible");
            }
        }
    }

    public void BackButtonClick() {
        FontLibraryButton F = new FontLibraryButton(driver);
        if (F.NavigateBack != null) {
            if ((F.NavigateBack).isDisplayed()) {
                Log.addLog("Back Button Button Is Visible");
                F.NavigateBack.click();
                Log.addLog("Back Button Button Is Clickable");
                test.log(Status.INFO, "Back Button Button Clicked");

            } else {
                Log.addLog("Back Button Button Is Not Visible");
            }
        }
    }

}


