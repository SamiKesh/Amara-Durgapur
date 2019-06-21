package com.nnk.DurgapurTourism;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SeeReviewList extends AppCompatActivity {
    ListView listViewMed;
    DatabaseReference databaseReference;
    List<AddReview> addReviewList;


    Button b1;
    String root_place="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_review_list);
        root_place= getIntent().getStringExtra("places");
        databaseReference= FirebaseDatabase.getInstance().getReference("review").child(root_place);
        addReviewList= new ArrayList<>();
        listViewMed=(ListView)findViewById(R.id.l1);
        b1=findViewById(R.id.b1);
        SharedPreferences sharedPreferences = getSharedPreferences("userData1", Context.MODE_PRIVATE);
        final String email = sharedPreferences.getString("user_email","");
        //Toast.makeText(this, "hello  "+email.equals(null), Toast.LENGTH_SHORT).show();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.equals("")==true){
                    Intent intent=new Intent(SeeReviewList.this,LoginPage.class);
                    Toast.makeText(SeeReviewList.this,"Review Cannot be added please LOGIN",Toast.LENGTH_LONG).show();

                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(SeeReviewList.this, Main_addReview.class);

                    intent.putExtra("places", root_place);
                    startActivity(intent);
                }
            }
        });
        listViewMed.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddReview addReview=addReviewList.get(position);
                showMapApp(addReview.getId(),addReview.getName());
            }
        });

        listViewMed.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AddReview addReview=addReviewList.get(position);

                showUpadateDialog(addReview.getId(),addReview.getName(),
                        addReview.getReview().substring(8),addReview.getRating().substring(8),addReview.getEmailId());

                return false;
            }
        });
    }

    private void check(String email1,View view1,View view2) {

        SharedPreferences sharedPreferences = getSharedPreferences("userData1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("user_email","");
        if (email.equals(email1))
        {
            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.VISIBLE);
        }

    }

    private void showMapApp(String id, String name) {
       Intent intent=null, chooser=null;
       intent=new Intent(Intent.ACTION_VIEW);
       if(name.equals("Nehru Sishu Kendra"))
            intent.setData(Uri.parse("geo:23.558157, 87.299050?q="+name+"@23.558157, 87.299050"));
       if(name.equals("Anand Amusement Park"))
            intent.setData(Uri.parse("geo:23.536151, 87.302106?q="+name+"@23.536151, 87.302106"));
       if(name.equals("Kumar Mangalam Park"))
           intent.setData(Uri.parse("geo:23.562766, 87.299462?q="+name+"@23.562766, 87.299462"));
        if(name.equals("Alloy Steel Plant"))
            intent.setData(Uri.parse("geo:23.528211, 87.269273?q="+name+"@23.528211, 87.269273"));
        if(name.equals("Barbeque Nation"))
            intent.setData(Uri.parse("geo:23.538875, 87.293342?q="+name+"@23.538875, 87.293342"));
        if(name.equals("City Residency"))
            intent.setData(Uri.parse("geo:23.539173, 87.292797?q="+name+"@23.539173, 87.292797"));
        if(name.equals("Benachity"))
            intent.setData(Uri.parse("geo:23.558799, 87.275690?q="+name+"@23.558799, 87.275690"));
        if(name.equals("Indiana Restaurant"))
            intent.setData(Uri.parse("geo:23.560176, 87.299093?q="+name+"@23.560176, 87.299093"));
        if(name.equals("Theque"))
            intent.setData(Uri.parse("geo:23.539218, 87.292654?q="+name+"@23.539218, 87.292654"));
        if(name.equals("Bonolata Restaurant"))
            intent.setData(Uri.parse("geo:23.539065, 87.298061?q="+name+"@23.539065, 87.298061"));
        if(name.equals("Dominos"))
            intent.setData(Uri.parse("geo:23.539734, 87.289995?q="+name+"@23.539734, 87.289995"));
        if(name.equals("Fortune Plaza"))
            intent.setData(Uri.parse("geo:23.556255, 87.274650?q="+name+"@23.556255, 87.274650"));
        if(name.equals("Hungry zone"))
            intent.setData(Uri.parse("geo:23.536998, 87.296027?q="+name+"@23.536998, 87.296027"));
        if(name.equals("Lemon Grass"))
            intent.setData(Uri.parse("geo:23.537171, 87.294357?q="+name+"@23.537171, 87.294357"));
        if(name.equals("Major Park"))
            intent.setData(Uri.parse("geo:23.570878, 87.292858?q="+name+"@23.570878, 87.292858"));
        if(name.equals("Mainland China"))
            intent.setData(Uri.parse("geo:23.539439, 87.290767?q="+name+"@23.539439, 87.290767"));
        if(name.equals("Pizza Hut"))
            intent.setData(Uri.parse("geo:23.538797, 87.291687?q="+name+"@23.538797, 87.291687"));
        if(name.equals("Solor Energy Park"))
            intent.setData(Uri.parse("geo:23.532846, 87.308024?q="+name+"@23.532846, 87.308024"));
        if(name.equals("Junction Mall"))
            intent.setData(Uri.parse("geo:23.539237, 87.291101?q="+name+"@23.539237, 87.291101"));
        if(name.equals("Arihant's Natural IceCream"))
            intent.setData(Uri.parse("geo:23.536865, 87.296918?q="+name+"@23.536865, 87.296918"));
        if(name.equals("Durgapur Steel Plant"))
            intent.setData(Uri.parse("geo:23.564759, 87.281608?q="+name+"@23.564759, 87.281608"));
        if(name.equals("The Peerless Inn"))
            intent.setData(Uri.parse("geo:23.540082, 87.292487?q="+name+"@23.540082, 87.292487"));
        if(name.equals("Fortune Park Pushpanjali"))
            intent.setData(Uri.parse("geo:23.541069, 87.291569?q="+name+"@23.541069, 87.291569"));

        intent.setPackage("com.google.android.apps.maps");
       chooser=Intent.createChooser(intent,"Launch Maps");
       startActivity(chooser);
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                addReviewList.clear();

                for(DataSnapshot medSnapshot: dataSnapshot.getChildren()){
                    AddReview addReview=medSnapshot.getValue(AddReview.class);
                    addReviewList.add(addReview);
                }
                ReviewList adapter=new ReviewList(SeeReviewList.this,addReviewList);
                listViewMed.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showUpadateDialog(final String id, String name, String review, String rating,String email){
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View dialogView=inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);

        final EditText e1=(EditText) dialogView.findViewById(R.id.e1);
        final EditText e2=(EditText) dialogView.findViewById(R.id.e2);
        final EditText e3=(EditText) dialogView.findViewById(R.id.e3);
        final Button b1=(Button) dialogView.findViewById(R.id.b1);
        final Button b2=(Button) dialogView.findViewById(R.id.b2);
        check(email,b2,b1);
         e1.setText(name);
         e2.setText(review);
         e3.setText(rating);
        dialogBuilder.setTitle("Updating Info: "+name);
        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString().trim();
                String review=e2.getText().toString().trim();
                String rating=e3.getText().toString();
                if(TextUtils.isEmpty(name)){
                    e1.requestFocus();
                    e1.setError("Empty");
                    return;
                }else
                {
                    if (TextUtils.isEmpty(review))
                    {
                        e2.requestFocus();
                        e2.setError("Empty");
                        return;
                    }else{
                        if(TextUtils.isEmpty(rating)){
                            e3.requestFocus();
                            e3.setError("Empty");
                            return;
                        }

                        updateMedList(id,name,review,rating);

                        alertDialog.dismiss();
                    }

                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteMed(id);
            }
        });



    }
    private  void deleteMed(String id){
        DatabaseReference deleteMed=FirebaseDatabase.getInstance().getReference("review").child(root_place).child(id);
        deleteMed.removeValue();
            Toast.makeText(this, "Review Deleted", Toast.LENGTH_SHORT).show();

    }
    private  boolean updateMedList(String id,String name,String review,String rating)
    {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("review").child(root_place)
                .child(id);
        SharedPreferences sharedPreferences = getSharedPreferences("userData1", Context.MODE_PRIVATE);
        String author = sharedPreferences.getString("user_name","");
        String email=sharedPreferences.getString("user_email","");

        AddReview addReview=new AddReview(id,name,"Review: "+review,"Rating: "+rating,email,"Posted BY: "+author);
        databaseReference.setValue(addReview);
        Toast.makeText(this,"Review Updated Successfully"+email+author,Toast.LENGTH_LONG).show();
        return  true;
    }
}
