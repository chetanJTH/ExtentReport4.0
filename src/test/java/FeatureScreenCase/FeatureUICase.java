package FeatureScreenCase;

import FeatureScreen.FeatureUITest;
import FontModule.AddText;
import io.appium.java_client.android.AndroidDriver;

public class FeatureUICase {
    public FeatureUICase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void FeatureScreenUITest() {

        //    ExtentTest extent = ExtentReport.shared().getExtentTest("Add Text, case 4");
        FeatureUITest F = new FeatureUITest(driver);

        try {
            F.FeatureScreenTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


