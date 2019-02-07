package com.tabasumgroupofcompanies.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<ListItem> mList;//N.B: the ArrayList here can also be List and
//    initialise as Arraylist later;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mList=new ArrayList<>();

        for (int i=0;i<10;i++){
            ListItem item=new ListItem("Title"+(i+1)
                    ,"Definition");
            mList.add(item);
        }
        mAdapter=new MyAdapter(this,mList);
        mRecyclerView.setAdapter(mAdapter);

    }
}
