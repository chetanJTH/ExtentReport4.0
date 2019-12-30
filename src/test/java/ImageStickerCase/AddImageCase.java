package ImageStickerCase;

import com.aventstack.extentreports.ExtentTest;

import ImageModule.AddImage;

import io.appium.java_client.android.AndroidDriver;

public class AddImageCase {

	public AddImageCase(AndroidDriver driver) {
        this.driver = driver;
    }

    private AndroidDriver driver;

    public void AddImageTestCase() {

        AddImage I = new AddImage(driver);

        try {
            I.AddImageTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
