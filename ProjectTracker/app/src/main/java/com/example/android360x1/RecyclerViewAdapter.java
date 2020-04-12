package com.example.android360x1;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<String> projects;

    public RecyclerViewAdapter(List<String> projects) {
        this.projects = projects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_project, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.project = projects.get(position);
        holder.projectID.setText(projects.get(position));
        holder.projectName.setText(projects.get(position));
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView projectID;
        public final TextView projectName;
        public String project;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            projectID = (TextView) view.findViewById(R.id.project_id);
            projectName = (TextView) view.findViewById(R.id.project_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + projectName.getText() + "'";
        }
    }
}
