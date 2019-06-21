package com.nnk.DurgapurTourism;


import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.CONNECTIVITY_SERVICE;


public class Fragment_member extends Fragment {

  public Fragment_member(){

  }
    boolean have_WIFI=false;
    boolean have_MobileData=false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_member,container,false);
        TextView t1=(TextView) v.findViewById(R.id.t1);
        TextView t2=(TextView) v.findViewById(R.id.t2);
        TextView t3=(TextView) v.findViewById(R.id.t3);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.fade_in);
        t1.startAnimation(animation);

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haveNetwork();
                if(have_MobileData || have_WIFI) {
                    Intent chooser = null;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Durgapur"));
                    chooser = Intent.createChooser(browserIntent, "Open With");
                    startActivity(chooser);
                }
                else
                {
                 //   Toast.makeText(getActivity(), "Connect with Internet", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v,"Connect with Internet",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();
                }

            }
        });

        return v;

    }

    private boolean haveNetwork() {

            ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(getContext().CONNECTIVITY_SERVICE);
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
