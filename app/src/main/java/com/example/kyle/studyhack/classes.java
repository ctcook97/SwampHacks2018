package com.example.kyle.studyhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class classes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addButton = (Button) findViewById(R.id.go);
        ListView listView = (ListView) findViewById(R.id.classList);
        final ArrayList<String> classes =new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, classes);
        final AutoCompleteTextView add=(AutoCompleteTextView) findViewById(R.id.add);
        String[] classList=new String[]{"COT3100    Application of Discr...","IUF1000    What is the Good Life"};
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, classList);

        add.setAdapter(dropDownAdapter);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                classes.add(add.getText().toString());
                adapter.notifyDataSetChanged();
                add.setText("");
            }
        });


        listView.setAdapter(adapter);
    }
}
