package com.example.gadsleaderboard.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapters.LearningLeaderAdaper;
import com.example.gadsleaderboard.adapters.SkillIqLeaderAdapter;
import com.example.gadsleaderboard.model.SkillIqLeader;
import com.example.gadsleaderboard.viewModels.SkillIqLeaderViewModel;

import java.util.List;

public class SkillIqLeaderFragment extends Fragment {

    private SkillIqLeaderViewModel mViewModel;
    private static final String TAG = "<<<SkillIqLeaderFrag>>>";
 
    public static SkillIqLeaderFragment newInstance() {
        return new SkillIqLeaderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.skill_iq_leader_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.rvSkillIqLeaderId);
        final SkillIqLeaderAdapter skillIqLeaderAdapter = new SkillIqLeaderAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(skillIqLeaderAdapter);
        mViewModel = ViewModelProviders.of(this).get(SkillIqLeaderViewModel.class);
        mViewModel.getSkillIqLeaders();
        mViewModel.mSkillIqLeader.observe(this, new Observer<List<SkillIqLeader>>() {
            @Override
            public void onChanged(List<SkillIqLeader> skillIqLeaders) {
                Log.d(TAG, "onActivityCreated: "+ skillIqLeaders.size());
                skillIqLeaderAdapter.setSkillIqLeaders(skillIqLeaders);

            }
        });

    }

}