package com.example.gadsleaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.model.LearningLeader;

import java.util.List;

public class LearningLeaderAdaper extends RecyclerView.Adapter<LearningLeaderAdaper.ViewHolder> {
    List<LearningLeader> mLearningLeaders;
    LayoutInflater mLayoutInflater;
    Context mContext;

    public LearningLeaderAdaper(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    public void setLearningLeaders(List<LearningLeader> learningLeaders) {
        mLearningLeaders = learningLeaders;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mLearningLeaders == null) return;
        LearningLeader currentLeader = mLearningLeaders.get(position);
        Glide.with(mContext).load(R.drawable.top_learner).into(holder.mImageView);
        holder.nameTv.setText(currentLeader.getName());
        int hours = currentLeader.getHours();
        String country = currentLeader.getCountry();
        holder.informationTv.setText(mContext.getResources().getString(R.string.information_learning,
                hours+"", country));

    }

    @Override
    public int getItemCount() {
        if (mLearningLeaders == null) return 0;
        else return mLearningLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView nameTv, informationTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.ivListItemId);
            nameTv = itemView.findViewById(R.id.tvListItemNameId);
            informationTv = itemView.findViewById(R.id.tvListItemInformationId);
        }
    }
}
