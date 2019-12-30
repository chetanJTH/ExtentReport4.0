package ImageStickerCase;

import ImageModule.CropEdit;
import io.appium.java_client.android.AndroidDriver;

public class CropEditCase {public CropEditCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void CropEditTestCase() {

        CropEdit E = new CropEdit(driver);

        try {
            E.CropEditTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
