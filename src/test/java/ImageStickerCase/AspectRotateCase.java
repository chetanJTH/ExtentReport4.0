package ImageStickerCase;

import ImageModule.AspectRotate;
import ImageModule.AspectScale;
import io.appium.java_client.android.AndroidDriver;

public class AspectRotateCase {public AspectRotateCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void AspectRotateTestCase() {

        AspectRotate E = new AspectRotate(driver);

        try {
            E.AspectRotateTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
