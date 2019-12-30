package FontModule;

import ProductAdMaker.BaseProduct;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObject.AllButtons;
import java.time.Duration;
import utils.Log;
import static BasePackage.BaseTest.extent;
import static BasePackage.BaseTest.test;

import java.time.Duration;

public class TextPositionButtons extends BaseProduct {
    public TextPositionButtons(AndroidDriver driver) {
        super(driver);
    }



    @Test
    public void TextPositionButtonsTest () throws InterruptedException{
        test = extent.createTest("Verify Position Buttons");

        test.assignCategory("UI Testing");

        AllButtons B = new AllButtons(driver);

        B.TopPositionButton.isDisplayed();
        Log.addLog("Top Position Button is Displayed");

//        WebElement TopPose = driver.findElementById("com.nra.productmarketingmaker:id/btnControlTop");
//        AndroidTouchAction t = new AndroidTouchAction(driver);
//        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(TopPose)).withDuration(Duration.ofMillis(5000))).release().perform();
        B.TopPositionButton.click();
        Log.addLog("Top position button is Clickable");
        test.log(Status.INFO, "Top Position Button Clicked");

        B.BottomPositionButton.isDisplayed();
        Log.addLog("Bottom Position Button is Displayed");

        B.BottomPositionButton.click();
        Log.addLog("Bottom position button is Clickable");
        test.log(Status.INFO, "Bottom Position Button Clicked");

        B.LeftPositionButton.isDisplayed();
        Log.addLog("Left Position Button is Displayed");

        B.LeftPositionButton.click();
        Log.addLog("Left position button is Clickable");
        test.log(Status.INFO, "Left Position Button Clicked");

        B.RightPositionButton.isDisplayed();
        Log.addLog("Right Position Button is Displayed");

        B.RightPositionButton.click();
        Log.addLog("Right position button is Clickable");
        test.log(Status.INFO, "Right Position Button Clicked");

        Log.addLog("All Position Buttons Working Properly");
        test.log(Status.INFO, "All Position Buttons Working Properly");
    }
}
