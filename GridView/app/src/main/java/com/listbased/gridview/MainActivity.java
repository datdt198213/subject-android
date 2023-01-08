package com.listbased.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private TextView txtSoloMsg;
    private ImageView imgSoloPhoto;
    private Button btnSoloBack;
    private Bundle myOriginalMemoryBundle;
    private List<ImageModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myOriginalMemoryBundle = savedInstanceState;

        items = new ArrayList<>();
        for(int i = 1; i <= 28; i++) {
            items.add(new ImageModel("Item " + i,
                    getResources().getIdentifier("thumb" + i, "drawable", getPackageName()),
                    getResources().getIdentifier("thumb" + i, "drawable", getPackageName()))
            );
        }

        gridView = (GridView) findViewById(R.id.gridview);

    }
}