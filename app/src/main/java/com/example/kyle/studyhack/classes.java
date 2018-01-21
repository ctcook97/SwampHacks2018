package com.example.kyle.studyhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class classes extends AppCompatActivity {

    DatabaseReference database;
    List<String> myClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        Button addButton = (Button) findViewById(R.id.go);
        ListView listView = (ListView) findViewById(R.id.classList);
        final ArrayList<String> classes =new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, classes);
        final AutoCompleteTextView add=(AutoCompleteTextView) findViewById(R.id.add);
        String[] classList=new String[]{"COT3100","IUF1000", "MAC2312"};
        myClasses = new ArrayList<String>();
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, classList);

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance().getReference();
        add.setAdapter(dropDownAdapter);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                classes.add("Loading " + add.getText().toString());
                adapter.notifyDataSetChanged();
                add.setText("");
                myClasses.add(add.getText().toString());

            }
        });


        listView.setAdapter(adapter);




    }
}
