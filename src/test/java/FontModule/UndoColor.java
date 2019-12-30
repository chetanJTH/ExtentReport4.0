package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.ColorLibrary;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.List;

public class UndoColor extends BaseProduct {
    public UndoColor(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void UndoColorTest() throws InterruptedException {
        test = extent.createTest("Check Undo Redo Color");

        test.assignCategory("Sanity");

        ColorLibrary C = new ColorLibrary(driver);
        TopScreenButton TS = new TopScreenButton(driver);


        C.Color.click();
        Log.addLog("FontColor button clicked");
        test.log(Status.INFO, "FontColor button clicked");

        selectColor(8);
        Log.addLog("FontColor is selected");
        test.log(Status.INFO, "FontColor is selected");

        TS.UndoButton.click();
        Log.addLog("Undo button clicked");
        test.log(Status.INFO, "Undo button clicked");

        String screenShotPath5 = MobileActions.Screenshot("Undo color Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.RedoButton.click();
        Log.addLog("Redo button clicked");
        test.log(Status.INFO, "Redo button clicked");

        String screenShotPath6 = MobileActions.Screenshot("Redo color Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath6);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
}
