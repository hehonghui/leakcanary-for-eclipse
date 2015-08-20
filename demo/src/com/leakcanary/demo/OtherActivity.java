package com.leakcanary.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OtherActivity extends Activity {
    public static final String TAG = OtherActivity.class.getSimpleName();

    private Object[] mObjs = new Object[10000];//快速消耗内存
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < mObjs.length; i++) {
                    mObjs[i] = new Object();
                }
                
                finish();
            }
        });

        ActivityManager.instance().registActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
