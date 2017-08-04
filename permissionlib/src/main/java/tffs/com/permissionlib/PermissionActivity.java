package tffs.com.permissionlib;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import tffs.com.permissionlib.callback.PermissionCallBack;
import tffs.com.permissionlib.constant.PermissionConstant;

/**
 * @作者 RedWolf
 * @时间 2017/8/4 0004 11:10
 * @简介 PermissionActivity.java
 */


public class PermissionActivity extends AppCompatActivity {
    //  回调
    private PermissionCallBack mCallBack;

    /**
     * 获取权限数组(也是单个)
     *
     * @param permissionCode
     * @return
     */
    private String[] getPermissionArray(int permissionCode) {
        return PermissionConstant.PERMISSION_ARRAY[permissionCode];
    }

    /**
     * 获取权限名
     *
     * @param permissionCode
     * @return
     */
    private String getPermission(int permissionCode) {
        return PermissionConstant.PERMISSIONS[permissionCode];
    }

    /**
     * 单权限申请
     *
     * @param mCallBack
     * @param permissionCode
     */
    protected void applyPermission(@NonNull PermissionCallBack mCallBack, int permissionCode) {
        this.mCallBack = mCallBack;
        //  检查制定权限是否同意状态  如果不是 则申请
        if (ContextCompat.checkSelfPermission(this, getPermission(permissionCode)) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, getPermissionArray(permissionCode), permissionCode);
        } else {
            mCallBack.onNoNeedPermissionApply();
        }
    }

    // 申请权限组
    protected void applyPermissionArray(@NonNull PermissionCallBack mCallBack, String[] permissionList) {
        this.mCallBack = mCallBack;
        if (permissionList.length <= 0) {
            mCallBack.onNoNeedPermissionApply();
            return;
        }
        String[] resultPermissions = new String[permissionList.length];
        //  取出权限中未同意的权限 并且传入数组 进行申请
        for (int index = 0; index < permissionList.length; index++) {
            if (ContextCompat.checkSelfPermission(this, permissionList[index]) != PackageManager.PERMISSION_GRANTED) {
                resultPermissions[index] = permissionList[index];
            }
        }
        if (resultPermissions.length > 0) {
            ActivityCompat.requestPermissions(this, resultPermissions, PermissionConstant.PERMISSION_CODE_GROUP);
        } else {
            mCallBack.onNoNeedPermissionApply();
        }
    }

    /**
     * 申请权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionConstant.PERMISSION_CODE_CALENDAR:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onCalendarPermissionSuccess();
                } else {
                    mCallBack.onCalendarPermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_CAMERA:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onCameraPermissionSuccess();
                } else {
                    mCallBack.onCameraPermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_CONTACTS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onContactsPermissionSuccess();
                } else {
                    mCallBack.onContactsPermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onLocationPermissionSuccess();
                } else {
                    mCallBack.onLocationPermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_MICROPHONE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onMicrophonePermissionSuccess();
                } else {
                    mCallBack.onMicrophonePermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_PHONE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onPhonePermissionSuccess();
                } else {
                    mCallBack.onPhonePermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_SENSORS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onSensorsPermissionSuccess();
                } else {
                    mCallBack.onSensorsPermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_SMS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onSMSPermissionSuccess();
                } else {
                    mCallBack.onSMSPermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mCallBack.onStoragePermissionSuccess();
                } else {
                    mCallBack.onStoragePermissionFailure();
                }
                break;
            case PermissionConstant.PERMISSION_CODE_GROUP:
                if (grantResults.length >= 0) {
                    for (int index = 0; index < grantResults.length; index++) {
                        //  表示此权限被通过
                        if (grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                            mCallBack.onGroupPermissionSuccess(permissions[index]);
                        } else {
                            mCallBack.onGroupPermissionFailure(permissions[index]);
                        }
                    }
                } else {
                    mCallBack.onNoNeedPermissionApply();
                }
                break;
        }
    }
}
