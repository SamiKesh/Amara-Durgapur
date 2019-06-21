package com.nnk.DurgapurTourism;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    TextView t1,t2,t3;
    CardView c1,c2,c3;
    boolean have_WIFI=false;
    boolean have_MobileData=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.olacabs");
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    haveNetwork();
                    if(have_MobileData || have_WIFI) {
                        Intent chooser = null;
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.olacabs.com/outstation-cars/Kolkata-to-Durgapur"));
                        chooser = Intent.createChooser(browserIntent, "Open With");
                        startActivity(chooser);
                    }
                    else
                    {
                        Snackbar.make(v,"Connect with Internet",Snackbar.LENGTH_LONG)
                                .setAction("Action",null).show();
                    }
                }
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.durgapurcity.co.in/trains.html"));
                    chooser = Intent.createChooser(browserIntent, "Open With");
                    startActivity(chooser);
                }
                else
                {
                    Snackbar.make(v,"Connect with Internet",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();                }

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Main2Activity.this,BusActivity.class);
                startActivity(intent);



            }
        });
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
