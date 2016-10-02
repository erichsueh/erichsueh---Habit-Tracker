package com.example.ehsueh.erichsueh_habittracker;

import android.app.Activity;
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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {

    //private ArrayList<Habit> HabitList = new ArrayList<Habit>();
    //private HabitList thehabitlist = new HabitList();
    //private ArrayAdapter<Habit> adapter;
    //private ListView HabitAndroidList;
    HabitListController hl = new HabitListController();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
                Habit habit = list.get(position);
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
//		String[] tweets = loadFromFile();
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


}
