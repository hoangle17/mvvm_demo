package com.example.mvvmdemo;

import com.example.mvvmdemo.request.MovieApiClient;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {
    //Pattern
    private static AppExecutors instance;

    public static AppExecutors getInstance() {
        if (instance == null) {
            instance = new AppExecutors();
        }
        return instance;
    }

    private final ScheduledExecutorService mNetWorkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService netWorkIO() {
        return mNetWorkIO;
    }

}
