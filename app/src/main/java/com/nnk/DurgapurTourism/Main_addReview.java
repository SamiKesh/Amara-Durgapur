package com.nnk.DurgapurTourism;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main_addReview extends AppCompatActivity {

    TextView t1;
    EditText e2,e3;
    Button b1;
    AutoCompleteTextView e1;
    // FirebaseDatabase database;
    DatabaseReference databaseReference;
    String[] names=new String[]{"Barbeque Nation","City Residency","Indiana Restaurant","Theque","Bonolata Restaurant",
            "Dominos","Hungry zone","Lemon Grass","Mainland China","Pizza Hut","Arihant's Natural IceCream",
            "The Peerless Inn","Fortune Park Pushpanjali"};
    String[] parks=new String[]{"Nehru Sishu Kendra","Anand Amusement Park","Kumar Mangalam Park",
            "Major Park","Solor Energy Park"};
    String[] plants=new String[]{"Alloy Steel Plant","Durgapur Steel Plant"};
    String[]shopping=new String[]{"Benachity","Fortune Plaza","Junction Mall"};
    String root_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_review);
        root_place= getIntent().getStringExtra("places");
        databaseReference= FirebaseDatabase.getInstance().getReference("review").child(root_place);
        //database = FirebaseDatabase.getInstance();
        //databaseReference = database.getReference("message");
      /*  e1=(Spinner) findViewById(R.id.e1);*/
        /*myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e1.setAdapter(myAdapter);*/
        t1 =findViewById(R.id.t1);
        e1 =findViewById(R.id.e1);
        if(root_place.equals("Restaurants and Hotels")) {
            e1.setAdapter(new ArrayAdapter<>(Main_addReview.this,
                    android.R.layout.simple_list_item_1, names));
        }
        else if(root_place.equals("Parks")) {
            e1.setAdapter(new ArrayAdapter<>(Main_addReview.this,
                    android.R.layout.simple_list_item_1, parks));
        }
        else if(root_place.equals("Plants")) {
            e1.setAdapter(new ArrayAdapter<>(Main_addReview.this,
                    android.R.layout.simple_list_item_1, plants));
        }
        else if(root_place.equals("Shopping")) {
            e1.setAdapter(new ArrayAdapter<>(Main_addReview.this,
                    android.R.layout.simple_list_item_1, shopping));
        }
        e2 =findViewById(R.id.e2);
        e3 =findViewById(R.id.e3);
        b1 =findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMedicine();

            }
        });
    }
    private void addMedicine() {
        String name = e1.getText().toString().trim();
        String review = e2.getText().toString().trim();
        String rating = e3.getText().toString().trim();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(review) && !TextUtils.isEmpty(rating)) {
            int i,flag=0,flag1=0;
            if(root_place.equals("Restaurants and Hotels")) {
                for (i = 0; i < names.length; i++) {
                    if (name.contains(names[i]))
                        flag = 1;
                }
            }
            else if(root_place.equals("Parks")) {
                for (i = 0; i < parks.length; i++) {
                    if (name.contains(parks[i]))
                        flag = 1;
                }
            }
            else if(root_place.equals("Plants")) {

                for (i = 0; i < plants.length; i++) {
                    if (name.contains(plants[i]))
                        flag = 1;
                }
            }
            else if(root_place.equals("Shopping")) {
                for (i = 0; i < shopping.length; i++) {
                    if (name.contains(shopping[i]))
                        flag = 1;
                }
            }

            int x=Integer.parseInt(rating);
            if(x<=5 && x>=1)
                flag1=1;

            if(flag==1 && flag1==1) {
                SharedPreferences sharedPreferences = getSharedPreferences("userData1", Context.MODE_PRIVATE);
                String author = sharedPreferences.getString("user_name", "");
                String email = sharedPreferences.getString("user_email", "");
                Toast.makeText(Main_addReview.this, "Details" + author + email, Toast.LENGTH_LONG).show();
                String id = databaseReference.push().getKey();
                AddReview addReview = new AddReview(id, name, "Review: " + review, "Rating: " + rating, email, "Posted By: " + author);
                databaseReference.child(id).setValue(addReview);
                e1.setText("");
                e2.setText("");
                e3.setText("");
                Toast.makeText(Main_addReview.this, "Review Added", Toast.LENGTH_LONG).show();
            }
            else
            {
                if(flag==0) {
                    e1.requestFocus();
                    e1.setError("Invalid Place");
                    Toast.makeText(Main_addReview.this, "Can't post review for this place. Please type an appropriate place", Toast.LENGTH_LONG).show();
                }
                else
                {
                    e3.requestFocus();
                    e3.setError("Invalid Rating");
                    Toast.makeText(Main_addReview.this, "Please rate between 1 to 5", Toast.LENGTH_LONG).show();


                }
            }

        } else {

            e1.requestFocus();
            e1.setError("Empty");
            Toast.makeText(Main_addReview.this,"Review couldn't be added Added",Toast.LENGTH_LONG).show();

        }
    }

}
