package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapp.R;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(this, "onCreate Activity2", Toast.LENGTH_SHORT).show();

        Intent i = getIntent();
        TextView tv = findViewById(R.id.textView2);
        tv.setText(i.getStringExtra("key1"));
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy Activity2", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public void clickBoutonRetour( View v ) {
        Intent i = new Intent();
        i.putExtra("key2", "Retour de param");
        setResult(1, i);
        finish();
    }
}