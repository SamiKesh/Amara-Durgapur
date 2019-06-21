package com.nnk.DurgapurTourism;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ReviewList extends ArrayAdapter<AddReview> {
    private Activity context;
    private List<AddReview> reviewList;
    public ReviewList(Activity context,List<AddReview> reviewList){
        super(context,R.layout.listlayout,reviewList);
        this.context=context;
        this.reviewList=reviewList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View listViewItem=layoutInflater.inflate(R.layout.listlayout,null,true);
        TextView textViewName=listViewItem.findViewById(R.id.textViewName);
        TextView textViewamount=listViewItem.findViewById(R.id.textReview);
        TextView textViewTime=listViewItem.findViewById(R.id.textRating);
        TextView textViewAuthor=listViewItem.findViewById(R.id.textName);

        AddReview addReview=reviewList.get(position);
        textViewName.setText(addReview.getName());
        textViewamount.setText(addReview.getReview());
        textViewTime.setText(addReview.getRating());
        textViewAuthor.setText(addReview.getAuthor());

        return listViewItem;
    }
}
