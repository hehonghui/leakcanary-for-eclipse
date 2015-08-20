package com.squareup.leakcanary;

import android.annotation.TargetApi;
import android.app.Application;

import com.squareup.leakcanary.DisplayLeakService;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * LeakCanary wrapper deal with compatible
 * 
 * @author zhangcong
 * 
 */
public class LeakCanaryWrapper {

    @TargetApi(value = android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static RefWatcher install(Application application, boolean debug) {
        RefWatcher watcher = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            if (debug) {
                watcher = LeakCanary.install(application, DisplayLeakService.class);
            } else {
                watcher = ReleaseLeakCanary.install(application);
            }
        }

        return watcher;
    }
}

/**
 * A no-op version of {@link LeakCanary} that can be used in release builds
 * 
 * @author zhangcong
 * 
 */
class ReleaseLeakCanary {

    public static RefWatcher install(Application application) {
        return RefWatcher.DISABLED;
    }

    private ReleaseLeakCanary() {
        throw new AssertionError();
    }
}
