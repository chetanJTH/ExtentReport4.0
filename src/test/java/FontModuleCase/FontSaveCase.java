package FontModuleCase;

import FontModule.FontSave;
import FontModule.FontStyle;
import io.appium.java_client.android.AndroidDriver;

public class FontSaveCase {

    public FontSaveCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontSaveTestCase() {


        FontSave f = new FontSave(driver);

        try {
            f.FontSaveTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
