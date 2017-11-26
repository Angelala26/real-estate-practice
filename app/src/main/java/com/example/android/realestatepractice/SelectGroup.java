package com.example.android.realestatepractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectGroup extends AppCompatActivity {

    Button sectionOneButton;
    Button sectionTwoButton;
    Button sectionThreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_group);

        sectionOneButton = (Button) findViewById(R.id.section_one);
        sectionOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: go to section one questions
            }
        });

        sectionTwoButton = (Button) findViewById(R.id.section_two);
        sectionTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: go to section two questions
            }
        });

        sectionThreeButton = (Button) findViewById(R.id.section_three);
        sectionThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: go to section three questions
            }
        });


    }
}
