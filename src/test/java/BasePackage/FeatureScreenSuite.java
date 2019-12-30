package BasePackage;

import org.testng.annotations.Test;

public class FeatureScreenSuite extends BaseTest {

    @Test(priority = 28)
    void FeatureUITest() {
        featureUICase.FeatureScreenUITest();
    }

    @Test(priority = 29)
    void SearchFeature() {
        searchFeatureCase.SearchBarTest();
    }

}
