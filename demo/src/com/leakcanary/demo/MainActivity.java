package com.leakcanary.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });
        
        ActivityManager.instance().registActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        
        ActivityManager.instance().unRigistActivity(this);
    }
}
