package com.example.hospital_management_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class newAccount extends AppCompatActivity {
//    private EditText first_name,last_name,email,mob_no;
//    private RadioButton patient,ambulance,doctor;
//    private EditText password,confirm;
//    private Button register;
//    private TextView no_need,login;
//    UserHelperClass member=new UserHelperClass();
//       FirebaseDatabase rootnode;
//       DatabaseReference refrence;
//    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(newAccount.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Select_city));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
//
//        first_name= findViewById(R.id.editTextTextMultiLine);
//        last_name=findViewById(R.id.editTextTextMultiLine2);
//        email=findViewById(R.id.editTextTextEmailAddress);
//        mob_no=findViewById(R.id.editTextPhone2);
//        patient=findViewById(R.id.radioButton);
//        ambulance=findViewById(R.id.radioButton2);
//        doctor=findViewById(R.id.radioButton3);
//        password=findViewById(R.id.editTextNumberPassword);
//        confirm=findViewById(R.id.editTextNumberPassword2);
//        register=findViewById(R.id.button2);
//        no_need=findViewById(R.id.textView6);
//        login=findViewById(R.id.textView7);
//
//        rootnode= FirebaseDatabase.getInstance();
//
//        refrence= rootnode.getReference("users");
//
//        no_need.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(newAccount.this,MainActivity.class));
//            }
//        });
//        refrence.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()) {
//                    i = (int) dataSnapshot.getChildrenCount();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(newAccount.this,"Registration Failed",Toast.LENGTH_SHORT).show();
//            }
//        });
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String fname=first_name.getText().toString();
//                String lname=last_name.getText().toString();
//                String mail=email.getText().toString();
//                String no=mob_no.getText().toString();
//                String pass=password.getText().toString();
//                if(TextUtils.isEmpty(fname) || TextUtils.isEmpty(lname) || TextUtils.isEmpty(mail) || TextUtils.isEmpty(no) || TextUtils.isEmpty(pass))
//                {
//                    Toast.makeText(newAccount.this,"Empty Credentials",Toast.LENGTH_SHORT).show();
//                }
//                else if (pass.length()<6)
//                {
//                    Toast.makeText(newAccount.this,"Password too short",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    member.setFirst(fname);
//                    member.setLast(lname);
//                    member.setEmail(mail);
//                    member.setNo(no);
//                    member.setPassword(pass);
//
//                    String m1 = patient.getText().toString();
//                    String m2 = ambulance.getText().toString();
//                    String m3 = doctor.getText().toString();
//
//                    if (patient.isChecked()) {
//                        member.setOptions(m1);
//                        refrence.child(String.valueOf(i + 1)).setValue(member);
//                    } else if (ambulance.isChecked()) {
//                        member.setOptions(m2);
//                        refrence.child(String.valueOf(i + 1)).setValue(member);
//                    } else {
//                        member.setOptions(m3);
//                        refrence.child(String.valueOf(i + 1)).setValue(member);
//                    }
//                    Toast.makeText(newAccount.this,"Registration Successful",Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(newAccount.this,MainActivity.class));
//                }
//            }
//        });
    }
}