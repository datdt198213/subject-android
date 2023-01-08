package com.listbased.GridView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    GridView gridView;
    TextView txtSoloMsg;
    ImageView imgSoloPhoto;
    Button btnSoloBack;

    Bundle myOriginalMemoryBundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myOriginalMemoryBundle = savedInstanceState;

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new MyImageAdapter(this, ));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}