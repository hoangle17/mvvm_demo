package com.example.mvvmdemo.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.AppExecutors;
import com.example.mvvmdemo.models.MovieModel;
import com.example.mvvmdemo.repositories.MovieRepository;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MovieApiClient {
    //change demo 2.1 pushed
    //Live data
    private MutableLiveData<List<MovieModel>> mMovies;
    private static MovieApiClient instance;
    private static String demo;
    private static String demo2;
    public static MovieApiClient getInstance() {
        if (instance == null) {
            instance = new MovieApiClient();
        }
        return instance;
    }

    public LiveData<List<MovieModel>> getMovies() {
        return mMovies;
    }

    private MovieApiClient() {
        mMovies = new MutableLiveData<>();
    }

    public void searchMoviesApi() {
        final Future myHandler = AppExecutors.getInstance().netWorkIO().submit(new Runnable() {
            @Override
            public void run() {
                //retrieve data from api
            }
        });

        AppExecutors.getInstance().netWorkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //cancelling the retrofit call
                myHandler.cancel(true);
            }
        }, 5000, TimeUnit.MICROSECONDS);
    }
}
