package ImageStickerCase;

import ImageModule.EditImage;
import ImageModule.EraseImage;
import io.appium.java_client.android.AndroidDriver;

public class EditImageCase {public EditImageCase(AndroidDriver driver) {
    this.driver = driver;
}

    private AndroidDriver driver;

    public void EditImageTestCase() {

        EditImage E = new EditImage(driver);

        try {
            E.EditImageTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
