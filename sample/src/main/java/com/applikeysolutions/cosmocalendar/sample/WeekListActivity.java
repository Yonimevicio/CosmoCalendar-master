package com.applikeysolutions.cosmocalendar.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.applikeysolutions.cosmocalendar.sample.listAdapters.ListDayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class WeekListActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_view_layout);

            mRecyclerView = (RecyclerView) findViewById(R.id.taskList);
            mLinearLayout = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLinearLayout);
            mRecyclerView.setAdapter(new ListDayAdapter());

    }
}
