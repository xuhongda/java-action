package com.xu.eventdispatch;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("com/yanek/event/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
