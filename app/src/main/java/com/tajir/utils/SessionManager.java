package com.tajir.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.tajir.model.User;

import java.util.HashMap;


public class SessionManager {

    private Listener listener;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USER = "ID";
    public static final String NIP = "NO KTP";
    public static final String EMAIL = "Email";
    public static final String NAME = "NAME";
    public static final String TOKEN_ACCSES = "Token";


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    public SessionManager(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mEditor = mSharedPreferences.edit();
    }

    public SessionManager(Context mContext, Listener listener) {
        this.mContext = mContext;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mEditor = mSharedPreferences.edit();
        if (listener != null) {
            this.listener = listener;
        }
    }

    public Context getContext() {
        return mContext;
    }

    public void createLoginSession(User user, String Token) {
        mEditor.putBoolean(IS_LOGGED_IN, true);
        mEditor.putString(ID_USER, String.valueOf(user.getId()));
        mEditor.putString(NIP, String.valueOf(user.getNip()));
        mEditor.putString(EMAIL, String.valueOf(user.getEmail()));
        mEditor.putString(NAME, String.valueOf(user.getName()));
        mEditor.putString(TOKEN_ACCSES, String.valueOf(Token));


        mEditor.commit();
    }


    public void updateLoginSession(User user) {
        mEditor.putBoolean(IS_LOGGED_IN, true);
        mEditor.putString(NIP, String.valueOf(user.getNip()));
        mEditor.putString(EMAIL, String.valueOf(user.getEmail()));
        mEditor.putString(NAME, String.valueOf(user.getName()));


        mEditor.commit();
    }

    public void updateUser(
            String str_NO_KTP,
            String str_EMAIL,
            String str_NAME) {

        mEditor.putString(NIP, str_NO_KTP);
        mEditor.putString(EMAIL, str_EMAIL);
        mEditor.putString(NAME, str_NAME);

        mEditor.commit();
    }


    public void logoutUser() {
        // Clearing all data from Shared Preferences
        mEditor.clear();
        mEditor.commit();
    }

    public boolean isLoggedIn() {
        return mSharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }


    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(NIP, mSharedPreferences.getString(NIP, null));
        //user.put(EMAIL, mSharedPreferences.getString(EMAIL, null));
        user.put(ID_USER, mSharedPreferences.getString(ID_USER, null));
        user.put(NAME, mSharedPreferences.getString(NAME, null));
        user.put(TOKEN_ACCSES, mSharedPreferences.getString(TOKEN_ACCSES, null));

        return user;
    }




    public interface Listener {
        void onSettingsUpdated();
    }
}
