package ImageStickerCase;

import ImageModule.CropAdjustSize;
import ImageModule.CropAspect;
import io.appium.java_client.android.AndroidDriver;

public class CropAdjustSizeCase{public CropAdjustSizeCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void CropAdjustSizeTestCase() {

        CropAdjustSize E = new CropAdjustSize(driver);

        try {
            E.CropAdjustSizeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
