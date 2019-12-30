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
import pageObject.ColorLibrary;
import pageObject.FontLibraryButton;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.List;

public class UndoFont extends BaseProduct {
    public UndoFont(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void UndoFontTest() throws InterruptedException {
        test = extent.createTest("Check Undo Redo Fonts");

        test.assignCategory("Sanity");

        FontLibraryButton F = new FontLibraryButton(driver);
        TopScreenButton TS = new TopScreenButton(driver);


        F.Font.click();
        Log.addLog("Font Button Clicked");
        test.log(Status.INFO, "Font Button Clicked");

        selectFont(4);
        Log.addLog("Font is selected");
        test.log(Status.INFO, "Font is selected");

        TS.UndoButton.click();
        Log.addLog("Undo button clicked");
        test.log(Status.INFO, "Undo button clicked");

        String screenShotPath5 = MobileActions.Screenshot("Undo Font Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TS.RedoButton.click();
        Log.addLog("Redo button clicked");
        test.log(Status.INFO, "Redo button clicked");

        String screenShotPath6 = MobileActions.Screenshot("Redo Font Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath6);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
}
