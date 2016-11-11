package com.fjodor.fjodor_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinishedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        TextView text = (TextView) findViewById(R.id.final_result);
        text.setText(result);
    }
}
