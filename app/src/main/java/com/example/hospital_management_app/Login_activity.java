//package com.example.hospital_management_app;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//
//public class Login_activity extends AppCompatActivity {
//
//    private EditText phone;
//    private EditText password;
//    private Button login;
//    private FirebaseAuth auth;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        phone=findViewById(R.id.editTextTextEmailAddress);
//        password=findViewById(R.id.editTextNumberPassword);
//        login=findViewById(R.id.login);
//        auth=FirebaseAuth.getInstance();
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text_phone=phone.getText().toString();
//                String text_password=password.getText().toString();
//                loginuser(text_phone,text_password);
//            }
//        });
//    }
//
//    private void loginuser(String text_phone, String text_password) {
//
//        auth.signInWithEmailAndPassword(text_phone,text_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//            @Override
//            public void onSuccess(AuthResult authResult) {
//                Toast.makeText(Login_activity.this,"Login Succesful",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(Login_activity.this,MainActivity.class));
//                finish();
//            }
//        });
//    }
//
//}