package com.listbased.dat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        items = new ArrayList<>();
        for(int i = 0 ; i < 50; i++) {
            items.add("Item " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.layout_simple_item, R.id.text_view, items);

        GridView gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("TAG", items.get(i) + " is clicked.");
            }

        });
    }
}