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
import java.io.IOException;
import java.util.List;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

public class FontGetMoreButton extends BaseProduct {
    public FontGetMoreButton(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontGetMoreButtonTest() throws InterruptedException {
        test = extent.createTest("Font Get More Test");
        test.assignCategory("Smoke");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        FontLibraryButton F = new FontLibraryButton(driver);

        selectFont(18);

        GetMoreClick();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Overlock SC\"));").click();
        Log.addLog("Font Selected From Downloaded Tab");
        test.log(Status.INFO, "Font Selected From Downloaded Tab");

        F.GetMore.click();
        Log.addLog("GetMore Button Is Clickable");
        test.log(Status.INFO, "GetMore Button Is Clicked");

        F.FreeFont.click();
        Log.addLog("FreeFont Tab Selected");
        test.log(Status.INFO, "FreeFont Tab Selected");

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bosk Brush\"));").click();

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


        selectFont(4);

        F.GetMore.click();
        Log.addLog("GetMore Button Is Clickable");
        test.log(Status.INFO, "GetMore Button Is Clicked");

        F.HowTo.click();
        Log.addLog("HowTo Button Is Clickable");
        test.log(Status.INFO, "HowTo Button Is Clicked");

        F.TutorialVideo.isDisplayed();
        Log.addLog("Tutorial Video Is Visible");
        test.log(Status.INFO, "Tutorial Video Is Visible");

        F.NavigateBack.click();
        Log.addLog("Back Button Button Is Clickable");
        test.log(Status.INFO, "Back Button Button Clicked");

        B.BackButton.click();
        Log.addLog("Back Button Button Is Clickable");
        test.log(Status.INFO, "Back Button Button Clicked");


    }

    public void GetMoreClick() {

        FontLibraryButton F = new FontLibraryButton(driver);
        if (F.GetMore != null) {
            if ((F.GetMore).isDisplayed()) {
                Log.addLog("GetMore Button Is Visible");
                F.GetMore.click();
                Log.addLog("GetMore Button Is Clickable");
                test.log(Status.INFO, "GetMore Button Is Clicked");
            } else {
                Log.addLog("GetMore Button Is Not Visible");
                test.log(Status.INFO, "GetMore Button Is Not Visible");
            }
        }
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
        selectedItem.isDisplayed();

        Log.addLog("total: " + listItems.size());
    }


}
