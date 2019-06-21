package com.nnk.DurgapurTourism;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDetails extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference databaseReference;

    TextInputEditText user_name,user_password,user_phone_number;
    Button btn_login;
    String email;
    TextView user_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        user_name = findViewById(R.id.user_name);
        user_password = findViewById(R.id.user_password);
        user_phone_number = findViewById(R.id.user_contact);
        user_email = findViewById(R.id.user_email);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        Intent i1 = getIntent();
        Bundle b1 = i1.getExtras();
        String name = b1.getString("m1");
         email = b1.getString("m2");
        String id = b1.getString("m3");
        //Uri photoUrl = b1.get
        user_email.setText(email);
        user_name.setText(name);


        Toast.makeText(this, ""+getIntent().getStringExtra("phonenumber"), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onClick(View v) {
        if (user_name.getText().toString().isEmpty()) {
            user_name.setError("Name is required...");
            user_name.requestFocus();
            return;
        }
        if (user_password.getText().toString().isEmpty()) {
            user_password.setError("Password is required...");
            user_password.requestFocus();
            return;
        }
        if (user_phone_number.getText().toString().isEmpty()) {
            user_phone_number.setError("PhoneNumber is required...");
            user_phone_number.requestFocus();
            return;
        }

        String id = databaseReference.push().getKey();

        Users users = new Users(user_email.getText().toString().trim(), user_phone_number.getText().toString().trim(), user_password.getText().toString().trim(), user_name.getText().toString().trim());
        databaseReference.child(id).setValue(users);

        user_name.setText("");
        user_phone_number.setText("");
        user_password.setText("");
//        SharedPreferences sharedPreferences = getSharedPreferences("user_data1", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("userphone",users.getPhoneNumber());
//        editor.putString("password",users.getPassword());
//        editor.putString("authorname",users.getUsername());
//        editor.putString("email",user_email.getText().toString());
//        editor.commit();
        finish();
        Intent intent = new Intent(this,LoginPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //Toast.makeText(this, "Info added", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
//                {
//                    Users users=dataSnapshot1.getValue(Users.class);
//                    if(users.getEmail().equals(email))
//                    {
//                        Toast.makeText(UserDetails.this, "User already exists", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(UserDetails.this,LoginPage.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
//
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
}

