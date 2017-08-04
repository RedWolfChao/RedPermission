package tffs.com.redpermission;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import tffs.com.permissionlib.PermissionActivity;
import tffs.com.permissionlib.callback.PermissionCallBack;


public class MainActivity extends PermissionActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getPermission(View v) {
        //  单权限申请
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
        //  组权限申请
//        applyPermission(new PermissionCallBack() {
//            @Override
//            public void onCameraPermissionSuccess() {
//                Log.i(TAG, "onCameraPermissionSuccess: ");
//
//            }
//
//            @Override
//            public void onCameraPermissionFailure() {
//                Log.i(TAG, "onCameraPermissionFailure: ");
//
//            }
//
//            @Override
//            public void onNoNeedPermissionApply() {
//                Log.i(TAG, "onNoNeedPermissionApply: ");
//            }
//        }, PermissionConstant.PERMISSION_CODE_CAMERA);
    }
}
