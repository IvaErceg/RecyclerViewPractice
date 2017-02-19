package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NameAdapter.OnItemClickListener {
    RecyclerView mRecyclerView;
    NameAdapter mAdapter;
    ArrayList<String> names;
    Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = new ArrayList<>();
        names.add("Sally");
        names.add("Joe");
        names.add("Ann");
        names.add("Mary");
        names.add("Peter");
        names.add("Lucy");
        names.add("Jerry");
        names.add("Suzy");
        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rw_names);
        mAdapter = new NameAdapter(names, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setHasFixedSize(true);
    }


    @Override
    public void onItemClick(int position) {
        mToast = Toast.makeText(MainActivity.this, "I'm on position " + position, Toast.LENGTH_SHORT);
        mToast.show();

    }
}
