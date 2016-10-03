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
 */
public class HabitAdder extends ActionBarActivity{
    private static final String FILENAME = "file.sav";
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
