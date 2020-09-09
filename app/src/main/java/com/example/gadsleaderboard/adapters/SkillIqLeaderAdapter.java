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
import com.example.gadsleaderboard.model.SkillIqLeader;

import java.util.List;

public class SkillIqLeaderAdapter extends RecyclerView.Adapter<SkillIqLeaderAdapter.ViewHolder> {
    List<SkillIqLeader> mSkillIqLeaders;
    LayoutInflater mLayoutInflater;
    Context mContext;

    public SkillIqLeaderAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    public void setSkillIqLeaders(List<SkillIqLeader> skillIqLeaders) {
        mSkillIqLeaders = skillIqLeaders;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SkillIqLeaderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new SkillIqLeaderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqLeaderAdapter.ViewHolder holder, int position) {
        if (mSkillIqLeaders == null) return;
        SkillIqLeader currentLeader = mSkillIqLeaders.get(position);
        Glide.with(mContext).load(R.drawable.top_skill).into(holder.mImageView);
        holder.nameTv.setText(currentLeader.getName());
        int score = currentLeader.getScore();
        String country = currentLeader.getCountry();
        holder.informationTv.setText(mContext.getResources().getString(R.string.information_skill,
                score+"", country));

    }

    @Override
    public int getItemCount() {
        if (mSkillIqLeaders == null) return 0;
        else return mSkillIqLeaders.size();
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
