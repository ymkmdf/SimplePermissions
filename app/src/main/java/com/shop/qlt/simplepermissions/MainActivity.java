package com.shop.qlt.simplepermissions;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.shop.qlt.mypermissions.MPermission;
import com.shop.qlt.mypermissions.annotation.OnMPermissionDenied;
import com.shop.qlt.mypermissions.annotation.OnMPermissionGranted;
import com.shop.qlt.mypermissions.annotation.OnMPermissionNeverAskAgain;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();
    }

    private void requestPermissions(){
        MPermission.with(this)
                .addRequestCode(23231)
                .permissions(Manifest.permission.CAMERA)
                .request();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermission.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }

    @OnMPermissionDenied(23231)
    public void onMpermission(){
        Toast.makeText(this,"拒绝了",Toast.LENGTH_SHORT).show();
    }

    @OnMPermissionGranted(23231)
    public void onMPermissionGranted(){
        Toast.makeText(this,"成功了",Toast.LENGTH_SHORT).show();
    }

    @OnMPermissionNeverAskAgain(23231)
    public void onMPermissionNeverAskAgain(){
        Toast.makeText(this,"勾选拒绝了",Toast.LENGTH_SHORT).show();
    }
}
