package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.TextButton;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;
import java.io.IOException;
import java.util.List;

public class FrameLayer extends BaseProduct {
    public FrameLayer(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void FrameLayerTest() throws InterruptedException {
        test = extent.createTest("Verify Layer On Canvas");
        test.assignCategory("UI Testing");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        AllButtons B = new AllButtons(driver);
        TopScreenButton T = new TopScreenButton(driver);


        selectImage(1);
        test.log(Status.INFO, "Image Is Selected");

        wait.until(ExpectedConditions.elementToBeClickable(B.Editbutton));
        B.Editbutton.click();
        Log.addLog("Select Edit Button");
        test.log(Status.INFO, "Edit Button Clicked");

        LayerClick();

        String screenShotPath = MobileActions.Screenshot("Layer View");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        T.LayerButton.click();
        Log.addLog("Close Layer");
        test.log(Status.INFO, "Layer Closed");

        String screenShotPath1 = MobileActions.Screenshot("Close Layer");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.Save.click();
        Log.addLog("Save Button Clicked");
        test.log(Status.INFO, "Save Button Clicked");

        B.Portrait.click();
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

    int currentIndex = 0;

    private void selectImage(int _index) {

        int index = _index;
        String id = "com.nra.productmarketingmaker:id/clickView";
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

    public void LayerClick() {
        TopScreenButton T = new TopScreenButton(driver);


        if (T.LayerButton != null && T.LayerButton.isDisplayed()) {
            Log.addLog("Layer Button Is Visible");
            T.LayerButton.click();
            Log.addLog("Layer Button Clickable");
            test.log(Status.INFO, "Layer Button Is Clicked");
        } else {

            Log.addLog("Layer Button Not Visible");
            test.log(Status.FAIL, "Layer Button Is Not Visible");
        }
    }

    private void clickRateUsDialog() {
        AllButtons B = new AllButtons(driver);
        if (B.NotNow != null) {
            if (B.NotNow.isDisplayed()) {
                B.NotNow.click();
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
