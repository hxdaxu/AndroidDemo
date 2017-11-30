package com.hqc.demo.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by huangqingchun on 17-11-30.
 */

public class WifiSsidUtils {


    public static String convertSsid(String value) {
        String val = value;
        if (value.charAt(0) != '"') {
            val =  "\"" + createFromHex(value) + "\"";
            //TODO: convert a hex string that is not UTF-8 decodable to a P-formatted
            //supplicant string
        }
        return val;
    }

    private static String createFromHex(String hex){
        try {
            Class<?> c = Class.forName("android.net.wifi.WifiSsid");
            Method method = c.getMethod("createFromHex",String.class);
            return method.invoke(null,hex).toString();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

}
