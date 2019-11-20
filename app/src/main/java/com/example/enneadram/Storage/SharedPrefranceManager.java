package com.example.enneadram.Storage;

import android.content.Context;
import android.content.SharedPreferences;

// Shared Prafrance Keys
enum SharedKeys{
    Points,FirstTime
        }

public class SharedPrefranceManager {
    Context context;
    private static final String SHARED_PREF_USER_POINTS = "user_enneagram";
    private static final String SHARED_PREF_USER_IS_FIRSTTIME = "user_is_firsttime";

    private static SharedPrefranceManager sharedPrefranceManager;

    private SharedPrefranceManager(Context context) {
        this.context = context;
    }

    public synchronized static SharedPrefranceManager getInastance(Context context){
        if (sharedPrefranceManager == null){
            sharedPrefranceManager = new SharedPrefranceManager(context);
        }
        return sharedPrefranceManager;
    }


    //--------------- user -------------//
    public void savePoints(int Points) {
        SharedPreferences.Editor sharedPreferences = context.getSharedPreferences(SHARED_PREF_USER_POINTS, Context.MODE_PRIVATE).edit();

        sharedPreferences.putString(SharedKeys.Points.toString(), String.valueOf(Points));

        sharedPreferences.apply();
    }


    // Check if user first-time on app or not.
    public boolean isFirstTime() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_USER_IS_FIRSTTIME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(SharedKeys.FirstTime.toString(),true);

    }

    // Save First-time status true or false
    public void saveFirstTime(boolean status) {
        SharedPreferences.Editor sharedPreferences = context.getSharedPreferences(SHARED_PREF_USER_IS_FIRSTTIME, Context.MODE_PRIVATE).edit();
        sharedPreferences.putBoolean(SharedKeys.FirstTime.toString(),status);
        sharedPreferences.apply();
    }

    public String getPoints() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_USER_POINTS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(SharedKeys.Points.toString(), "");
    }

}
