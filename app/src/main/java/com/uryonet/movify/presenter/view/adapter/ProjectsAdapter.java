package com.uryonet.movify.presenter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uryonet.movify.R;
import com.uryonet.movify.model.entity.Project;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsHolder> {

    List<Project> projectList;
    Context context;

    public ProjectsAdapter(List<Project> projectList, Context context) {
        this.projectList = projectList;
        this.context = context;
    }

    @Override
    public ProjectsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_projects, parent, false);
        ProjectsHolder mh = new ProjectsHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ProjectsHolder holder, int position) {
        holder.tvFullname.setText(projectList.get(position).getFull_name());
        holder.tvDescription.setText(projectList.get(position).getDescription());
        holder.tvCloneUrl.setText(projectList.get(position).getClone_url());
        Glide.with(context).load(projectList.get(position).owner.getAvatar_url()).into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class ProjectsHolder extends RecyclerView.ViewHolder {

        TextView tvFullname,tvDescription,tvCloneUrl;
        ImageView ivAvatar;

        public ProjectsHolder(View v) {
            super(v);
            tvFullname = (TextView) v.findViewById(R.id.tvFullname);
            tvDescription = (TextView) v.findViewById(R.id.tvDescription);
            tvCloneUrl = (TextView) v.findViewById(R.id.tvCloneUrl);
            ivAvatar = (ImageView) v.findViewById(R.id.ivAvatar);
        }
    }
}
