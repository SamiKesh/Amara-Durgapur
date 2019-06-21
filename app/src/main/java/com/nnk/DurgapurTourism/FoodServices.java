package com.nnk.DurgapurTourism;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class FoodServices extends AppCompatActivity {
    CardView c1,c2,c3;
    boolean have_WIFI=false;
    boolean have_MobileData=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_services);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.zomato.com/durgapur/restaurants"));
                    chooser = Intent.createChooser(browserIntent, "Open With");
                    startActivity(chooser);
                }
                else
                {
                    Snackbar.make(v,"Connect with Internet",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();                }



            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tripadvisor.in/Restaurants-g644044-zfp19-Durgapur_Bardhaman_District_West_Bengal.html"));
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
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/BhukkadBoxDgr/"));
                    chooser = Intent.createChooser(browserIntent, "Open With");
                    startActivity(chooser);
                }
                else
                {
                    Snackbar.make(v,"Connect with Internet",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();                }

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
