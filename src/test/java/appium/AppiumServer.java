package appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.Log;

import java.io.File;



public class AppiumServer {

    private static AppiumDriverLocalService appiumService;
    private static AppiumServiceBuilder builder;


    public static AppiumDriverLocalService startServer() {

        String appiumJSPath = "C:Users/admin/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
        builder = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumJSPath))
                .withIPAddress("0.0.0.0")
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        appiumService = builder.build();
        appiumService.start();

        Log.println("[Appium] started on " + appiumService.getUrl());

        return appiumService;
    }

    public static void stopServer() {

        if (appiumService != null) {
            appiumService.stop();
            appiumService = null;
            Log.println("[Appium] stoped");
        }
    }

}
