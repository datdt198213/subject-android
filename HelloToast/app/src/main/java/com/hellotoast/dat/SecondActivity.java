package com.hellotoast.dat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textHeader;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textHeader = findViewById(R.id.text_hello);
        textResult = findViewById(R.id.text_result);
        Intent intent = getIntent();
        int result = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        textResult.setText(String.valueOf(result));
    }


}