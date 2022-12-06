package com.example.convertcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView fromText, toText;
    private EditText fromEdit, toEdit;
    private double coefficientTransform = 24301.7;
    private Button btnOps, btnClear, btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromText = findViewById(R.id.fromText);
        toText = findViewById(R.id.toText);

        fromEdit = findViewById(R.id.fromEdit);
        toEdit = findViewById(R.id.toEdit);

        btnClear = findViewById(R.id.btnClear);
        btnConvert = findViewById(R.id.btnConvert);
        btnOps = findViewById(R.id.btnOptions);

        Intent intent = getIntent();
        String fText = intent.getStringExtra("FROM");
        String tText = intent.getStringExtra("TO");
        coefficientTransform = intent.getDoubleExtra("COEFFICIENT", 0.0);
        fromText.setText("FROM" + fText);
        toText.setText("TO" + tText);

        btnOps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(intent1);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromEdit.setText("");
                toEdit.setText("");
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double fromValue = Double.parseDouble(fromEdit.toString());
                double result = fromValue * coefficientTransform;

                toEdit.setText(String.valueOf(result));
            }
        });
    }
}