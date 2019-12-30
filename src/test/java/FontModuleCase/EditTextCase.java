package FontModuleCase;

import FontModule.EditText;
import io.appium.java_client.android.AndroidDriver;

public class EditTextCase {
    public EditTextCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void EditTextTestCase() {

        //    ExtentTest extent = ExtentReport.shared().getExtentTest("Add Text, case 4");
        EditText E = new EditText(driver);

        try {
            E.EditTextTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
