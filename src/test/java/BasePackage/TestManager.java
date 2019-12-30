package BasePackage;

import appium.AppiumServer;
import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import utils.Apps;
import utils.Devices;
import utils.Log;
import utils.Utils;

public class TestManager {

    public static TestManager testAndroid(Devices device, Apps app) {
        return new TestManager(device, app);
    }
    public TestManager(Devices device, Apps app) {
        this.device = device;
        this.app = app;
        initAndroid();
    }
    private Devices device;
    private Apps app;
    private AppiumServer appiumServer;

    private static boolean isLaughed = false;
    private AndroidDriver androidDriver;
    public AndroidDriver getDriverAndroid() {
        return androidDriver;
    }
    public void initAndroid() {

        if (!isLaughed && device == Devices.Emulator) {
            Utils.launchEmulator();
            isLaughed = true;
        }
        appiumServer = new AppiumServer();
        androidDriver = new DriverManager().initDriver(device, app, appiumServer);
    }

    public void quitTest() {
        if (androidDriver != null) {
            Log.addLog("[APP] " + app.name() + " has been stopped");
            androidDriver.quit();
        }
        if (appiumServer != null) {
            appiumServer.stopServer();
        }
    }
}
