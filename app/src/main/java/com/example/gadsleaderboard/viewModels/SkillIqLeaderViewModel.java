package com.example.gadsleaderboard.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.data.ServiceBuilder;
import com.example.gadsleaderboard.data.SkillIqLeaderService;
import com.example.gadsleaderboard.model.LearningLeader;
import com.example.gadsleaderboard.model.SkillIqLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIqLeaderViewModel extends ViewModel {
   public MutableLiveData<List<SkillIqLeader>> mSkillIqLeader = new MutableLiveData<>();

    public void getSkillIqLeaders() {
        SkillIqLeaderService service = ServiceBuilder.buildService(SkillIqLeaderService.class);
        Call<List<SkillIqLeader>> skillIqLeaders = service.getSkillIqLeaders();
         skillIqLeaders.enqueue(new Callback<List<SkillIqLeader>>() {
             @Override
             public void onResponse(Call<List<SkillIqLeader>> call, Response<List<SkillIqLeader>> response) {
                 mSkillIqLeader.setValue(response.body());
             }
             @Override
             public void onFailure(Call<List<SkillIqLeader>> call, Throwable t) {

             }
         });
    }
}