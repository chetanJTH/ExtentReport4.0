package FontModuleCase;

import FontModule.EditText;
import FontModule.FontAutoSave;
import io.appium.java_client.android.AndroidDriver;

public class FontAutoSaveCase {
    public FontAutoSaveCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontAutoSaveTestCase() {

        //    ExtentTest extent = ExtentReport.shared().getExtentTest("Add Text, case 4");
        FontAutoSave E = new FontAutoSave(driver);

        try {
            E.FontAutoSaveTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
