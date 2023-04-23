package com.example.hospital_management_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hospital_management_app.databinding.ActivityLoginBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Login_activity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    public void setListeners(){
        binding.newAccount.setOnClickListener(v->startActivity(new Intent(getApplicationContext(), newAccount.class)));

        binding.buttonSignIn.setOnClickListener(v -> addDataToFirestore());
    }

    private void addDataToFirestore(){
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        HashMap<String, Object > data=new HashMap<>();
        data.put("First_name" ,"Purushottam");
        data.put("Last_name" ,"Singh");

        database.collection("users")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(getApplicationContext(), "Data inserted" , Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(exception ->{
                    Toast.makeText(getApplicationContext(), exception.getMessage()  ,Toast.LENGTH_SHORT ).show();
                });
    }

}