package com.uryonet.movify.model.network;

import android.database.Observable;

import com.uryonet.movify.model.entity.Project;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkAPI {

    @GET("users/{user}/repos")
    Observable<List<Project>> getProjects(@Path("user") String user);
}
