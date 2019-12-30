package ImageStickerCase;

import ImageModule.AspectRatio;
import ImageModule.AspectScale;
import io.appium.java_client.android.AndroidDriver;

public class AspectRatioCase {public AspectRatioCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void AspectRatioTestCase() {

        AspectRatio E = new AspectRatio(driver);

        try {
            E.AspectRatioTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
