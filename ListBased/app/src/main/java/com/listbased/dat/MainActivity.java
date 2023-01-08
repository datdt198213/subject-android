package com.listbased.dat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void openHorizontalActivity(View view) {
        Intent intent = new Intent(this, HorizontalListActivity.class);
        startActivity(intent);
    }

    public void openListView(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    public void openGridView(View view) {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }
}