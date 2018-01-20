package com.example.kyle.studyhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Filter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Button ConfirmFilter = (Button) findViewById(R.id.ConfirmFilter);
        ConfirmFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText FilterCl = (EditText) findViewById(R.id.FilterClass);
                String FilterClass = FilterCl.getText().toString();
                EditText FilterLo = (EditText) findViewById(R.id.FilterLocation);
                String FilterLocation = FilterLo.getText().toString();

//              filter variables FilterClass and FilterLocation
                startActivity(new Intent(getApplicationContext(), Main.class));
            }
        });
    }
}
