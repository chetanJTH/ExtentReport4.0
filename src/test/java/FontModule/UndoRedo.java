package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.*;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;
import java.util.List;

public class UndoRedo extends BaseProduct {
    public UndoRedo(AndroidDriver driver) {
        super(driver);
    }

    @Test
    public void UndoRedoText() throws InterruptedException {
        test = extent.createTest("Check Undo Redo Buttons");
        test.assignCategory("Sanity");

        AllButtons B = new AllButtons(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);
        TextButton T = new TextButton(driver);


        D.MYDESIGN.click();
        Log.addLog("My design page clicked");
        test.log(Status.INFO, "My design page clicked");

        D.CreateOwn.click();
        Log.addLog("Create own clicked");
        test.log(Status.INFO, "Create own clicked");

        wait.until(ExpectedConditions.elementToBeClickable(D.IstaPortrait));
        D.IstaPortrait.click();
        Log.addLog("Custom size selected");
        test.log(Status.INFO, "Custom size selected");

        T.AddTextButton.click();
        Log.addLog("Add text button clicked");
        test.log(Status.INFO, "Add Text Button Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(T.iText));
        T.iText.sendKeys("Test");

        String screenShotPath = MobileActions.Screenshot("Input Text UR");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.OkButton.click();
        Log.addLog("Ok button clicked");

        UndoButtonClick();

        String screenShotPath1 = MobileActions.Screenshot("Undo Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RedoButtonClick();

        String screenShotPath2 = MobileActions.Screenshot("Redo Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void UndoButtonClick() {
        TopScreenButton TS = new TopScreenButton(driver);

        if (TS.UndoButton != null && TS.UndoButton.isDisplayed()) {
                Log.addLog("Undo Button Is Visible");
                TS.UndoButton.click();
                Log.addLog("Undo Button Clickable");
                test.log(Status.INFO, "Undo Button Clicked");
            } else {

            Log.addLog("Undo Button Not Visible");
            test.log(Status.FAIL, "Undo Button Is Not Visible");
        }
    }

    public void RedoButtonClick() {
        TopScreenButton TS = new TopScreenButton(driver);
        if (TS.RedoButton != null && TS.RedoButton.isDisplayed()) {
                Log.addLog("Redo Button Is Visible");
                TS.RedoButton.click();
                Log.addLog("Redo Button Clickable");
                test.log(Status.INFO, "Redo Button Clicked");
            } else {

            Log.addLog("Redo Button Not Visible");
            test.log(Status.FAIL, "Redo Button Is Not Visible");
        }
    }


}
