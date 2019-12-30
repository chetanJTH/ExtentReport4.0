package ImageModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.*;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.io.IOException;

public class EditImage extends BaseProduct {
    public EditImage(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void EditImageTest () throws InterruptedException{
        test = extent.createTest("Edit current Image");
        test.assignCategory("Usability");

        AllButtons B = new AllButtons(driver);
        ImageButtons I = new ImageButtons(driver);
        ShapeCropLibrary S = new ShapeCropLibrary(driver);
        WebDriverWait wait = new WebDriverWait(driver, 25);
        myDesignPage D = new myDesignPage(driver);


        AndroidElement tabLayout = (AndroidElement) driver.findElementById("com.nra.productmarketingmaker:id/tabLayout");
        findAndSelectText(tabLayout, false,"Edit"); // test scroll to last item

        EditImageButton();

        Thread.sleep(1000);
        String screenShotPath = MobileActions.Screenshot("Edit Image");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(B.PickYourOwn));
        findAndSelectText(tabLayout, true,"Square"); // test scroll to last item

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.nra.productmarketingmaker:id/stickerThumb")));
        driver.findElementByXPath("(//android.widget.RelativeLayout)[7]").click();

        wait.until(ExpectedConditions.elementToBeClickable(B.Rotation));
        test.log(Status.INFO, "Sticker Edited");

    }

    public void EditImageButton(){
        ImageButtons I = new ImageButtons(driver);

        if (I.EditImage != null) {
            if ((I.EditImage).isDisplayed()) {
                Log.addLog("Edit Image Is Visible");
                I.EditImage.click();
                Log.addLog("Edit Image Is Clickable");
                test.log(Status.INFO, "Edit Image Button Is Clicked");
            } else {
                Log.addLog("Edit Image Is Not Visible");
            }
        }
    }

    public void ShapeButton(){
        AllButtons B = new AllButtons(driver);

        if (B.Shape != null) {
            if ((B.Shape).isDisplayed()) {
                Log.addLog("Shape Button Is Visible");
                B.Shape.click();
                Log.addLog("Shape Button Is Clickable");
                test.log(Status.INFO, "Shape Button Is Clicked");
            } else {
                Log.addLog("Shape Button Is Not Visible");
            }
        }
    }

    private int MAX_COUNT = 5;
    private int COUNT = 0;
    private void findAndSelectText(AndroidElement parent, boolean isNext, String text) {

        Log.addLog("finding...");
        while (!isPresent(getXpath(text)) && COUNT < MAX_COUNT) {
            actions.tapOn(parent, isNext ? 90 : 10);
            COUNT++;
            Log.addLog("COUNT "+ COUNT);
        }
        COUNT = 0;

        driver.findElementByXPath(getXpath(text)).click();
        Log.addLog("find completed...");
    }

    private String getXpath(String text) {
        String xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\""+ text +"\"]";
        Log.addLog(xpath);
        return xpath;
    }

    private boolean isPresent(String xpath) {

        try {

            AndroidElement element = (AndroidElement) driver.findElementByXPath(xpath);
            Log.addLog("isDisplayed: " + element.isDisplayed());
            return element.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.addLog("isDisplayed: false");
            return false;
        }
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}

