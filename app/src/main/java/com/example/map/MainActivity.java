package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
EditText source,destination;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        source=findViewById(R.id.source);
        destination=findViewById(R.id.destination);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ssource=source.getText().toString().trim();
                String sdestination=destination.getText().toString().trim();

                if(ssource.equals("") && sdestination.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter location and destination",Toast.LENGTH_SHORT).show();
                }
                else{
                    Displaytrack(ssource,sdestination);
                }
            }
        });
    }
    public void Displaytrack(String ssource,String sdestination){
        try{
            Uri uri=Uri.parse("http://www.google.co.in/maps/dir/"+ssource + "/" + sdestination);

            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri=Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.apps,maps");
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}