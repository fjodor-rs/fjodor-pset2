package com.fjodor.fjodor_pset2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class FillWordsActivity extends AppCompatActivity {


    String finished_story;
    String input;
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        InputStream is;

        try {
            is = getAssets().open("madlib1_tarzan.txt");
        } catch (IOException e) {
            is = null;
            e.printStackTrace();
        }

        story = new Story(is);

        EditText text = (EditText) findViewById(R.id.user_input);

        String placeholder = story.getNextPlaceholder();
        text.setHint(placeholder);

        TextView words = (TextView) findViewById(R.id.words_left);

        String counter = String.valueOf(story.getPlaceholderRemainingCount());
        counter = counter + " word(s) left";
        words.setText(counter);
    }

    public void onClickButton(View view) {

        EditText text = (EditText) findViewById(R.id.user_input);

        String input = text.getText().toString();
        story.fillInPlaceholder(input);

        String placeholder = story.getNextPlaceholder();
        text.setHint(placeholder);

        TextView words = (TextView) findViewById(R.id.words_left);

        String counter = String.valueOf(story.getPlaceholderRemainingCount());
        counter = counter + " word(s) left";
        words.setText(counter);

        if (story.isFilledIn()) {
            String finished_story = story.toString();
            Intent intent = new Intent(this, FinishedActivity.class);
            intent.putExtra("result", finished_story);
            startActivity(intent);
            }
        text.setText("");
    }
}
