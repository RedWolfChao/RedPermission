package tffs.com.permissionlib.constant;

import android.Manifest;

/**
 * @作者 RedWolf
 * @时间 2017/8/4 0004 11:17
 * @简介 PermissionConstant.java
 */


public class PermissionConstant {
    //  日历
    public static final int PERMISSION_CODE_CALENDAR = 0;
    //  相机
    public static final int PERMISSION_CODE_CAMERA = 1;
    //  联系人
    public static final int PERMISSION_CODE_CONTACTS = 2;
    //  定位
    public static final int PERMISSION_CODE_LOCATION = 3;
    //  麦克风
    public static final int PERMISSION_CODE_MICROPHONE = 4;
    //  电话
    public static final int PERMISSION_CODE_PHONE = 5;
    //  传感器
    public static final int PERMISSION_CODE_SENSORS = 6;
    //  短信
    public static final int PERMISSION_CODE_SMS = 7;
    //  储存器
    public static final int PERMISSION_CODE_STORAGE = 8;
    //  组Code
    public static final int PERMISSION_CODE_GROUP = 10000;


    /**
     * 单权限申请 权限申请时用
     */
    public static final String[][] PERMISSION_ARRAY = {
            //  日历 READ_CALENDAR
            {Manifest.permission.READ_CALENDAR},
            //  相机 CAMERA
            {Manifest.permission.CAMERA},
            //  联系人 READ_CONTACTS
            {Manifest.permission.READ_CONTACTS},
            //  定位 ACCESS_FINE_LOCATION
            {Manifest.permission.ACCESS_FINE_LOCATION},
            //  麦克风 RECORD_AUDIO
            {Manifest.permission.RECORD_AUDIO},
            //  电话 CALL_PHONE
            {Manifest.permission.CALL_PHONE},
            //  传感器 BODY_SENSORS
            {Manifest.permission.BODY_SENSORS},
            //  短信 READ_SMS
            {Manifest.permission.READ_SMS},
            //  储存器 READ_EXTERNAL_STORAGE
            {Manifest.permission.READ_EXTERNAL_STORAGE}
    };

    /**
     * 单权限申请权限检查时用
     */
    public static final String[] PERMISSIONS = {
            //  日历 Calendar
            Manifest.permission.READ_CALENDAR,
            //  相机 Camera
            Manifest.permission.CAMERA,
            //  联系人
            Manifest.permission.READ_CONTACTS,
            //  定位 ACCESS_FINE_LOCATION
            Manifest.permission.ACCESS_FINE_LOCATION,
            //  麦克风 RECORD_AUDIO
            Manifest.permission.RECORD_AUDIO,
            //  电话 CALL_PHONE
            Manifest.permission.CALL_PHONE,
            //  传感器 BODY_SENSORS
            Manifest.permission.BODY_SENSORS,
            //  短信 READ_SMS
            Manifest.permission.READ_SMS,
            //  储存器 READ_EXTERNAL_STORAGE
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
}
