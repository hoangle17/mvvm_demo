package com.example.mvvmdemo.utils;

import com.example.mvvmdemo.models.MovieModel;
import com.example.mvvmdemo.reponse.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );

    //https://api.themoviedb.org/3/movie/550?api_key=d594ceb5a8514f8664f5d88d63855da7
    @GET("3/movie/{movie_id}")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );
}
