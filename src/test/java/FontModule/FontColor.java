package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.ColorLibrary;
import utils.Log;
import java.io.IOException;
import java.util.List;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

public class FontColor extends BaseProduct {
    public FontColor(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FontColorTest() throws InterruptedException {
        test = extent.createTest("Set color on Text");
        test.assignCategory("Sanity");

        AllButtons B = new AllButtons(driver);
        AllSeekBar S = new AllSeekBar(driver);
        ColorLibrary C = new ColorLibrary(driver);
        MobileActions M = new MobileActions(driver);
        try {
            ClickColorButton();

            selectColor(21);
            Log.addLog("FontColor is selected");
            test.log(Status.INFO, "FontColor Selected");

            String screenShotPath = MobileActions.Screenshot("Select Color From List");
            try {
                test.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ColorPickerButton();

            AndroidElement seekbar = (AndroidElement) S.ColorSeekBar;

            M.colorSeekBarForward(seekbar, 80);
            String screenShotPath1 = MobileActions.Screenshot("Color Seekbar");
            try {
                test.addScreenCaptureFromPath(screenShotPath1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            AndroidElement colorseekbar = (AndroidElement) S.ColorViewGroup;

            M.viewGroupForward(colorseekbar, 90, 50);
            String screenShotPath2 = MobileActions.Screenshot("Color ViewGroup");
            try {
                test.addScreenCaptureFromPath(screenShotPath2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            C.ColorPickButton.click();
            test.log(Status.INFO, "FontColor Is Picked From ViewGroup");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    int currentIndex = 0;

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


    public void ClickColorButton() {
        ColorLibrary C = new ColorLibrary(driver);

        if (C.Color != null) {

                if ((C.Color).isDisplayed()) {
                    Log.addLog("FontColor Button Is Visible");
                    C.Color.click();
                    Log.addLog("FontColor Button Is Clickable");
                    test.log(Status.INFO, "FontColor Button Is Clicked");
                } else {

                Log.addLog("FontColor Button Is Not Visible");
                test.log(Status.FAIL, "FontColor Button Is Not Clickable");
            }
        }
    }

    public void ColorPickerButton() {
        ColorLibrary C = new ColorLibrary(driver);
        if (C.ColorPicker != null) {
            if ((C.ColorPicker).isDisplayed()) {
                Log.addLog("FontColor Picker Is Visible");
                C.ColorPicker.click();
                Log.addLog("FontColor Picker Is Clickable");
                test.log(Status.INFO, "FontColor Picker Button Clicked");
            } else {
                Log.addLog("FontColor Picker Is Not Visible");
            }
        }
    }

}