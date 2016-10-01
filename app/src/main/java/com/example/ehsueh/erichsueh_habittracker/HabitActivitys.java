package com.example.ehsueh.erichsueh_habittracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;



/**
 * Created by Eric Shay on 2016-09-30.
 */
public class HabitActivitys extends Activity{
    private static final String FILENAME = "file.sav";

    private ArrayList<Habit> thehabitList = new ArrayList<Habit>();
    private ArrayAdapter<Habit> adapter;

    private EditText bodyText;
    private ListView HabitsList;

    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
//		String[] tweets = loadFromFile();
        adapter = new ArrayAdapter<Habit>(this, R.layout.list_item, thehabitList);
        HabitsList.setAdapter(adapter);
    }

    protected void onResume(){
        super.onResume();
        Button saveButton = (Button) findViewById(R.id.AddNewHabit);
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();

                Habit newhabit = new Habit(text);

                thehabitList.add(newhabit);
                adapter.notifyDataSetChanged();

                saveInFile();

            }
        });
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();

            thehabitList = gson.fromJson(in,listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(thehabitList,out);
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
