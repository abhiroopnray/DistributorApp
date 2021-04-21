package com.abhiroop.desipopzsalesclient;

import android.app.Application;
import android.content.Context;

import com.abhiroop.desipopzsalesclient.repository.LocalRepository;

public class AppBaseApp  extends Application {

    public static Context appContext;
    public static boolean showConfirmation = false;
    private static boolean activityVisible;
    public static boolean isActivityVisible() {
        return activityVisible;
    }
    public static void activityResumed()
    {
        activityVisible = true;
    }
    public static void activityDestroy()
    {
        activityVisible = false;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        getLocalRepository();
    }

    private LocalRepository getLocalRepository() {
        return LocalRepository.getInstance(this);
    }
}
