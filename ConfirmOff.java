package com.example.kyle.studyhack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by kyle on 1/20/18.
 */

public class ConfirmOff extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.confirmoff);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(.80*width), (int)(.3*height));
        Button Confirm = (Button) findViewById(R.id.Confirm);
        Button DoNotConfirm = (Button) findViewById(R.id.DoNotConfirm);
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmOff.this.finish();
            }
        });
        DoNotConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmOff.this.finish();
            }
        });
    }



}
