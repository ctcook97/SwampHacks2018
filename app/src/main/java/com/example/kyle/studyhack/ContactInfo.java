package com.example.kyle.studyhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        TextView Name = (TextView) findViewById(R.id.Name);
        Name.setText("Cameron Cook");
        TextView Number = (TextView) findViewById(R.id.Number);
        Number.setText("352-226-6073");
        Button Leave = (Button) findViewById(R.id.Leave);
        Leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), classes.class));
            }
        });
    }
}
