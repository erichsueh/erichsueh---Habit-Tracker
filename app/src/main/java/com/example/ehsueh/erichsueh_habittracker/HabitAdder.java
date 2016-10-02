package com.example.ehsueh.erichsueh_habittracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by Eric Shay on 2016-10-01.
 */
public class HabitAdder extends ActionBarActivity{

    private EditText bodyText;
   // private ArrayAdapter<Habit> adapter;
    //private ListView HabitAndroidList;
    //private ArrayList<Habit> HabitList = new ArrayList<Habit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habiter);

    }

    public void FinishedAdding(View view) {
        bodyText = (EditText) findViewById(R.id.body);
        String text = bodyText.getText().toString();
        int[] mArray = new int[]{0,0,0,0,0,0,0};
        Habit newhabit = new Habit(text,mArray);
        HabitListController hl = new HabitListController();
        hl.addHabit(newhabit);
        finish();
    }

}
