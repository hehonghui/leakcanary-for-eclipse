package com.leakcanary.demo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanaryWrapper;
import com.squareup.leakcanary.RefWatcher;

public class BaseApplication extends Application {
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        mRefWatcher = LeakCanaryWrapper.install(this, debug());
    }

    protected boolean debug() {
        return BuildConfig.DEBUG;
    }

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }
}
