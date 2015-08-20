
package com.leakcanary.demo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanaryWrapper;
import com.squareup.leakcanary.RefWatcher;

public class MyApplication extends Application {
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        mRefWatcher = LeakCanaryWrapper.install(this, BuildConfig.DEBUG);
    }

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }
}
