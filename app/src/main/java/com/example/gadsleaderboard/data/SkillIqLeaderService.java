package com.example.gadsleaderboard.data;

import com.example.gadsleaderboard.model.SkillIqLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIqLeaderService {
    @GET("api/skilliq")
    Call<List<SkillIqLeader>> getSkillIqLeaders();
}
