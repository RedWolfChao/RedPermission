package tffs.com.permissionlib.callback;

/**
 * @作者 RedWolf
 * @时间 2017/8/4 0004 11:14
 * @简介 PermissionCallBack.java
 */


public abstract class PermissionCallBack {
    //  获取日历权限回调
    public void onCalendarPermissionSuccess() {
    }

    public void onCalendarPermissionFailure() {
    }

    //  获取相机权限回调
    public void onCameraPermissionSuccess() {
    }

    public void onCameraPermissionFailure() {
    }

    //  获取联系人权限回调
    public void onContactsPermissionSuccess() {
    }

    public void onContactsPermissionFailure() {
    }

    //  获取定位权限回调
    public void onLocationPermissionSuccess() {
    }

    public void onLocationPermissionFailure() {
    }

    //  获取麦克风权限回调
    public void onMicrophonePermissionSuccess() {
    }

    public void onMicrophonePermissionFailure() {
    }

    //  获取电话权限回调
    public void onPhonePermissionSuccess() {
    }

    public void onPhonePermissionFailure() {
    }

    //  获取传感器权限回调
    public void onSensorsPermissionSuccess() {
    }

    public void onSensorsPermissionFailure() {
    }

    //  获取短信权限回调
    public void onSMSPermissionSuccess() {
    }

    public void onSMSPermissionFailure() {
    }

    //  获取储存器权限回调
    public void onStoragePermissionSuccess() {
    }

    public void onStoragePermissionFailure() {
    }


    //  组回调
    public void onGroupPermissionSuccess(String permissionName) {
    }

    public void onGroupPermissionFailure(String permissionName) {
    }

    //  权限不需要授予
    public void onNoNeedPermissionApply() {
    }
}
