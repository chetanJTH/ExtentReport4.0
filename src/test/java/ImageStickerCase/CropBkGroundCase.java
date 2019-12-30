package ImageStickerCase;

import ImageModule.CropBkGround;
import io.appium.java_client.android.AndroidDriver;

public class CropBkGroundCase {public CropBkGroundCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void CropBkGroundTestCase() {

        CropBkGround E = new CropBkGround(driver);

        try {
            E.CropBkGroundTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
