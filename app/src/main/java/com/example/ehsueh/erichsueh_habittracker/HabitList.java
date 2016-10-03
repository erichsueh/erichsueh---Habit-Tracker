package com.example.ehsueh.erichsueh_habittracker;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Eric Shay on 2016-10-01.
 *
 * This is the habit list methods
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

    public void SetHabitList(ArrayList<Habit> newlist){
        habitlist = newlist;
    }

    public void IncreaseCounter(Habit oldhabit){

        oldhabit.IncreaseCompletion();
        notifyListeners();
    }

    public void DecreaseCounter(Habit oldhabit){
        oldhabit.DecreaseCompletion();
        notifyListeners();
    }

    public void removeHabit(Habit oldhabit){
        habitlist.remove(oldhabit);
        notifyListeners();
    }

    public Habit findHabit(String habitmessage){
        for( Habit habit : habitlist){
            if (habit.getMessage() == habitmessage){
                return habit;
            }
        }
        return null;
    }

    public ArrayList<Habit> getHabitlist() {
        return habitlist;
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

    public int getSize() {
        return habitlist.size();
    }
}
