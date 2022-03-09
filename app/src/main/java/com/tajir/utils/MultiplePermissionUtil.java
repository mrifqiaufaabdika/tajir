package com.tajir.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MultiplePermissionUtil {

    public static final int PERMISSION_REQUEST_CODE = 1240;


    Context mContext;
    Activity mActivity;
    String[] mAppPermissions;

    public MultiplePermissionUtil(Context mContext, Activity mActivity, String[] mAppPermissions) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mAppPermissions = mAppPermissions;
    }

    public boolean checkAllPermissions() {

        //check All permissions are granted
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String perm : mAppPermissions) {
            if (ContextCompat.checkSelfPermission(mContext, perm) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(perm);
            }
        }

        //ask for non-granted permissions
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(mActivity, listPermissionsNeeded
                    .toArray(new String[listPermissionsNeeded.size()]), PERMISSION_REQUEST_CODE);
            return false;
        }

        return true;
    }

}
