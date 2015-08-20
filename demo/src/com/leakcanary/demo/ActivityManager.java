package com.leakcanary.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityManager {
    private List<Activity> mActivities = new ArrayList<>();
    private static ActivityManager sInstance;

    private ActivityManager() {
    }

    public static ActivityManager instance() {
        if (sInstance == null) {
            sInstance = new ActivityManager();
        }
        return sInstance;
    }

    public void registActivity(Activity activity) {
        mActivities.add(activity);
    }

    public void unRigistActivity(Activity activity) {
        mActivities.remove(activity);
    }
}
