package com.example.kyle.studyhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class classes extends AppCompatActivity {

    DatabaseReference database;
    List<String> myClasses;
    List<Integer> headcount;
    List<String> leaderNames;
    List<String> classes;

    protected void updateClass(int index)
    {
        String message = "Matt H. and " + headcount.get(index).toString() + " others are studying " + myClasses.get(index);
        classes.set(index, message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        Button addButton = (Button) findViewById(R.id.go);
        ListView listView = (ListView) findViewById(R.id.classList);
        classes =new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, classes);
        final AutoCompleteTextView add=(AutoCompleteTextView) findViewById(R.id.add);
        String[] classList=new String[]{"COT3100","IUF1000", "MAC2312"};
        myClasses = new ArrayList<String>();
        headcount = new ArrayList<Integer>();
        leaderNames = new ArrayList<String>();
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, classList);
        ImageView p1= (ImageView) findViewById(R.id.p1);
        ImageView p2= (ImageView) findViewById(R.id.p2);
        ImageView p3= (ImageView) findViewById(R.id.p3);
        final ArrayList<ImageView> images=new ArrayList<ImageView>();
        images.add(p3);
        images.add(p2);
        images.add(p1);

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance().getReference();
        add.setAdapter(dropDownAdapter);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                classes.add("Loading " + add.getText().toString());
                adapter.notifyDataSetChanged();
                myClasses.add(add.getText().toString());
                headcount.add(0);
                leaderNames.add("Kent Fuchs");
                final String classId = add.getText().toString();

                database.child(classId).addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                       Log.e("Bruh", "Key: " + classId);
                       int i = myClasses.indexOf(classId);
                       headcount.set(i, headcount.get(i)+1);
                       updateClass(i);
                   }
                   @Override
                   public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

                   @Override
                   public void onChildRemoved(DataSnapshot dataSnapshot) {
                       int i = myClasses.indexOf(dataSnapshot.getKey());
                       headcount.set(i, headcount.get(i)-1);
                       updateClass(i);
                   }

                   @Override
                   public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                   @Override
                   public void onCancelled(DatabaseError databaseError) {
                   }
                                               }
                    );
                add.setText("");
                images.get(images.size()-1).setVisibility(View.VISIBLE);
                images.remove(images.size()-1);
            }
        });


        listView.setAdapter(adapter);




    }
}
