package com.example.hospital_management_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hospital_management_app.databinding.ActivityLoginBinding;
import com.example.hospital_management_app.utilities.Constants;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Login_activity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private UserHelperClass preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager=new UserHelperClass(getApplicationContext());
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    public void setListeners(){
        binding.newAccount.setOnClickListener(v->startActivity(new Intent(getApplicationContext(), newAccount.class)));

        binding.buttonSignIn.setOnClickListener(v -> {
            if(isValidSignInDetails())
            {
                SignIn();
            }
        });
    }

    private void showToast(String message)
    {
        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
    }
    private boolean isValidSignInDetails() {
        if(binding.inputEmail.getText().toString().trim().isEmpty()){
             showToast("Enter Email");
             return false;
        }else if(binding.inputPassword.getText().toString().trim().isEmpty()){
            showToast("Enter Password");
            return false;
        }else{
            return true;
        }
    }

    private void SignIn() {
        loading(true);
        FirebaseFirestore database= FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL, binding.inputEmail.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful() && task.getResult()!=null
                    && task.getResult().getDocuments().size()>0) {
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                            preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                            preferenceManager.putString(Constants.KEY_USER_ID, documentSnapshot.getId());
                            preferenceManager.putString(Constants.KEY_NAME, documentSnapshot.getString(Constants.KEY_NAME));

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }else{
                            loading(false);
                            showToast("Unable to Sign In");
                        }

                });
    }

    private void loading(Boolean isLoading)
    {
        if(isLoading){
            binding.buttonSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }else{
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignIn.setVisibility(View.VISIBLE);
        }
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