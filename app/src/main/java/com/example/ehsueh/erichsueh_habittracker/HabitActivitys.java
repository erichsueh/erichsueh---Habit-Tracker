package com.example.ehsueh.erichsueh_habittracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;

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
public class HabitActivitys {
    private ArrayList<Habit> tweetList = new ArrayList<Habit>();


    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
//		String[] tweets = loadFromFile();
        adapter = new ArrayAdapter<Habit>(this,
                R.layout.list_item, tweetList);
        oldTweetsList.setAdapter(adapter);

    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();

            tweetList = gson.fromJson(in,listType);

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
            gson.toJson(tweetList,out);
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
