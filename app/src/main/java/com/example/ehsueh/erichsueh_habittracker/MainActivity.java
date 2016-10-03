package com.example.ehsueh.erichsueh_habittracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final String FILENAME = "file.sav";
    private static final String FILENAME1 = "file1.sav";
    //private ArrayList<Habit> HabitList = new ArrayList<Habit>();
    //private HabitList thehabitlist = new HabitList();
    //private ArrayAdapter<Habit> adapter;
    //private ListView HabitAndroidList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFromFile();
        ListView listView = (ListView) findViewById(R.id.HabitAndroidList);
        ArrayList<Habit> habits = HabitListController.getHabitList().getHabitlist();
        final ArrayList<Habit> list = new ArrayList<Habit>(habits);
        final ArrayAdapter<Habit> habitAdapter = new ArrayAdapter<Habit>(this,android.R.layout.simple_list_item_1, list);
        listView.setAdapter(habitAdapter);

        HabitListController.getHabitList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                ArrayList<Habit> habits = HabitListController.getHabitList().getHabitlist();
                list.addAll(habits);
                habitAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("What would you like to do?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Habit habit = list.get(finalPosition);
                        HabitListController.getHabitList().removeHabit(habit);
                        saveInFile();
                    }
                });
                adb.setNeutralButton("+1!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Habit habit = list.get(finalPosition);
                        HabitListController.getHabitList().IncreaseCounter(habit);
                        CompletedHabits comphabit = new CompletedHabits(habit.getMessage());
                        CompletedHabitListController.getcompHabitList().AddCompletedHabit(comphabit);
                        saveInFile();
                        saveInFile1();
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

    @Override
    protected void onResume(){
        super.onResume();

        //adapter.notifyDataSetChanged();
    }

    public void Vhistory(View view){
        Intent intent = new Intent(this,ViewHistory.class);
        startActivity(intent);
    }

    public void AddtoList(View view){
        //Habit thehabit = new Habit("Fuckyouworkgoddamit");
        //HabitList.add(thehabit);
        //adapter.notifyDataSetChanged();
        Intent intent = new Intent(this,HabitAdder.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        //adapter = new ArrayAdapter<Habit>(this,
        //        R.layout.list_item, HabitList);
        //HabitAndroidList.setAdapter(adapter);

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
            ArrayList<Habit> newlist = gson.fromJson(in,listType);
            HabitListController.getHabitList().SetHabitList(newlist);

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
    private void saveInFile1() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME1,
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
