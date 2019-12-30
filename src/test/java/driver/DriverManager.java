package driver;

import actions.MobileActions;
import appium.AppiumServer;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Apps;
import utils.Devices;
import utils.Log;

import java.util.concurrent.TimeUnit;

public class DriverManager {


    public static AndroidDriver initDriver(Devices device, Apps app, AppiumServer appiumServer) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getVersion());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.getName());
        capabilities.setCapability(MobileCapabilityType.NO_RESET, Constants.NO_RESET);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET,Constants.FULL_RESET);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        // set app path if your need
//        capabilities.setCapability(MobileCapabilityType.APP, app.getAppPath());
        capabilities.setCapability("appPackage", app.getAppPackage());
        capabilities.setCapability("appActivity", app.getAppActivity());
        capabilities.setCapability("autoGrantPermissions", true);
        AndroidDriver driver = new AndroidDriver(appiumServer.startServer().getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        Log.addLog("[Driver on " + device.name() +"] setup is completed!");
        Log.addLog("[APP] " + app.name() + " is running...");

        return driver;
    }
}
