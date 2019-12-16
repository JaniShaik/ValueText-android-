package com.itcrats.valuetext.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JANI SHAIK on 14/11/2019
 */

public class SessionManager {

    // Shared Preferences
    private SharedPreferences pref;

    // Editor for Shared preferences
    private SharedPreferences.Editor editor;

    // Context
    private Context mContext;

    // Shared pref mode
    private int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "VALUETEXT";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String USER_NAME = "UserName";
    private static final String USER_ID = "userId";


    // Constructor
    public SessionManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     */
    public void createLoginSession() {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // commit changes
        editor.apply();
    }

    public Boolean isUserLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    /**
     * Clear session (LogOut)
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.putBoolean(IS_LOGIN, false);
        editor.clear();
        editor.apply();
    }

    /**
     * UserName
     */
    public void setUserName(String userName) {
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    public String getUserName() {
        return pref.getString(USER_NAME, "");
    }

    /**
     * UserId
     */
    public void setUserId(String userId) {
        editor.putString(USER_ID, userId);
        editor.apply();
    }

    public String getUserId() {
        return pref.getString(USER_ID, "");
    }

}
