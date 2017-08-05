package tffs.com.redpermission;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import tffs.com.permissionlib.PermissionActivity;
import tffs.com.permissionlib.callback.PermissionCallBack;
import tffs.com.permissionlib.constant.PermissionConstant;


public class MainActivity extends PermissionActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getPermission(View v) {
        /**
         *   组权限申请
         *   @param callback为回调,检测是否某权限被用户同意或者是否被拒绝以及是否需要授权
         *   @param String[] permissions 为要申请权限
         */
        applyPermissionArray(new PermissionCallBack() {
            @Override
            public void onGroupPermissionSuccess(String permissionName) {
                Log.i(TAG, "onGroupPermissionSuccess: " + permissionName);
            }

            @Override
            public void onGroupPermissionFailure(String permissionName) {
                Log.i(TAG, "onGroupPermissionFailure: " + permissionName);
            }

            @Override
            public void onNoNeedPermissionApply() {
                Log.i(TAG, "onNoNeedPermissionApply: ");
            }
        }, new String[]{Manifest.permission.READ_CALENDAR,
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_CONTACTS});
        /**
         *   单权限申请
         *   @param callback为回调,检测是否被用户同意或者是否被拒绝以及是否需要授权
         *   @param int permissionCode 为要申请权限代码 在PermissionConstant中有声明
         */
        applyPermission(new PermissionCallBack() {
            @Override
            public void onCameraPermissionSuccess() {
                Log.i(TAG, "onCameraPermissionSuccess: ");

            }

            @Override
            public void onCameraPermissionFailure() {
                Log.i(TAG, "onCameraPermissionFailure: ");

            }

            @Override
            public void onNoNeedPermissionApply() {
                Log.i(TAG, "onNoNeedPermissionApply: ");
            }
        }, PermissionConstant.PERMISSION_CODE_CAMERA);
    }
}
