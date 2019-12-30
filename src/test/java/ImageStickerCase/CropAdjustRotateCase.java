package ImageStickerCase;

import ImageModule.CropAdjustRotate;
import io.appium.java_client.android.AndroidDriver;

public class CropAdjustRotateCase {public CropAdjustRotateCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void CropAdjustRotateTestCase() {

        CropAdjustRotate E = new CropAdjustRotate(driver);

        try {
            E.CropAdjustRotateTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
