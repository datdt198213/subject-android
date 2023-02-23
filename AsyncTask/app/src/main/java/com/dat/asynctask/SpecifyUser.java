package com.dat.asynctask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class SpecifyUser extends AppCompatActivity {
    TextView textName, textUserName, textEmail, textAddress, textPhone;
    ImageView avatar;
    String url, name, userName, email, city, phone, street;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specify_user);
        textName = findViewById(R.id.nameBox);
        textAddress = findViewById(R.id.addressBox);
        textUserName = findViewById(R.id.userNameBox);
        textEmail = findViewById(R.id.emailBox);
        textPhone = findViewById(R.id.phoneBox);
        avatar = findViewById(R.id.image);
        setValue();
        String link = "https://lebavui.github.io"+url;
        Glide.with(SpecifyUser.this).load(link).into(avatar);
        textName.setText(name);
        textUserName.setText(userName);
        textEmail.setText(email);
        textPhone.setText(phone);
        textAddress.setText(street + ", " + city);
    }

    public void setValue(){
        Intent intent=getIntent();
        name=intent.getStringExtra("Name");
        email=intent.getStringExtra("Email");
        phone=intent.getStringExtra("Tel");
        userName=intent.getStringExtra("UserName");
        city= intent.getStringExtra("City");
        street=intent.getStringExtra("Street");
        url=intent.getStringExtra("Url");
    }
}
