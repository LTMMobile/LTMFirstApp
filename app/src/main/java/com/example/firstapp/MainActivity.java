package com.example.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.firstapp.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if( data != null ) {
            TextView tv = findViewById(R.id.textView1);
            tv.setText(data.getStringExtra("key2"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButtonStartActivity( View v) {
        TextView tv = findViewById(R.id.textView1);
        tv.setText("Start ...");

        Intent i = new Intent(this, MainActivity2.class );
        i.putExtra("key1", "param");
        startActivityForResult( i, 1);
    }

    public void clickBoutonNavigateur( View v ) {
        Intent i = new Intent( Intent.ACTION_VIEW, Uri.parse("http://www.ltm.fr"));
        try {
            startActivity(i);
        }catch(ActivityNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void clickBoutonMap( View v ) {
        String u = "geo:0,0?q=google+8rueDeLondres+Paris";
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(u) );
        try {
            startActivity(intent);
        }catch( ActivityNotFoundException ex){
            Log.v("ltm","Vous n'avez pas GMap ou système équivalent");
        }
    }
}