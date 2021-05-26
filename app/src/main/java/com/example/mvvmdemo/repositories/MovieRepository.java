package com.example.mvvmdemo.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.models.MovieModel;
import com.example.mvvmdemo.request.MovieApiClient;
import com.example.mvvmdemo.utils.MovieApi;

import java.util.List;

public class MovieRepository {
    //acting as repositories: hoat dong nhu 1 kho luu tru
    public static MovieRepository instance;
    public static MovieApiClient movieApiClient;

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository() {
        movieApiClient = MovieApiClient.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies() {
        return movieApiClient.getMovies();
    }
}
