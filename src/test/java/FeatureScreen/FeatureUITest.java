package FeatureScreen;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.SettingPage;
import pageObject.TopScreenButton;
import pageObject.myDesignPage;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class FeatureUITest extends BaseProduct {
    public FeatureUITest(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void FeatureScreenTest () throws InterruptedException {
        test = extent.createTest("Feature Screen Test");
        test.assignCategory("Usability");

        AllButtons B = new AllButtons(driver);

        FeatureButton();

        Thread.sleep(1000);
        String screenShotPath = MobileActions.Screenshot("Feature Screen");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CategoryButton();

        Thread.sleep(1000);
        String screenShotPath1 = MobileActions.Screenshot("Category Screen");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ToolsButton();

        Thread.sleep(1000);
        String screenShotPath2 = MobileActions.Screenshot("Tools Screen");
        try {
            test.addScreenCaptureFromPath(screenShotPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyDesignButton();

        Thread.sleep(1000);
        String screenShotPath3 = MobileActions.Screenshot("MyDesign Screen");
        try {
            test.addScreenCaptureFromPath(screenShotPath3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SettingButton();

        Thread.sleep(1000);
        String screenShotPath4 = MobileActions.Screenshot("Setting Screen");
        try {
            test.addScreenCaptureFromPath(screenShotPath4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BackButton();

    }

    public void FeatureButton(){
        AllButtons B = new AllButtons(driver);

        if (B.FEATURED != null) {
            if ((B.FEATURED).isDisplayed()) {
                Log.addLog("FEATURED Button Is Visible");
                B.FEATURED.click();
                Log.addLog("FEATURED Button Is Clickable");
                test.log(Status.INFO, "FEATURED Button Is Clicked");
            } else {
                Log.addLog("FEATURED Button Is Not Visible");
            }
        }
    }

    public void CategoryButton(){
        AllButtons B = new AllButtons(driver);
        if (B.CATEGORIES != null) {
            if ((B.CATEGORIES).isDisplayed()) {
                Log.addLog("CATEGORIES Button Is Visible");
                B.CATEGORIES.click();
                Log.addLog("CATEGORIES Button Is Clickable");
                test.log(Status.INFO, "CATEGORIES Button Is Clicked");
            } else {
                Log.addLog("CATEGORIES Button Is Not Visible");
            }
        }
    }

    public void ToolsButton(){
        AllButtons B = new AllButtons(driver);
        if (B.TOOLS != null) {
            if ((B.TOOLS).isDisplayed()) {
                Log.addLog("TOOLS Button Is Visible");
                B.TOOLS.click();
                Log.addLog("TOOLS Button Is Clickable");
                test.log(Status.INFO, "TOOLS Button Is Clicked");
            } else {
                Log.addLog("TOOLS Button Is Not Visible");
            }
        }
    }

    public void MyDesignButton(){
        myDesignPage M = new myDesignPage(driver);
        if (M.MYDESIGN != null) {
            if ((M.MYDESIGN).isDisplayed()) {
                Log.addLog("MYDESIGN Button Is Visible");
                M.MYDESIGN.click();
                Log.addLog("MYDESIGN Button Is Clickable");
                test.log(Status.INFO, "MYDESIGN Button Is Clicked");
            } else {
                Log.addLog("MYDESIGN Button Is Not Visible");
            }
        }
    }

    public void SettingButton(){
        AllButtons B = new AllButtons(driver);
        if (B.Setting != null) {
            if ((B.Setting).isDisplayed()) {
                Log.addLog("Setting Button Is Visible");
                B.Setting.click();
                Log.addLog("Setting Button Is Clickable");
                test.log(Status.INFO, "Setting Button Is Clicked");
            } else {
                Log.addLog("Setting Button Is Not Visible");
            }
        }
    }

    public void BackButton(){
        SettingPage S = new SettingPage(driver);
        if (S.BtnBack != null) {
            if ((S.BtnBack).isDisplayed()) {
                Log.addLog("Back Button Is Visible");
                S.BtnBack.click();
                Log.addLog("Back Button Is Clickable");
                test.log(Status.INFO, "Back Button Is Clicked");
            } else {
                Log.addLog("Back Button Is Not Visible");
            }
        }
    }


}

