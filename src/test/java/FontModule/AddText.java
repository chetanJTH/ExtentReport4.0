package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.TextButton;
import pageObject.myDesignPage;
import utils.Log;
import java.io.IOException;
import java.util.NoSuchElementException;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;


public class AddText extends BaseProduct {


    public AddText(AndroidDriver driver) {
        super(driver);
    }




    @Test
    public void AddTextTest() throws InterruptedException, NoSuchElementException {
        test = extent.createTest("Add Text In Card");
        test.assignCategory("functions");

        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);
        AllButtons B = new AllButtons(driver);


        MyDesignPage();

        wait.until(ExpectedConditions.elementToBeClickable(D.CreateOwn));

        CreateOwnButton();


//        wait.until(ExpectedConditions.elementToBeClickable(B.Editbutton));
//        B.Editbutton.click();
//        Log.addLog("Select Edit Button");

        wait.until(ExpectedConditions.elementToBeClickable(D.IstaPortrait));
        D.IstaPortrait.click();
        Log.addLog("Custom Size Selected");

        AddTextButton();

        Thread.sleep(2000);

        InputText();

        String screenShotPath = MobileActions.Screenshot("Input Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);

        OkButtonClick();

        String screenShotPath1 = MobileActions.Screenshot("Text on Canvas");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void MyDesignPage() {
        myDesignPage D = new myDesignPage(driver);

        if (D.MYDESIGN != null) {
            if ((D.MYDESIGN).isDisplayed()) {
                Log.addLog("My Design Button Is Visible");
                D.MYDESIGN.click();
                Log.addLog("My Design Button Clickable");
                test.log(Status.INFO, "My Design Button Is Clicked");
            } else {
                Log.addLog("My Design Button Not Visible");
                test.log(Status.FAIL, "My Design Button Is Not Clickable");
            }
        }
    }

    public void CreateOwnButton() {
        myDesignPage D = new myDesignPage(driver);
        if (D.CreateOwn != null) {
            if ((D.CreateOwn).isDisplayed()) {
                Log.addLog("Create Own Button Is Visible");
                D.CreateOwn.click();
                Log.addLog("Create Own Button Clickable");
                test.log(Status.INFO, "Create Own Button Is Clicked");
            } else {
                Log.addLog("Create Own Button Not Visible");
                test.log(Status.FAIL, "Create Own Button Is Not Clickable");
            }
        }
    }

    public void AddTextButton() {
        TextButton T = new TextButton(driver);
        if (T.AddTextButton != null && T.AddTextButton.isDisplayed()) {
            Log.addLog("AddText Button Is Visible");
            T.AddTextButton.click();
            Log.addLog("AddText Button Clickable");
            test.log(Status.INFO, "AddText Button Is Clicked");
        } else {
            Log.addLog("AddText Button Not Visible");
            test.log(Status.FAIL, "AddText Button Is Not Clickable");
        }
    }

    public void InputText() {
        TextButton T = new TextButton(driver);
        if (T.iText != null) {
            if ((T.iText).isDisplayed()) {
                Log.addLog("Input Text Field Is Visible");
                T.iText.sendKeys("Auto");
                Log.addLog("Input Text Auto");
                test.log(Status.INFO, "Entered Text Auto");
            } else {
                Log.addLog("Input Text Field Not Visible");
                test.log(Status.FAIL, "Input Text Field Is Not Clickable");
            }
        }
    }

    public void OkButtonClick() {
        AllButtons B = new AllButtons(driver);
        if (B.OkButton != null) {

            if ((B.OkButton).isDisplayed()) {
                Log.addLog("Ok Button Is Visible");
                B.OkButton.click();
                Log.addLog("Ok Button Is Clickable");
                test.log(Status.INFO, "Ok Button Is Clickable");
            } else {
                Log.addLog("Ok Button Is Not Visible");
                test.log(Status.FAIL, "Ok Button Is Not Clickable");
            }
        }
    }

    public void ClickSkipButton() {
        AllButtons B = new AllButtons(driver);
        try {
            if (B.Skip != null && B.Skip.isDisplayed()) {
                Log.addLog("Skip Button is displayed");
                B.Skip.click();
                Log.addLog("Skip button is clicked");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            AddTextButton();

        }
    }

}
