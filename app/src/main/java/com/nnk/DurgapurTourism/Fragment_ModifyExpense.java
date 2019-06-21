package com.nnk.DurgapurTourism;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fragment_ModifyExpense extends Fragment {


    public Fragment_ModifyExpense(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment__modify_expense, container, false);
       // LinearLayout myLayout = (LinearLayout) rootView.findViewById(R.id.li);

        ImageView i1=(ImageView) rootView.findViewById(R.id.i1);
        TextView t1=rootView.findViewById(R.id.t1);
        TextView t2=rootView.findViewById(R.id.t2);
        TextView t3=rootView.findViewById(R.id.t3);
        Button b=rootView.findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailTo="mailto:sameeksha.keshari77@gmail.com"+"?cc=" + "" +
                        "&subject=Feedback";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailTo));
                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    //TODO: Handle case where no email app is available
                }

            }
        });


        return rootView;

    }


}
