package FontModuleCase;

import FontModule.AddText;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class AddTextCase {
    public AddTextCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AddTextTestCase() {

    //    ExtentTest extent = ExtentReport.shared().getExtentTest("Add Text, case 4");
        AddText addText = new AddText(driver);

        try {
            addText.AddTextTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
