package com.tajir.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.tajir.model.User;

import java.util.HashMap;


public class SessionManager {

    private Listener listener;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String NO_KTP = "NO KTP";
    public static final String EMAIL = "Email";
    public static final String ID_USER = "ID USER";
    public static final String NAME = "NAME";
    public static final String TTL = "TTL";
    public static final String JENIS_KELAMIN = "JENIS KELAMIN";
    public static final String JENIS_NASABAH = "JENIS NASABAH";
    public static final String STATUS = "STATUS";
    public static final String UPDATED_AT = "UPDATED AT";
    public static final String CREATED_AT = "CREATED AT";
    public static final String NO_HP = "NO_HP";
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
        mEditor.putString(NO_KTP, String.valueOf(user.getKtp()));
        //mEditor.putString(EMAIL, String.valueOf(user.getEmail()));
        mEditor.putString(ID_USER, String.valueOf(user.getId()));
        mEditor.putString(NAME, String.valueOf(user.getNamaPramudi()));
        mEditor.putString(TTL, String.valueOf(user.getTanggalLahir()));
        mEditor.putString(JENIS_KELAMIN, String.valueOf(user.getJenisKelamin()));
        mEditor.putString(STATUS, String.valueOf(user.getStatus()));
        mEditor.putString(UPDATED_AT, String.valueOf(user.getUpdatedAt()));
        mEditor.putString(CREATED_AT, String.valueOf(user.getCreatedAt()));
        mEditor.putString(NO_HP, String.valueOf(user.getNomorHp()));
        mEditor.putString(TOKEN_ACCSES, String.valueOf(Token));


        mEditor.commit();
    }


    public void updateLoginSession(User user) {
        mEditor.putBoolean(IS_LOGGED_IN, true);
        mEditor.putString(NO_KTP, String.valueOf(user.getKtp()));
        //mEditor.putString(EMAIL, String.valueOf(user.getEmail()));
        mEditor.putString(ID_USER, String.valueOf(user.getId()));
        mEditor.putString(NAME, String.valueOf(user.getNamaPramudi()));
        mEditor.putString(TTL, String.valueOf(user.getTanggalLahir()));
        mEditor.putString(JENIS_KELAMIN, String.valueOf(user.getJenisKelamin()));
        mEditor.putString(STATUS, String.valueOf(user.getStatus()));
        mEditor.putString(UPDATED_AT, String.valueOf(user.getUpdatedAt()));
        mEditor.putString(CREATED_AT, String.valueOf(user.getCreatedAt()));
        mEditor.putString(NO_HP, String.valueOf(user.getNomorHp()));


        mEditor.commit();
    }

    public void updateUser(
            String str_NO_KTP,
            //String str_EMAIL,
            String str_NAME,
            String str_TTL,
            String str_JENIS_KELAMIN,
            String str_STATUS,
            String str_UPDATED_AT,
            String str_NO_HP) {

        mEditor.putString(NO_KTP, str_NO_KTP);
        //mEditor.putString(EMAIL, str_EMAIL);
        mEditor.putString(NAME, str_NAME);
        mEditor.putString(TTL, str_TTL);
        mEditor.putString(JENIS_KELAMIN, str_JENIS_KELAMIN);
        mEditor.putString(STATUS, str_STATUS);
        mEditor.putString(UPDATED_AT, str_UPDATED_AT);
        mEditor.putString(NO_HP, str_NO_HP);


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
        user.put(NO_KTP, mSharedPreferences.getString(NO_KTP, null));
        //user.put(EMAIL, mSharedPreferences.getString(EMAIL, null));
        user.put(ID_USER, mSharedPreferences.getString(ID_USER, null));
        user.put(NAME, mSharedPreferences.getString(NAME, null));
        user.put(TTL, mSharedPreferences.getString(TTL, null));
        user.put(JENIS_KELAMIN, mSharedPreferences.getString(JENIS_KELAMIN, null));
        user.put(JENIS_NASABAH, mSharedPreferences.getString(JENIS_NASABAH, null));
        user.put(STATUS, mSharedPreferences.getString(STATUS, null));
        user.put(UPDATED_AT, mSharedPreferences.getString(UPDATED_AT, null));
        user.put(CREATED_AT, mSharedPreferences.getString(CREATED_AT, null));
        user.put(NO_HP, mSharedPreferences.getString(NO_HP, null));
        user.put(TOKEN_ACCSES, mSharedPreferences.getString(TOKEN_ACCSES, null));

        return user;
    }




    public String getNoKtp() {
        return mSharedPreferences.getString(NO_KTP, null);
    }

    public String getEmail() {
        return mSharedPreferences.getString(EMAIL, null);
    }

    public String getIdUser() {
        return mSharedPreferences.getString(ID_USER, null);
    }

    public String getName() {
        return mSharedPreferences.getString(NAME, null);
    }

    public String getTempatTanggalLahir() {
        return mSharedPreferences.getString(TTL, null);
    }

    public String getJenisKelamin() {
        return mSharedPreferences.getString(JENIS_KELAMIN, null);
    }

    public String getJenisNasabah() {
        return mSharedPreferences.getString(JENIS_NASABAH, null);
    }
    public String getStatus() { return mSharedPreferences.getString(STATUS, null);}

    public String getUpdatedAt() {
        return mSharedPreferences.getString(UPDATED_AT, null);
    }

    public String getCreatedAt() {
        return mSharedPreferences.getString(CREATED_AT, null);
    }

    public String getNoHp() {
        return mSharedPreferences.getString(NO_HP, null);
    }

    public String getTokenAccses() {
        return mSharedPreferences.getString(TOKEN_ACCSES, null);
    }



    public interface Listener {
        void onSettingsUpdated();
    }
}
