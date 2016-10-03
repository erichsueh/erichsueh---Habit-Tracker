package com.example.ehsueh.erichsueh_habittracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class ViewHistory extends ActionBarActivity {
    private static final String FILENAME = "file1.sav";

    //this oncreate method will set the completed habit list controllers, as well as
    //sets a pop up that can delete old completed habits
    //once a habit is deleted, it will go look for any habits that have the same name as this current
    //completed habit and then decrease the count of said habit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        loadFromFile();
        ListView listView = (ListView) findViewById(R.id.CompletedHabitList);
        ArrayList<CompletedHabits> comphabit =
                CompletedHabitListController.getcompHabitList().getHabitlist();
        final ArrayList<CompletedHabits> list = new ArrayList<CompletedHabits>(comphabit);
        final ArrayAdapter<CompletedHabits> habitAdapter =
                new ArrayAdapter<CompletedHabits>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(habitAdapter);

        CompletedHabitListController.getcompHabitList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                ArrayList<CompletedHabits> habits =
                        CompletedHabitListController.getcompHabitList().getHabitlist();
                list.addAll(habits);
                habitAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder adb = new AlertDialog.Builder(ViewHistory.this);
                adb.setMessage("Are you sure you want to delete your completed habit?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CompletedHabits habit = list.get(finalPosition);
                        try {
                            Habit anotherhabit =
                                    HabitListController.getHabitList().findHabit(habit.getFinishedhabit());

                        HabitListController.getHabitList().DecreaseCounter(anotherhabit);
                        }
                        catch(NullPointerException e){
                            CompletedHabitListController.getcompHabitList().removeHabit(habit);
                            saveInFile();
                            System.err.print("No habit found");
                        }
                        CompletedHabitListController.getcompHabitList().removeHabit(habit);
                        saveInFile();
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                adb.show();
                return false;
            }
        });

    }

    //this is just a button that takes the user back to the main view
    public void BackToMain(View view){
        finish();
    }

    //these two methods are taken from Lonely Twitter, it makes sure that Completed Habits List
    //will persist even after we're done
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<CompletedHabits>>(){}.getType();
            ArrayList<CompletedHabits> newlist = gson.fromJson(in,listType);
            CompletedHabitListController.getcompHabitList().SetHabitList(newlist);

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
            ArrayList hablist = CompletedHabitListController.getcompHabitList().getHabitlist();
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
