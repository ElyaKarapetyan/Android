package com.example.app.taskapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterForRecyclerView extends RecyclerView.Adapter<AdapterForRecyclerView.TaskHolder> {
    private List<TaskModel> mTasksList;
    private Context mContext;

    public AdapterForRecyclerView(List<TaskModel> tasksList, Context context) {
        this.mTasksList = tasksList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.task_model,parent,false);
        TaskHolder holder = new TaskHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        TaskModel task = mTasksList.get(position);

        holder.mTaskTitle.setText(task.getTitle());
        holder.mTaskDescription.setText(task.getTitle());
        Picasso.get().load(task.getImgUrl()).into(holder.mTaskImage);
        holder.mTaskDate.setText(task.getDate());
        holder.mTaskTime.setText(task.getTime());
    }

    @Override
    public int getItemCount() {
        return mTasksList.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mTaskTitle;
        private TextView mTaskDescription;
        private ImageView mTaskImage;
        private TextView mTaskDate;
        private TextView mTaskTime;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTaskTitle = itemView.findViewById(R.id.task_model_title);
            mTaskDescription = itemView.findViewById(R.id.task_model_description);
            mTaskImage = itemView.findViewById(R.id.task_model_img);
            mTaskDate = itemView.findViewById(R.id.task_model_date);
            mTaskTime = itemView.findViewById(R.id.task_model_time);
        }
    }
}
