package com.example.khanhchivu.myapplication3;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class LookUpActivity extends AppCompatActivity implements TextWatcher {
    String[] items = {"Hello","Age","Address","Dictionary","Date","Hight"};
    AutoCompleteTextView autotext;
    Boolean check = true;
    Button btnEV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up);
        autotext = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        autotext.addTextChangedListener(this);
        autotext.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items));
        autotext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LookUpActivity.this, ViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
        final Button btnEV = (Button) findViewById(R.id.button);
        btnEV.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                if (check){
                    btnEV.setText("V - E");
                    check = false;
                } else {
                    btnEV.setText("E - V");
                    check = true;
                }
            }
        });



    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
