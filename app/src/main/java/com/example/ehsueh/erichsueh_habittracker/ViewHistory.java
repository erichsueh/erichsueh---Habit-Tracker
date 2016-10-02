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

import java.util.ArrayList;

public class ViewHistory extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

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
                        Habit anotherhabit =
                                 HabitListController.getHabitList().findHabit(habit.getFinishedhabit());
                        HabitListController.getHabitList().DecreaseCounter(anotherhabit);
                        CompletedHabitListController.getcompHabitList().removeHabit(habit);

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
    public void BackToMain(View view){
        finish();
    }

}
