package com.example.gadsleaderboard.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.data.LearningLeaderService;
import com.example.gadsleaderboard.data.ServiceBuilder;
import com.example.gadsleaderboard.model.LearningLeader;
import com.example.gadsleaderboard.model.SkillIqLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeaderViewModel extends ViewModel {
     public MutableLiveData<List<LearningLeader>> mLearningLeaders = new MutableLiveData<>();

    public void getLearningLeaders() {
        LearningLeaderService service = ServiceBuilder.buildService(LearningLeaderService.class);
        Call<List<LearningLeader>> learningLeaders = service.getLearningLeaders();
        learningLeaders.enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                mLearningLeaders.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {


            }
        });


     }
}