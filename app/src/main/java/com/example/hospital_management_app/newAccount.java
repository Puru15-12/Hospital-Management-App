package com.example.hospital_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicStampedReference;

public class newAccount extends AppCompatActivity {
    private EditText first_name;
    private EditText last_name;
    private EditText email;
    private EditText mob_no;
    private RadioButton patient;
    private RadioButton ambulance;
    private RadioButton doctor;
    private RadioButton male;
    private RadioButton female;
    private RadioButton others;
    private EditText password;
    private EditText confirm;
    private Button register;
    private TextView no_need;
    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(newAccount.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Select_city));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        first_name= findViewById(R.id.editTextTextMultiLine);
        last_name=findViewById(R.id.editTextTextMultiLine2);
        email=findViewById(R.id.editTextTextEmailAddress);
        mob_no=findViewById(R.id.editTextPhone2);
        patient=findViewById(R.id.radioButton);
        ambulance=findViewById(R.id.radioButton2);
        doctor=findViewById(R.id.radioButton3);
        male=findViewById(R.id.radioButton4);
        female=findViewById(R.id.radioButton5);
        others=findViewById(R.id.radioButton6);
        password=findViewById(R.id.editTextNumberPassword);
        confirm=findViewById(R.id.editTextNumberPassword2);
        register=findViewById(R.id.button2);
        no_need=findViewById(R.id.textView6);
        login=findViewById(R.id.textView7);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname=first_name.getText().toString();
                String lname=last_name.getText().toString();
                String mail=email.getText().toString();
                String no=mob_no.getText().toString();

            }
        });

    }
}