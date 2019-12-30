package ImageStickerCase;

import ImageModule.EraseAutoFunction;
import ImageModule.EraseImage;
import io.appium.java_client.android.AndroidDriver;

public class EraseAutoFunctionCase {public EraseAutoFunctionCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void EraseAutoFunctionTestCase() {

        EraseAutoFunction E = new EraseAutoFunction(driver);

        try {
            E.EraseAutoFunctionTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
