# RedPermission
Android 6.0 权限 Permission
**用法 : **

 1. **需要继承PermissionActivity类**
 2. **单个请求用applyPermission()**
 3. **多个请求用applyPermissionArray()**


**具体看代码 : **

**1.单个请求(以相机权限为例)**

```
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
```
**2.一组权限申请**

```
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
```
**使用方式 : 暂时只能将代码Copy进项目中,JikPack暂时上传失败**

**代码地址 : https://github.com/RedWolfChao/RedPermission**

**注意事项 : **

**PermissionCallback是一个静态类,所以要重写其中方法的时候不需要全部重写,坏处也是重写方法的时候需要自己选择要重写的方法,选择方式为 :**

 - **单个权限 : 重写onNoNeedPermissionApply 以及onXXXSuccess和onXXXFailure**
 - **一组权限 : 重写onNoNeedPermissionApply 以及onGroupPermissionSuccess和onGroupPermissionSuccess**

**其它**

**Android一共有9组24个危险权限需要申请,每组中用户同意一个,其它的也跟带着会被同意**
**联系人权限**

  android.permission.WRITE_CONTACTS
  android.permission.GET_ACCOUNTS
  android.permission.READ_CONTACTS

**电话权限**

  android.permission.READ_CALL_LOG
  android.permission.READ_PHONE_STATE
  android.permission.CALL_PHONE
  android.permission.WRITE_CALL_LOG
  android.permission.USE_SIP
  android.permission.PROCESS_OUTGOING_CALLS
  com.android.voicemail.permission.ADD_VOICEMAIL

**日历权限**

  android.permission.READ_CALENDAR
  android.permission.WRITE_CALENDAR

**相机权限**

  android.permission.CAMERA

**传感器权限**

  android.permission.BODY_SENSORS

**定位权限**

  android.permission.ACCESS_FINE_LOCATION
  android.permission.ACCESS_COARSE_LOCATION

**储存器权限**

  android.permission.READ_EXTERNAL_STORAGE
  android.permission.WRITE_EXTERNAL_STORAGE

**麦克风权限**

  android.permission.RECORD_AUDIO

**短信权限**

  android.permission.READ_SMS
  android.permission.RECEIVE_WAP_PUSH
  android.permission.RECEIVE_MMS
  android.permission.RECEIVE_SMS
  android.permission.SEND_SMS

**具体可看官方文档**
> https://developer.android.com/reference/android/Manifest.permission_group.html

