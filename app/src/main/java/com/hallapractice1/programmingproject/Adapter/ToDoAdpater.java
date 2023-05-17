package com.hallapractice1.programmingproject.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hallapractice1.programmingproject.AddNewTask;
import com.hallapractice1.programmingproject.Model.Todomodel;
import com.hallapractice1.programmingproject.R;
import com.hallapractice1.programmingproject.TodoActivity;
import com.hallapractice1.programmingproject.Util.DataBaseHelper;

import java.util.List;

public class ToDoAdpater extends RecyclerView.Adapter<ToDoAdpater.MyViewHolder> {

    private List<Todomodel> mlist;
    private TodoActivity todoActivity;
    private DataBaseHelper myDB;

    public ToDoAdpater(DataBaseHelper myDB, TodoActivity activity){
        this.todoActivity = activity;
        this.myDB = myDB;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Todomodel item = mlist.get(position);
        holder.checkBox.setText(item.getTask());
        holder.checkBox.setChecked(toBoolean(item.getStatus()));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    myDB.updateStatus(item.getId(), 1);
                }else{
                    myDB.updateStatus(item.getId(), 0);
                }
            }
        });

    }

    public boolean toBoolean(int num){
        return num != 0;
    }

    public Context getContext(){
        return todoActivity;
    }

    public void setTasks(List<Todomodel> mlist){
        this.mlist = mlist;
        notifyDataSetChanged();
    }

    public void deleteTask(int position){
        Todomodel item = mlist.get(position);
        myDB.deleteTask(item.getId());
        mlist.remove(position);
        notifyItemRemoved(position);
    }

    public void editItem(int position){
        Todomodel item = mlist.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("task", item.getTask());

        AddNewTask task = new AddNewTask();
        task.setArguments(bundle);
        task.show(todoActivity.getSupportFragmentManager(), task.getTag());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }
}
