package FontModuleCase;

import FontModule.FontLibrary;
import io.appium.java_client.android.AndroidDriver;

public class FontLibraryCase {

    public FontLibraryCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontLibraryTestCase() {


        FontLibrary F = new FontLibrary(driver);

        try {
            F.FontLibraryTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



