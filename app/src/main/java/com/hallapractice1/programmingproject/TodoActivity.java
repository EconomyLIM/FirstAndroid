package com.hallapractice1.programmingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hallapractice1.programmingproject.Adapter.ToDoAdpater;
import com.hallapractice1.programmingproject.Model.Todomodel;
import com.hallapractice1.programmingproject.Util.DataBaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoActivity extends AppCompatActivity implements OnDialogCloseListner{

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private DataBaseHelper myDB;
    private List<Todomodel> mlist;
    private ToDoAdpater adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.actionButton);
        myDB = new DataBaseHelper(TodoActivity.this);
        mlist = new ArrayList<>();
        adpater = new ToDoAdpater(myDB, TodoActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adpater);

        mlist = myDB.getAllTasks();
        Collections.reverse(mlist);
        adpater.setTasks(mlist);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerViewTouchHelper(adpater));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mlist = myDB.getAllTasks();
        Collections.reverse(mlist);
        adpater.setTasks(mlist);
        adpater.notifyDataSetChanged();
    }
}