package com.example.jungjune.mypt.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by triti on 2017-07-13.
 */

public class SplashActicity extends Activity {

    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1000;
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        int internetPermissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int storagePermissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);


        if (internetPermissionCheck == PackageManager.PERMISSION_DENIED || storagePermissionCheck == PackageManager.PERMISSION_DENIED) {
            if (internetPermissionCheck == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
            if (storagePermissionCheck == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(SplashActicity.this, LoginActivity.class);
                    SplashActicity.this.startActivity(mainIntent);
                    SplashActicity.this.finish();
                }
            }, SPLASH_DISPLAY_LENGTH);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent mainIntent = new Intent(SplashActicity.this, LoginActivity.class);
                            SplashActicity.this.startActivity(mainIntent);
                            SplashActicity.this.finish();
                        }
                    }, SPLASH_DISPLAY_LENGTH);
                } else {
                    exitDialog();
                }
                return;
        }
    }

    private void exitDialog() {
        new AlertDialog.Builder(getApplicationContext())
                .setTitle("권한 미설정") // 제목부분 텍스트
                .setMessage("권한이 설정되지 않아 종료됩니다.") // 내용부분 텍스트
                .setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //프로그램 종료
                                android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        }
                );

    }


}
