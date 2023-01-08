package com.dat.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Email> emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails = new ArrayList<>();

        for( int i = 0 ;i < 10; i++) {
            emails.add(new Email("Dat", "Content", "12:04 PM", true));
        }

        GridView gridView = findViewById(R.id.grid_view);
        EmailAdapter emailAdapter = new EmailAdapter(this, R.layout.layout_entry_email, emails);
        gridView.setAdapter(emailAdapter);

    }
}