package com.example.hospital_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class newAccount extends AppCompatActivity {
    private EditText first_name;
    private EditText last_name;
    private EditText email;
    private EditText mob_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        first_name=findViewById(R.id.editTextTextMultiLine);
        last_name=findViewById(R.id.editTextTextMultiLine2);
        email=findViewById(R.id.editTextTextEmailAddress);
        mob_no=findViewById(R.id.editTextPhone2);


    }
}