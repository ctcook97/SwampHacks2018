package com.example.kyle.studyhack;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

public class Main extends AppCompatActivity {

    Switch Down;
    ImageButton Filter;
    public static boolean searching = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Down = (Switch)findViewById(R.id.Down);
        Down.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    startActivity(new Intent(getApplicationContext(), ConfirmOff.class));
                }
                else{
                    Intent On = new Intent(getApplicationContext(), DownOn.class);
                    startActivity(On);
                }
            }
        });
        Filter = (ImageButton) findViewById(R.id.Filter);
        Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Filter.class));
            }
        });
    }
}
