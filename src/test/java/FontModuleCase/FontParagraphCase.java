package FontModuleCase;

import FontModule.FontParagraph;
import FontModule.FontStyle;
import io.appium.java_client.android.AndroidDriver;

public class FontParagraphCase {

    public FontParagraphCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FontParagraphTestCase() {


        FontParagraph f = new FontParagraph(driver);

        try {
            f.FontParagraphTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
