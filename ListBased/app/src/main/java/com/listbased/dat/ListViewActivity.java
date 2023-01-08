package com.listbased.dat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    List<String> items;

    String[] words = { "words", "starting", "with", "set", "Setback",
            "Setline", "Setoffs", "Setouts", "Setters", "Setting",
            "Settled", "Settler", "Wordless", "Wordiness", "Adios" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        items = new ArrayList<>();
        for(int i = 0 ; i < 50; i++) {
            items.add("Item " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        android.widget.ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("TAG", items.get(i) + " is clicked.");
            }
        });

        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(0, "New item");
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.set(0, "Update Item");
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(0);
                adapter.notifyDataSetChanged();
            }
        });


    }
}