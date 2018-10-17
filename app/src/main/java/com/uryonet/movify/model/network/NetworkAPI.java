package com.uryonet.movify.model.network;

import android.database.Observable;

import com.uryonet.movify.model.entity.MovieResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkAPI {

    @GET("discover/movie")
    Observable<MovieResponse> getMovies(@Query("api_key") String api_key);
}
