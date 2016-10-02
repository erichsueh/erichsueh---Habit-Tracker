package com.example.ehsueh.erichsueh_habittracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Eric Shay on 2016-10-01.
 */
public class HabitAdder extends ActionBarActivity{

    private EditText bodyText;
    private CheckBox mondaybox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habiter);

    }

    public void FinishedAdding(View view) {
        bodyText = (EditText) findViewById(R.id.body);
        String text = bodyText.getText().toString();
        ArrayList<String> mArray = new ArrayList<String>();
        mondaybox = (CheckBox) findViewById(R.id.MonBox);
        Boolean test;
        test = mondaybox.hasSelection();
        if (mondaybox.isSelected()){
            mArray.add("Monday");
        }


        Habit newhabit = new Habit(text,mArray);
        HabitListController hl = new HabitListController();
        hl.addHabit(newhabit);
        finish();
    }

}
