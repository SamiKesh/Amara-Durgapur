package com.nnk.DurgapurTourism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment_calculate extends Fragment {
    public Fragment_calculate(){

    }
    TextView t1,t4,t6,t7,t8,t9,t12,t13,t14,t16,t17,t18,t19,t20,t21,t22,t24,t25,t27,t28,t29,t3,t11;
    CardView c1,c2,c3,c4,c5,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_calculate, container, false);
        c1=(CardView) v.findViewById(R.id.c1);
        c2=(CardView) v.findViewById(R.id.c2);
        c3=(CardView) v.findViewById(R.id.c3);
        c4=(CardView) v.findViewById(R.id.c4);
        c5=(CardView) v.findViewById(R.id.c5);
        c7=(CardView) v.findViewById(R.id.c7);
        c8=(CardView) v.findViewById(R.id.c8);
        c9=(CardView) v.findViewById(R.id.c9);
        c10=(CardView) v.findViewById(R.id.c10);
        c11=(CardView) v.findViewById(R.id.c11);
        c12=(CardView) v.findViewById(R.id.c12);
        c13=(CardView) v.findViewById(R.id.c13);
        c14=(CardView) v.findViewById(R.id.c14);
        c15=(CardView) v.findViewById(R.id.c15);
        c16=(CardView) v.findViewById(R.id.c16);
        c17=(CardView) v.findViewById(R.id.c17);
        c18=(CardView) v.findViewById(R.id.c18);
        c19=(CardView) v.findViewById(R.id.c19);
        c20=(CardView) v.findViewById(R.id.c20);
        c21=(CardView) v.findViewById(R.id.c21);
        c22=(CardView) v.findViewById(R.id.c22);
        c23=(CardView) v.findViewById(R.id.c23);
        c24=(CardView) v.findViewById(R.id.c24);



        t1=(TextView) v.findViewById(R.id.t1);
        t3=(TextView) v.findViewById(R.id.t3);
        t11=(TextView) v.findViewById(R.id.t11);
         t4=(TextView) v.findViewById(R.id.t4);
         t6=(TextView) v.findViewById(R.id.t6);
         t7=(TextView) v.findViewById(R.id.t7);
         t8=(TextView) v.findViewById(R.id.t8);
        t9=(TextView) v.findViewById(R.id.t9);
        t12=(TextView) v.findViewById(R.id.t12);
        t13=(TextView) v.findViewById(R.id.t13);
        t14=(TextView) v.findViewById(R.id.t14);
        t16=(TextView) v.findViewById(R.id.t16);
        t17=(TextView) v.findViewById(R.id.t17);
        t18=(TextView) v.findViewById(R.id.t18);
        t19=(TextView) v.findViewById(R.id.t19);
        t20=(TextView) v.findViewById(R.id.t20);
        t21=(TextView) v.findViewById(R.id.t21);
        t22=(TextView) v.findViewById(R.id.t22);
        t24=(TextView) v.findViewById(R.id.t24);
        t25=(TextView) v.findViewById(R.id.t25);
        t27=(TextView) v.findViewById(R.id.t27);
        t28=(TextView) v.findViewById(R.id.t28);
        t29=(TextView) v.findViewById(R.id.t29);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.562766, 87.299462?q="+t1.getText().toString().trim()+"@23.562766, 87.299462"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.564759, 87.281608?q="+t4.getText().toString().trim()+"@23.564759, 87.281608"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });

        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.528211, 87.269273?q="+t6.getText().toString().trim()+"@23.528211, 87.269273"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.536151, 87.302106?q="+t7.getText().toString().trim()+"@23.536151, 87.302106"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.538875, 87.293342?q="+t8.getText().toString().trim()+"@23.538875, 87.293342"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.539173, 87.292797?q="+t9.getText().toString().trim()+"@23.539173, 87.292797"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.558157, 87.299050?q="+t12.getText().toString().trim()+"@23.558157, 87.299050"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.558799, 87.275690?q="+t13.getText().toString().trim()+"@23.558799, 87.275690"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.536865, 87.296918?q="+t14.getText().toString().trim()+"@23.536865, 87.296918"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.539065, 87.298061?q="+t16.getText().toString().trim()+"@23.539065, 87.298061"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.539734, 87.289995?q="+t17.getText().toString().trim()+"@23.539734, 87.289995"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.556255, 87.274650?q="+t18.getText().toString().trim()+"@23.556255, 87.274650"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.536998, 87.296027?q="+t19.getText().toString().trim()+"@23.536998, 87.296027"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.560176, 87.299093?q="+t20.getText().toString().trim()+"@23.560176, 87.299093"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.537171, 87.294357?q="+t21.getText().toString().trim()+"@23.537171, 87.294357"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.570878, 87.292858?q="+t22.getText().toString().trim()+"@23.570878, 87.292858"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.539439, 87.290767?q="+t24.getText().toString().trim()+"@23.539439, 87.290767"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.538797, 87.291687?q="+t25.getText().toString().trim()+"@23.538797, 87.291687"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.532846, 87.308024?q="+t27.getText().toString().trim()+"@23.532846, 87.308024"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.539218, 87.292654?q="+t28.getText().toString().trim()+"@23.539218, 87.292654"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.539237, 87.291101?q="+t29.getText().toString().trim()+"@23.539237, 87.291101"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.540082, 87.292487?q="+t3.getText().toString().trim()+"@23.540082, 87.292487"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        c24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null,chooser=null;
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:23.541069, 87.291569?q="+t11.getText().toString().trim()+"@23.541069, 87.291569"));
                intent.setPackage("com.google.android.apps.maps");
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });



        return v;
    }

}
