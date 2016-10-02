package com.example.ehsueh.erichsueh_habittracker;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Eric Shay on 2016-10-01.
 */
public class HabitList {
    //private ArrayList<Habit> Habitlist = new ArrayList<Habit>();
    protected ArrayList<Habit> habitlist;
    protected ArrayList<Listener> listeners;


    public HabitList(){
        habitlist = new ArrayList<Habit>();
        listeners = new ArrayList<Listener>();
    }

    public void AddNewHabit(Habit newhabit){
        habitlist.add(newhabit);
        notifyListeners();
    }

    public void IncreaseCounter(Habit oldhabit){

        oldhabit.IncreaseCompletion();
        notifyListeners();
    }

    public void removeHabit(Habit oldhabit){
        habitlist.remove(oldhabit);
        notifyListeners();
    }

    public ArrayList<Habit> getHabitlist() {
        return habitlist;
    }

    public boolean getCount(int i) {
        return habitlist.size()== i;
    }


    public void notifyListeners(){
        for (Listener listener: listeners){
            listener.update();
        }
    }

    public void addListener(Listener l){
        listeners.add(l);

    }

    public void removeListener(Listener l){
        listeners.remove(l);

    }
}
