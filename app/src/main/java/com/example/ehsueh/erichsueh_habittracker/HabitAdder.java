package com.example.ehsueh.erichsueh_habittracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Eric Shay on 2016-10-01.
 *
 * This is the Habit Editor (The screen where they can customize to their habits
 *
 * THe on Create method changes the view of the instance to the habite view
 * FinishedAdding is the button from habiter (the finished button)
 * FInish adder will take the message as well as days of the week and compile it into a habit
 * then it will add the habit and then save it to the list , then the gson persistance adder will
 * take over and save it to a gson file so that persistance remains
 * the gson saver is taken from LonelyTwitter, with close to no changes
 */
public class HabitAdder extends ActionBarActivity{
    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private CheckBox mondaybox;
    private CheckBox tuesdaybox;
    private CheckBox wednesdaybox;
    private CheckBox thursdaybox;
    private CheckBox fridaybox;
    private CheckBox saturdaybox;
    private CheckBox sundaybox;

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
        tuesdaybox = (CheckBox) findViewById(R.id.TueBox);
        wednesdaybox = (CheckBox) findViewById(R.id.WedBox);
        thursdaybox = (CheckBox) findViewById(R.id.ThursBox);
        fridaybox = (CheckBox) findViewById(R.id.FriBox);
        saturdaybox = (CheckBox) findViewById(R.id.SatBox);
        sundaybox = (CheckBox) findViewById(R.id.SunBox);

            if (mondaybox.isChecked()) {
                mArray.add("Mon");
            }

            if (tuesdaybox.isChecked()) {
                mArray.add("Tue");
            }

            if (wednesdaybox.isChecked()) {
                mArray.add("Wed");
            }

            if (thursdaybox.isChecked()) {
                mArray.add("Thu");
            }

            if (fridaybox.isChecked()) {
                mArray.add("Fri");
            }

            if (saturdaybox.isChecked()) {
                mArray.add("Sat");
            }

            if (sundaybox.isChecked()) {
                mArray.add("Sun");
            }

            Habit newhabit = new Habit(text, mArray);
            HabitListController hl = new HabitListController();
            hl.addHabit(newhabit);
            saveInFile();
            finish();
        }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            ArrayList hablist = HabitListController.getHabitList().getHabitlist();
            gson.toJson(hablist,out);
            out.flush();

            fos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}
