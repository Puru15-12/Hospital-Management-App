package com.example.hospital_management_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hospital_management_app.databinding.ActivityNewAccountBinding;
import com.example.hospital_management_app.utilities.Constants;
import com.example.hospital_management_app.utilities.DoctorsList;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class newAccount extends AppCompatActivity {
    private ActivityNewAccountBinding binding;
    private UserHelperClass preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager=new UserHelperClass(getApplicationContext());
        setListeners();
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(newAccount.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Select_city));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }

    private void setListeners() {
        binding.textSignIn.setOnClickListener(v -> onBackPressed());

        binding.buttonSignUp.setOnClickListener(v -> {
            if(isValidSignUpDetails()){
                signUp();
            }
        });
    }
    private void showToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    private void signUp(){
        loading(true);
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        HashMap<String , Object> user =new HashMap<>();
        user.put(Constants.KEY_NAME ,binding.inputName.getText().toString());
        user.put(Constants.KEY_EMAIL ,binding.inputEmail.getText().toString());
        user.put(Constants.KEY_MOBILE ,binding.inputMobile.getText().toString());
        if(!binding.radioButton1.getText().toString().trim().isEmpty())
            user.put(Constants.KEY_YOU ,binding.radioButton1.getText().toString());
        else if(!binding.radioButton2.getText().toString().trim().isEmpty())
            user.put(Constants.KEY_YOU ,binding.radioButton1.getText().toString());
        else if(!binding.radioButton3.getText().toString().trim().isEmpty())
            user.put(Constants.KEY_YOU ,binding.radioButton1.getText().toString());

        user.put(Constants.KEY_PLACE ,binding.spinner1.getSelectedItem().toString());
        user.put(Constants.KEY_PASSWORD ,binding.inputPassword.getText().toString());

        database.collection(Constants.KEY_COLLECTION_USERS).add(user)
                .addOnSuccessListener(documentReference -> {
                    loading(false);
                    preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN ,true);
                    preferenceManager.putString(Constants.KEY_USER_ID ,documentReference.getId());
                    preferenceManager.putString(Constants.KEY_NAME ,binding.inputName.getText().toString());
                    Intent intent=new Intent(getApplicationContext() ,Login_activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                })
                .addOnFailureListener(exception ->{
                    loading(false);
                    showToast(exception.getMessage());
                });
    }

    private Boolean isValidSignUpDetails(){
        if(binding.inputName.getText().toString().trim().isEmpty())
        {
            showToast("Enter Name");
            return false;
        }else if(binding.inputEmail.getText().toString().trim().isEmpty()){
            showToast("Enter Email");
            return false;
        } else if(binding.inputMobile.getText().toString().trim().isEmpty()) {
            showToast("Enter Mobile Number");
            return false;
        }else if(binding.inputPassword.getText().toString().trim().isEmpty()){
            showToast("Enter Password");
            return false;
        }else if(binding.radioButton1.getText().toString().trim().isEmpty() && binding.radioButton2.getText().toString().trim().isEmpty()
        && binding.radioButton3.getText().toString().trim().isEmpty() ){

            showToast("Enter your side");
            return false;
        }else if(binding.spinner1.getAdapter().toString().trim().isEmpty())
        {
            showToast("Enter your city");
            return false;
        }else if(binding.inputConfirmPassword.getText().toString().trim().isEmpty()) {
            showToast("Confirm your password");
            return false;
        }else if(!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString())) {
            showToast("Password and confirm password must must be same");
            return false;
        }else {
            return true;
        }
    }

    private void loading(Boolean isLoading)
    {
        if(isLoading){
            binding.buttonSignUp.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }else{
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignUp.setVisibility(View.VISIBLE);
        }
    }
}