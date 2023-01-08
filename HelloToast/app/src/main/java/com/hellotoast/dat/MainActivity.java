package com.hellotoast.dat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private int mCount = 0;
    private TextView mShowCount;
    public static final String EXTRA_MESSAGE = "com.hellotoast.dat.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
//        Toast toast = Toast.makeText(this, R.string.button_label_toast, Toast.LENGTH_LONG);
        Toast toast = Toast.makeText(this, "Hello how are you!", Toast.LENGTH_LONG);
        toast.show();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mCount);
        startActivity(intent);
//        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}