package ProductAdMaker;

import actions.MobileActions;
import io.appium.java_client.android.AndroidDriver;

public class BaseProduct {

    public BaseProduct(AndroidDriver driver){
        this.driver = driver;
        this.actions = new MobileActions(driver);
    }
    public AndroidDriver driver;
    public MobileActions actions;
}
