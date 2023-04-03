package com.example.hospital_management_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        Intent iNext;
        iNext=new Intent(getApplicationContext(), newAccount.class);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(iNext);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this ,Login_activity.class));
                finish();
            }
        });
    }
}