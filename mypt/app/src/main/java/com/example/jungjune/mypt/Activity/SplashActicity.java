package com.example.jungjune.mypt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.jungjune.mypt.R;

/**
 * Created by triti on 2017-07-13.
 */

public class SplashActicity extends Activity {


    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActicity.this,LoginActivity.class);
                SplashActicity.this.startActivity(mainIntent);
                SplashActicity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
