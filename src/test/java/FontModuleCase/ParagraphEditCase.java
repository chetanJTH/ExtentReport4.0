package FontModuleCase;

import FontModule.LatterSpace;
import FontModule.ParagraphEdit;
import io.appium.java_client.android.AndroidDriver;

public class ParagraphEditCase {public ParagraphEditCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ParagraphEditTestCase() {


        ParagraphEdit P = new ParagraphEdit(driver);

        try {
            P.ParagraphEditTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
