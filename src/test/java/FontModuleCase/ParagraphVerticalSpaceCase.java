package FontModuleCase;

import FontModule.ParagraphVerticalSpace;
import FontModule.PositionLock;
import io.appium.java_client.android.AndroidDriver;

public class ParagraphVerticalSpaceCase {
    public ParagraphVerticalSpaceCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void ParagraphVerticalSpaceTestCase() {


        ParagraphVerticalSpace P = new ParagraphVerticalSpace(driver);

        try {
            P.ParagraphVerticalSpaceTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
