package ImageStickerCase;

import ImageModule.CropAspect;
import ImageModule.EditImage;
import io.appium.java_client.android.AndroidDriver;

public class CropAspectCase {public CropAspectCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void CropAspectTestCase() {

        CropAspect E = new CropAspect(driver);

        try {
            E.CropAspectTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
