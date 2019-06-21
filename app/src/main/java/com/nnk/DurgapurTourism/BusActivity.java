package com.nnk.DurgapurTourism;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BusActivity extends AppCompatActivity {
    TextView t1,t2,t3;
    boolean have_WIFI=false;
    boolean have_MobileData=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        TextView t1=findViewById(R.id.t11);
        TextView t2=findViewById(R.id.t12);
        TextView t3=findViewById(R.id.t13);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://shyamolibusservice.com/"));
                    chooser = Intent.createChooser(browserIntent, "Open With");
                    startActivity(chooser);
                }
                else
                {
                    Snackbar.make(v,"Connect with Internet",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();                }



            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://greenlineservices.in/"));
                    chooser = Intent.createChooser(browserIntent, "Open With");
                    startActivity(chooser);
                }
                else
                {
                    Snackbar.make(v,"Connect with Internet",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();                }



            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sbstc.co.in/services.php"));
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
