package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.AllSeekBar;
import pageObject.TextButton;
import pageObject.TopScreenButton;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class UndoStyle extends BaseProduct {
    public UndoStyle(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void UndoStyleTest() throws InterruptedException {
        test = extent.createTest("Check Undo Redo Style");

        test.assignCategory("Sanity");


        TextButton T = new TextButton(driver);
        TopScreenButton TS = new TopScreenButton(driver);


        T.Stylebutton.click();
        Log.addLog("FontStyleCase Button Is Clickable");
        test.log(Status.INFO, "FontStyleCase Button Is Clicked");

        T.Underline.click();
        Log.addLog("Underline Button Is Clickable");
        test.log(Status.INFO, "Underline Button Is Clicked");

        T.UpperCase.click();
        Log.addLog("UpperCase Button Is Clickable");
        test.log(Status.INFO, "UpperCase Button Is Clicked");

        T.LowerCase.click();
        Log.addLog("LowerCase Button Is Clickable");
        test.log(Status.INFO, "LowerCase Button Is Clicked");

        T.TitleCase.click();
        Log.addLog("TitleCase Button Is Clickable");
        test.log(Status.INFO, "TitleCase Button Is Clicked");

        AndroidElement undoButton = (AndroidElement) TS.UndoButton;
        int i;
        for (i = 0; i <= 3; i++) {
            undoButton.click();
            Log.addLog("Undo button clicked");

        }

        String screenShotPath3 = MobileActions.Screenshot("Undo Font Style");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AndroidElement redoButton = (AndroidElement) TS.RedoButton;
        int z;
        for (z = 0; z <= 3; z++) {
            redoButton.click();
            Log.addLog("Redo button clicked");

        }

        String screenShotPath4 = MobileActions.Screenshot("Redo Font Style");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
