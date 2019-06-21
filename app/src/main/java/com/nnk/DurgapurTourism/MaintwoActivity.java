package com.nnk.DurgapurTourism;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static java.security.AccessController.getContext;

public class MaintwoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //FirebaseAuth firebaseAuth;
   // FirebaseAuth.AuthStateListener mAuthListener;
    TextView t1,t2;
    ImageView imageView;
   private DrawerLayout drawer;
    boolean have_WIFI=false;
    boolean have_MobileData=false;
    /* @Override

    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);
      //  firebaseAuth.getInstance();
        /*if(firebaseAuth.getCurrentUser()==null){
            finish();
            Intent i=new Intent(MaintwoActivity.this,MainActivity.class);
            startActivity(i);

        }
        FirebaseUser user=firebaseAuth.getCurrentUser();
        */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getSharedPreferences("userData1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("user_email","");
       // Toast.makeText(this, "hello     "+email, Toast.LENGTH_SHORT).show();
       String name = sharedPreferences.getString("user_name","");
        //t1.setText(name);
      // Intent i1=getIntent();
       //Bundle b=i1.getExtras();
       //String name=b.getString("k1");
       //t1.setText(name);
      // t2.setText(user.getEmail());
       // Intent intent = getIntent();
        //String image_path= intent.getStringExtra("imagePath");
        //Uri fileUri = Uri.parse(image_path);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.inflateHeaderView(R.layout.nav_header_maintwo);
        //imageView = (ImageView)hView.findViewById(R.id.imageView);
        t1 = (TextView)hView.findViewById(R.id.t1);
        t2 = (TextView)hView.findViewById(R.id.t2);
        t1.setText(name);
        t2.setText(email);
        //imageView.setImageUri(fileUri);
      /*  try {
            Glide.with(getApplicationContext()).load(image_path)
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
            // imgvw .setImageResource(R.drawable.logo);

        }
        catch (Exception e)
        {
            imageView.setImageResource(R.drawable.ppp);
            Toast.makeText(this, "NULL", Toast.LENGTH_SHORT).show();

        }*/


        Fragment_home fragment=new Fragment_home();
        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.f1,fragment,"fragment1");
        fragmentTransaction.commit();

        /*if(savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.f1,new Fragment_home()).commit();
        navigationView.setCheckedItem(R.id.i1);}*/



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maintwo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.i1) {
            Intent intent=new Intent(MaintwoActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else if(id==R.id.i2)
        {
            Intent intent=new Intent(MaintwoActivity.this,FoodServices.class);
            startActivity(intent);

        }
        else if(id==R.id.i3){
            haveNetwork();
            if(have_MobileData || have_WIFI) {
                Intent chooser = null;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?safe=active&source=hp&ei=ZXwLXcTZCY3_rQGL4IDABA&q=temple+in+durgapur&oq=Temple+in+dur&gs_l=psy-ab.3.0.0l4j0i22i30l6.942.22657..23671...19.0..0.741.8495.0j16j12j0j2j1j2......0....1..gws-wiz.....6..35i39j0i131.WYXVO2ovlmo"));
                chooser = Intent.createChooser(browserIntent, "Open With");
                startActivity(chooser);
            }
            else
            {
                Toast.makeText(this, "Connect with Internet", Toast.LENGTH_SHORT).show();
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.i1) {
            setTitle("Home");
            Fragment_home fragment=new Fragment_home();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.f1,fragment,"fragment1");
            fragmentTransaction.commit();



        } else if (id == R.id.i2) {
            setTitle("About");
            Fragment_member fragment_member=new Fragment_member();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.f1,fragment_member,"fragment2");
            fragmentTransaction.commit();


        } else if (id == R.id.i3) {
            setTitle("Places");
            Fragment_addexpense fragment_addexpense=new Fragment_addexpense();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.f1,fragment_addexpense,"fragment3");
            fragmentTransaction.commit();


        } else if (id == R.id.i4) {
            setTitle("Contact Us");
            Fragment_ModifyExpense fragment_modifyExpense=new Fragment_ModifyExpense();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.f1,fragment_modifyExpense,"fragment4");
            fragmentTransaction.commit();


        }else if(id==R.id.i5){
            setTitle("Gallery");
            Fragment_calculate fragment_calculate=new Fragment_calculate();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.f1,fragment_calculate,"fragment5");
            fragmentTransaction.commit();

        } else if (id == R.id.i6) {
            finish();
            startActivity(new Intent(MaintwoActivity.this,Logout.class));
          /* mAuthListener =new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    if(firebaseAuth.getCurrentUser()==null)
                    {
                        startActivity(new Intent(MaintwoActivity.this,MainActivity.class));
                    }

                }
            };
            firebaseAuth.signOut();*/
        }

       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();

        }
    }
    private boolean haveNetwork() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected())
                    have_WIFI = true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    have_MobileData = true;
        }
        return have_MobileData||have_WIFI;

    }
}
