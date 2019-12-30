package utils;

import io.appium.java_client.android.nativekey.AndroidKey;



public class Keys {

    public static AndroidKey withChar(char key) {

        switch (Character.getNumericValue(key)) {

            case 0: return AndroidKey.NUMPAD_0;
            case 1: return AndroidKey.NUMPAD_1;
            case 2: return AndroidKey.NUMPAD_2;
            case 3: return AndroidKey.NUMPAD_3;
            case 4: return AndroidKey.NUMPAD_4;
            case 5: return AndroidKey.NUMPAD_5;
            case 6: return AndroidKey.NUMPAD_6;
            case 7: return AndroidKey.NUMPAD_7;
            case 8: return AndroidKey.NUMPAD_8;
            default: return AndroidKey.NUMPAD_9;
        }
    }
}
