package com.example.kyle.studyhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        Button Submit = (Button) findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText UFI = (EditText) findViewById(R.id.inUFID);
                String UFID = UFI.getText().toString();
                EditText Nam = (EditText) findViewById(R.id.inName);
                String Name = Nam.getText().toString();
                EditText Pho = (EditText) findViewById(R.id.inPhone);
                String PhoneNumber = Pho.getText().toString();

//              import Location, Class, Contact, Time to data base here
                startActivity(new Intent(getApplicationContext(), classes.class));
            }
        });
    }
}
