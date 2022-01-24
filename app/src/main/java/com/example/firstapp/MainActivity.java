package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            Toast.makeText(this,"ITEM 1", Toast.LENGTH_LONG).show();
        }else if(item.getItemId()  == R.id.item2) {
            Toast.makeText(this,"ITEM 2", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);

        return super.onCreateOptionsMenu(menu);
    }
}