package com.example.kyle.studyhack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {

    EditText UFI;
    EditText Nam;
    EditText Pho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Button Submit = (Button) findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UFI = (EditText) findViewById(R.id.inUFID);
                String UFID = UFI.getText().toString();
                Nam = (EditText) findViewById(R.id.inName);
                String Name = Nam.getText().toString();
                Pho = (EditText) findViewById(R.id.inPhone);
                String PhoneNumber = Pho.getText().toString();
                saveData();

//              import Location, Class, Contact, Time to data base here
                startActivity(new Intent(getApplicationContext(), classes.class));
            }
        });

    }
    /* DISABLES THE START SCREEN ONCE YOU HAVE ENTERED INFORMATION
    Take out comments to use again
        @Override
        protected void onStart() {
            super.onResume();
            SharedPreferences sharedPref = getSharedPreferences("Permanent Data", Context.MODE_PRIVATE);
            Boolean dataExists  = sharedPref.getBoolean("Exists", false);
            if(dataExists){
                startActivity(new Intent(getApplicationContext(), classes.class));
            }

        }
    */
    public void saveData(){
        SharedPreferences sharedPref = getSharedPreferences("Permanent Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("UFID", UFI.getText().toString());
        editor.putString("Name", Nam.getText().toString());
        editor.putString("Phone", Pho.getText().toString());
        editor.putBoolean("Exists", true);
        Toast.makeText(this, "Information saved!", Toast.LENGTH_SHORT).show();
        editor.apply();
    }
}
