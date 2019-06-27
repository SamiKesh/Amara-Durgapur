package com.nnk.DurgapurTourism;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {

    //private static final attr R = ;
    Button b1;
    ImageView imageView;
    SignInButton button;
    TextView t1,t2,t3;
    FirebaseAuth firebaseAuth;
    private  final static int RC_SIGN_IN=2;
    GoogleSignInClient mGoogleSignInClient;
    private ProgressDialog progressDialog;
    FirebaseAuth.AuthStateListener mAuthListener;
    protected FirebaseUser user;


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"The application only uses the google account details and do not misuse it..",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"All right reserved ®. Made with Love in India",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Mail Us at sameeksha.keshari77@gmail.com",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
            }
        });

        button=findViewById(R.id.b3);
        imageView=findViewById(R.id.i1);
        firebaseAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
                signIn();
            }
        });

        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser()!=null)
                {
                    startActivity(new Intent(MainActivity.this,MaintwoActivity.class));
                }
            }
        };

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


    }
//    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
   //         .requestIdToken(getString(R.string.default_web_client_id))
     //       .requestEmail()
          //  .build();
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
    private void signIn() {
        Intent signInIntent =mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                // ...
            }

        }
        else
        {
            Toast.makeText(this,"Auth went wrong",Toast.LENGTH_LONG).show();
            hideProgressDialog();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication Failed.",Toast.LENGTH_LONG).show();
                            //updateUI(null);
                        }

                        // ...
                    }

                    private void updateUI(FirebaseUser user) {
                        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if (user != null) {
                            // Name, email address, and profile photo Url
                            String name = user.getDisplayName();
                            String email = user.getEmail();
                            //Uri photoUrl = user.getPhotoUrl();


                            // Check if user's email is verified
                            boolean emailVerified = user.isEmailVerified();

                            // The user's ID, unique to the Firebase project. Do NOT use this value to
                            // authenticate with your backend server, if you have one. Use
                            // FirebaseUser.getIdToken() instead.
                            String uid = user.getUid();
                            Intent i=new Intent(MainActivity.this,UserDetails.class);
                            i.putExtra("m1",name);
                            i.putExtra("m2",email);
                            i.putExtra("m3",uid);
                            //i.putExtra("imagePath", photoUrl.toString());

                            startActivity(i);


                            Toast.makeText(MainActivity.this, "Successfully Signed In Name: "+name+"Email: "+email, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



    public void login(View view)
    {
        Intent i=new Intent(MainActivity.this,MaintwoActivity.class);
        startActivity(i);

    }



}
