package com.example.convertcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class OptionsActivity extends AppCompatActivity {

    private double coefficientTransform;
    private Button btnCancel, btnOk;
    private RadioGroup radioGroupFrom, radioGroupTo;
    private RadioButton radioButtonFrom, radioButtonTo;

    private List<String> listTypes = Arrays.asList("CNY", "EUR", "JPY", "KRW", "USD", "VND");
    private int indexFrom = 4, indexTo = 5;

    private double[][] mapExchangeRate = {
            {1.0,           0.13533273,     19.155123,  185.275,        0.14235674,     3453.4263},  // CNY
            {7.38980,       1.0,            141.55433,  1369.321,       1.0520535,      25522.263},  // EUR
            {0.0522066,     0.00706443,     1.0,        9.6743933,      0.0074315208,   180.52202},  // JPY
            {0.00539738,    0.000730289,    0.103318,   1.0,            0.00076823294,  18.651214},  // KRW
            {7.02461,       0.950522,       134.539,    0.00076823294,  1.0,            24301.7},    // USD
            {0.000289567,   0.0000391586,   0.00553949, 0.0535781,      0.000041160473, 1.0}         // VND
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioIdFrom = radioGroupFrom.getCheckedRadioButtonId();
                int radioIdTo = radioGroupTo.getCheckedRadioButtonId();

                radioButtonFrom = findViewById(radioIdFrom);
                radioButtonTo = findViewById(radioIdTo);

                for(int i = 0; i < listTypes.size(); i++) {
                    if(radioButtonFrom.getText().equals(listTypes.get(i))) {
                        indexFrom = i;
                    }
                    if(radioButtonTo.getText().equals(listTypes.get(i))) {
                        indexTo = i;
                    }
                }

                coefficientTransform = mapExchangeRate[indexFrom][indexTo];

                Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
                intent.putExtra("FROM", radioButtonFrom.getText());
                intent.putExtra("TO", radioButtonTo.getText());
                intent.putExtra("COEFFICIENT", coefficientTransform);
                startActivityForResult(intent, 123);
            }
        });
    }

    public void setCoefficient(View view){



    }

}