package com.nnk.DurgapurTourism;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_addexpense extends Fragment {


    public Fragment_addexpense() {
        // Required empty public constructor
    }

    private ImageView i1;
    private CardView c1,c2,c3,c4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_addexpense_,container,false);
        ImageView i1=(ImageView) v.findViewById(R.id.i1);
        ImageView i2=(ImageView) v.findViewById(R.id.i2);
        ImageView i3=(ImageView) v.findViewById(R.id.i3);
        ImageView i4=(ImageView) v.findViewById(R.id.i4);

        TextView t1=(TextView) v.findViewById(R.id.t1);
        TextView t2=(TextView) v.findViewById(R.id.t2);
        TextView t3=(TextView) v.findViewById(R.id.t3);
        TextView t4=(TextView) v.findViewById(R.id.t4);

        c1=v.findViewById(R.id.c1);
        c2=v.findViewById(R.id.c2);
        c3=v.findViewById(R.id.c3);
        c4=v.findViewById(R.id.c4);



        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SeeReviewList.class);
                intent.putExtra("places",((TextView)(c1.findViewById(R.id.t1))).getText().toString());
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SeeReviewList.class);
                intent.putExtra("places",((TextView)(c2.findViewById(R.id.t2))).getText().toString());
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SeeReviewList.class);
                intent.putExtra("places",((TextView)(c3.findViewById(R.id.t3))).getText().toString());
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SeeReviewList.class);
                intent.putExtra("places",((TextView)(c4.findViewById(R.id.t4))).getText().toString());
                startActivity(intent);
            }
        });

        return v;
    }


}
