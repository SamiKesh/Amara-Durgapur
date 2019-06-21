package com.nnk.DurgapurTourism;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class Fragment_home extends Fragment {

    public Fragment_home(){

    }
    ViewFlipper i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* Button b1= getView().findViewById(R.id.add);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                                      fragmentTransaction.replace(R.id.f1, new Fragment_addexpense());
                                      fragmentTransaction.commit();
                                      }
                              }
        );*/
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        int images[]={R.drawable.citi,R.drawable.sail,R.drawable.dd};
        i= v.findViewById(R.id.i);
        TextView t1=(TextView) v.findViewById(R.id.t1);
        TextView t2=(TextView) v.findViewById(R.id.t2);
        for(int image:images){
            flipperImages(image);
        }

        return v;
    }
    public void flipperImages(int image)
    {
        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(image);
        i.addView(imageView);
        i.setFlipInterval(4000);
        i.setAutoStart(true);

        i.setInAnimation(getContext(),android.R.anim.slide_in_left);
        i.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }


}
