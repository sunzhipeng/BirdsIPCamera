package com.szp.birdsipcamera;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import org.easydarwin.easyipcamera.config.Config;

/**
 * Created by 至鹏 on 2018/6/16.
 */

public class BirdsApplication extends Application {

    private static final String TAG = "BirdsApplication";
    private static BirdsApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        Log.d(TAG, "onCreate: Start Application");
    }

    public static BirdsApplication getBirdsApplication() {
        return mApplication;
    }

    public void saveStringIntoPref(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getPort() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String port = sharedPreferences.getString(Config.SERVER_PORT, Config.DEFAULT_SERVER_PORT);
        return port;
    }

    public String getId() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String id = sharedPreferences.getString(Config.STREAM_ID, Config.DEFAULT_STREAM_ID);

        saveStringIntoPref(Config.STREAM_ID, id);
        return id;
    }

}
