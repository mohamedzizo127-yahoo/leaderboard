package com.example.gadsleaderboard.data;

import com.example.gadsleaderboard.model.LearningLeader;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeaderService {
    @GET("api/hours")
    Call<List<LearningLeader>> getLearningLeaders();
}
