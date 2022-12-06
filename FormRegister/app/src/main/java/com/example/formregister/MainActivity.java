package com.example.formregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister, btnSelect;
    private RadioGroup radioGroup;
    private RadioButton rdbMale, rdbFemale;
    private EditText firstName, lastName, birthday, address, email;
    private CheckBox checkbox;
    private TextView notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        btnSelect = findViewById(R.id.btnSelect);
        radioGroup = findViewById(R.id.radioGroup);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        birthday = findViewById(R.id.birthday);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);

        rdbMale = findViewById(R.id.rdbMale);
        rdbFemale = findViewById(R.id.rdbFemale);

        checkbox = findViewById(R.id.checkbox);
        notification = findViewById(R.id.notification);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRdb = radioGroup.getCheckedRadioButtonId();

                if(firstName.getText().equals("")) {
                    notification.setText("You must enter your first name");
                }
                if(lastName.getText().equals("")){
                    notification.setText("You must enter your last name");
                }
                if(idRdb != rdbMale.getId() && idRdb != rdbFemale.getId()) {
                    notification.setText("You must choose your gender");
                }
                if(birthday.getText().equals("")) {
                    notification.setText("You must choose your birthday");
                }
                if(address.getText().equals("")){
                    notification.setText("You must enter your address");
                }
                if(email.getText().equals("")){
                    notification.setText("You must enter your email");
                }
                if(!checkbox.isChecked()) {
                    notification.setText("You must check policy");
                }
                if(!firstName.getText().equals("")
                        && !address.getText().equals("")
                        && !lastName.getText().equals("")
                        && !birthday.getText().equals("")
                        && !email.getText().equals("")
                        && !checkbox.getText().equals("")
                        && idRdb == rdbMale.getId() || idRdb == rdbFemale.getId()) {
                    notification.setText("You enter successfully!");
                }
            }
        });
    }
}