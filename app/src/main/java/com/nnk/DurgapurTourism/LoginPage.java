package com.nnk.DurgapurTourism;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {
    TextInputEditText emailId,password;
    TextView btn_signup;
    Button login;
    private ProgressDialog progressDialog;


    public static SharedPreferences sharedPreferences;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        setContentView(R.layout.activity_login_page);
        emailId= findViewById(R.id.loginId);
        password = findViewById(R.id.password);
        btn_signup= findViewById(R.id.btn_signup);
        login = findViewById(R.id.login);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this,MainActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLoginStatus();
                showProgressDialog();
            }
        });



    }
    protected void showProgressDialog()
    {
        if(progressDialog==null)
        {
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.setIndeterminate(true);
        }
        progressDialog.show();
    }
    protected void hideProgressDialog(){
        if(progressDialog!=null){
            progressDialog.hide();
        }
    }
    private void checkLoginStatus() {

        if(emailId.getText().toString().isEmpty())
        {
            emailId.setError("EmailId is Required..!!");
            emailId.requestFocus();
            hideProgressDialog();

        }
        if (password.getText().toString().isEmpty())
        {
            password.setError("Password is Required..!!");
            password.requestFocus();
            hideProgressDialog();
        }
        else {

            final String phn = emailId.getText().toString().trim();
            final String pass = password.getText().toString().trim();

            //Toast.makeText(LoginPage.this,phn+pass,Toast.LENGTH_LONG).show();

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        Users users = dataSnapshot1.getValue(Users.class);
                       // Toast.makeText(LoginPage.this,users.getEmail()+users.getPassword(),Toast.LENGTH_LONG).show();
                        if (users.getEmail().equals(phn) && users.getPassword().equals(pass))
                        {
                            //Homepage.orgainser_name = users.getUsername();
                            sharedPreferences = getSharedPreferences("userData1", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("user_email", phn);
                            editor.putString("user_password", pass);
                            editor.putString("user_name",users.getUsername());
                            //Toast.makeText(LoginPage.this, "" + users.getUsername(), Toast.LENGTH_SHORT).show();
                            //Toast.makeText(LoginPage.this, ""+sharedPreferences.getString("user_phone",""), Toast.LENGTH_SHORT).show();
                            editor.commit();
                            finish();
                            Intent intent = new Intent(LoginPage.this, MaintwoActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            hideProgressDialog();

                        }
                        if (!users.getPhoneNumber().equals(emailId.getText().toString().trim()) || !users.getPassword().equals(password.getText().toString().trim())) {
                                emailId.setError("Invalid Credentials");
                                emailId.setText("");
                                emailId.requestFocus();
                                password.setText("");


                            hideProgressDialog();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }


    }
}
