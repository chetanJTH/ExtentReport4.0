package FontModuleCase;

import FontModule.ParagraphStyle;
import FontModule.ParagraphVerticalSpace;
import io.appium.java_client.android.AndroidDriver;

public class ParagraphStyleCase {
    public ParagraphStyleCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ParagraphStyleTestCase() {


        ParagraphStyle P = new ParagraphStyle(driver);

        try {
            P.ParagraphStyleTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

