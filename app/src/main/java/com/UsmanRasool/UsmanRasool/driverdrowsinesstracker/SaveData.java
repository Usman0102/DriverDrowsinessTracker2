package com.UsmanRasool.UsmanRasool.driverdrowsinesstracker;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Written by usman rasool  on 2018-02-16.
 */
public class SaveData {

    private static String __SaveDta_Key = "pref";
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    private static SaveData savedata;

    public static SaveData getInstance(Context context) {
        if (pref == null) {
            pref = context.getSharedPreferences(__SaveDta_Key, context.MODE_PRIVATE);
            editor = pref.edit();
            savedata = new SaveData();
        }
        return savedata;
    }

    static void setAlarmPoint(int val) {

        editor.putInt("alarmpoint", val);
        editor.commit();
    }

    static int getAlarmPoint() {

        int result = pref.getInt("alarmpoint", 20);
        return result;
    }

}
