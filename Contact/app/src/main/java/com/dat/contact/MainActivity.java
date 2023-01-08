package com.dat.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textName;
    private TextView textFirstChar;

    private List<User> users;

    String[] words = {"words", "starting", "with", "set", "Setback",
            "Setline", "Setoffs", "Setouts", "Setters", "Setting",
            "Settled", "Settler", "Wordless", "Wordiness", "Adios"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        users = new ArrayList<User>();

        for (int i = 0; i < words.length; i++) {
            users.add(new User(words[i], words[i].charAt(0)));
        }

        GridView gridView = findViewById(R.id.grid_view);
        UserAdapter userAdapter = new UserAdapter(this, R.layout.layout_entry_item, users);
        gridView.setAdapter(userAdapter);

    }
}
