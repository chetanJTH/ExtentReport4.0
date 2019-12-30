package FeatureScreenCase;

import FeatureScreen.FeatureUITest;
import FeatureScreen.SearchFeature;
import io.appium.java_client.android.AndroidDriver;

public class SearchFeatureCase {
    public SearchFeatureCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void SearchBarTest() {

        //    ExtentTest extent = ExtentReport.shared().getExtentTest("Add Text, case 4");
        SearchFeature F = new SearchFeature(driver);

        try {
            F.FeatureScreenTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
