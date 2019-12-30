package ImageStickerCase;

import ImageModule.ImgColorCode;
import ImageModule.ImgCropShape;
import io.appium.java_client.android.AndroidDriver;

public class ImgColorCodeCase {public ImgColorCodeCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void ImgColorCodeTestCase() {

        ImgColorCode C = new ImgColorCode(driver);

        try {
            C.ImgColorCodeTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
