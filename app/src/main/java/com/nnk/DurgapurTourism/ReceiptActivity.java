package com.nnk.DurgapurTourism;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ReceiptActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        t1=findViewById(R.id.ref);
        t2=findViewById(R.id.name);
        t3=findViewById(R.id.upi_id);
        t4=findViewById(R.id.amount_et);
        b1=findViewById(R.id.b);
        Intent i1=getIntent();
        Bundle b=i1.getExtras();

        assert b != null;
        String ref=b.getString("k1");
        String name=b.getString("k3");
        String upi=b.getString("k2");
        String amt=b.getString("k4");
        t1.setText("REFERENCE NUMBER: "+ref);
        t2.setText("PAID TO: "+name);
        t3.setText("UPI ID: "+upi);
        t4.setText("AMOUNT: "+amt);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenshot();

            }
        });
    }
    private void screenshot()
    {
        Date date=new Date();
        CharSequence now=android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss",date);
        String filename= Environment.getExternalStorageDirectory()+"/AmaraDurgapur_Receipt/"+now+".jpg";

        View root=getWindow().getDecorView();
        root.setDrawingCacheEnabled(true);
        Bitmap bitmap=Bitmap.createBitmap(root.getDrawingCache());

        File file=new File(filename);
        file.getParentFile().mkdirs();
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            Uri uri=Uri.fromFile(file);
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri,"image/*");
            startActivity(intent);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
