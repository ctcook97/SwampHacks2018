package com.example.kyle.studyhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class DownOn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_on);
        ImageButton ExitDown = (ImageButton) findViewById(R.id.ExitDown);
        ExitDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main.class));
            }
        });

        Button Submit = (Button) findViewById(R.id.Submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Loc = (EditText) findViewById(R.id.Location);
                String Location = Loc.getText().toString();
                EditText Cl = (EditText) findViewById(R.id.Class);
                String Class = Cl.getText().toString();
                EditText Con = (EditText) findViewById(R.id.Contact);
                String Contact = Con.getText().toString();
                EditText Ti = (EditText) findViewById(R.id.Time);
                String Time = Ti.getText().toString();

//              import Location, Class, Contact, Time to data base here
                startActivity(new Intent(getApplicationContext(), Main.class));
            }
        });
    }
}
