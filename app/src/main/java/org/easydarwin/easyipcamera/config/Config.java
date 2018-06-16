package org.easydarwin.easyipcamera.config;

/**
 * Created by 至鹏 on 2018/6/16.
 */

public class Config {
    public static final String SERVER_PORT = "serverPort";
    public static final String STREAM_ID = "streamId";
    public static final String DEFAULT_SERVER_PORT = "8554";
    public static final String DEFAULT_STREAM_ID = String.valueOf((int) (Math.random() * 1000000 + 100000));
    public static final String PREF_NAME = "easy_pref";
    public static final String K_RESOLUTION = "k_resolution";
}
