package ImageStickerCase;

import ImageModule.AspectScale;
import ImageModule.CropAspect;
import io.appium.java_client.android.AndroidDriver;

public class AspectScaleCase {public AspectScaleCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void AspectScaleTestCase() {

        AspectScale E = new AspectScale(driver);

        try {
            E.AspectScaleTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
