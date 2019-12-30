package FontModuleCase;

import FontModule.TextRotation;
import io.appium.java_client.android.AndroidDriver;

public class TextRotationCase {
    public TextRotationCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void TextRotationTestCase() {


       TextRotation R = new TextRotation(driver);

        try {
            R.TextRotationTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
