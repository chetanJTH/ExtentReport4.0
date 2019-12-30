package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.ImageButtons;
import pageObject.TopScreenButton;
import utils.Log;

import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class ImagePosition extends BaseProduct {
    public ImagePosition(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void ImagePositionTest() throws InterruptedException {
        test = extent.createTest("Image Position Buttons");
        test.assignCategory("Smoke");


        AllButtons B = new AllButtons(driver);


        B.TopPositionButton.click();
        Log.addLog("Top position button is Clickable");
        test.log(Status.INFO, "Top Position Button Clicked");

        B.BottomPositionButton.click();
        Log.addLog("Bottom position button is Clickable");
        test.log(Status.INFO, "Bottom Position Button Clicked");

        B.LeftPositionButton.click();
        Log.addLog("Left position button is Clickable");
        test.log(Status.INFO, "Left Position Button Clicked");


        B.RightPositionButton.click();
        Log.addLog("Right position button is Clickable");
        test.log(Status.INFO, "Right Position Button Clicked");


        Log.addLog("All Position Buttons Working Properly");
        test.log(Status.INFO, "All Position Buttons Working Properly");


    }


}
