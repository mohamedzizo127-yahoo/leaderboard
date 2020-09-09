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
import com.example.gadsleaderboard.model.LearningLeader;
import com.example.gadsleaderboard.viewModels.LearningLeaderViewModel;

import java.util.List;
import java.util.Objects;

public class LearningLeaderFragment extends Fragment {
    private LearningLeaderViewModel mViewModel;
    private List<LearningLeader> mLearningLeaders;
    private LearningLeaderAdaper mLearningLeaderAdaper;
    private static final String TAG = "<<<LearningLeaderFra>>>";

    public static LearningLeaderFragment newInstance() {
        return new LearningLeaderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.learning_leader_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvLearningLeaderId);
        mLearningLeaderAdaper = new LearningLeaderAdaper(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mLearningLeaderAdaper);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LearningLeaderViewModel.class);
        mViewModel.getLearningLeaders();
        mViewModel.mLearningLeaders.observe(this, new Observer<List<LearningLeader>>() {
            @Override
            public void onChanged(List<LearningLeader> learningLeaders) {
                Log.d(TAG, "onActivityCreated: "+learningLeaders.size());
                mLearningLeaderAdaper.setLearningLeaders(learningLeaders);

            }
        });


     }

}