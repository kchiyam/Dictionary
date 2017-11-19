package com.example.khanhchivu.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSpeak, btnCamera, btnAcademy, btnAssisstance;
    private EditText txtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnAcademy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Academy_activity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        txtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LookUpActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SpeakActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    private void init() {
        txtSearch = (EditText) findViewById(R.id.txtsearch);
        btnAcademy = (Button) findViewById(R.id.btnacdemy);
        btnAssisstance = (Button) findViewById(R.id.btnassistance);
        btnSpeak = (Button) findViewById(R.id.btnspeak);
        btnCamera = (Button) findViewById(R.id.btncamera);
    }
}
