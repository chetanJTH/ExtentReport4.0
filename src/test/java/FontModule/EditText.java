package FontModule;

import ProductAdMaker.BaseProduct;
import actions.MobileActions;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import pageObject.TextButton;
import utils.Log;
import java.io.IOException;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

public class EditText extends BaseProduct {
    public EditText(AndroidDriver driver) {
        super(driver);
    }


    @Test
    public void EditTextTest () throws InterruptedException{
        test = extent.createTest("Edit current Text");
        test.assignCategory("Usability");

        AllButtons B = new AllButtons(driver);
        TextButton T = new TextButton(driver);

        Thread.sleep(2000);

        EditButtonClick();

        Thread.sleep(2000);
        T.iText.click();
        Log.addLog("Click On Text Feild");
        test.log(Status.INFO, "Text Input Feild Clicked");

        T.iText.sendKeys(" Test ");
        Log.addLog("Text is Edited");
        test.log(Status.INFO, "Text Is Edited");

        Thread.sleep(1000);
        String screenShotPath = MobileActions.Screenshot("Edit Text");
        try {
            test.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        B.OkButton.click();
        Log.addLog("Press Ok Button");
        test.log(Status.INFO, "Ok Button Pressed");

        Thread.sleep(1000);
        String screenShotPath1 = MobileActions.Screenshot("Edit Text Done");
        try {
            test.addScreenCaptureFromPath(screenShotPath1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void EditButtonClick(){
        TextButton T = new TextButton(driver);

        if (T.EditText != null) {
            if ((T.EditText).isDisplayed()) {
                Log.addLog("Edit Text Is Visible");
                T.EditText.click();
                Log.addLog("Edit Text Is Clickable");
                test.log(Status.INFO, "Edit Text Button Is Clicked");
            } else {
                Log.addLog("Edit Text Is Not Visible");
            }
        }
    }
}
