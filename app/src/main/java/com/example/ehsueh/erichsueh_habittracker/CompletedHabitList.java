package com.example.ehsueh.erichsueh_habittracker;

import java.util.ArrayList;

/**
 * Created by Eric Shay on 2016-10-02.
 * This class is created to be able to Control the completed habits for viewing
 */
public class CompletedHabitList {
    protected ArrayList<CompletedHabits> completedhabitlist;
    protected ArrayList<Listener> listeners;


    public CompletedHabitList(){
        completedhabitlist = new ArrayList<CompletedHabits>();
        listeners = new ArrayList<Listener>();
    }

    public void SetHabitList(ArrayList<CompletedHabits> newlist){
        completedhabitlist = newlist;
    }

    public void AddCompletedHabit(CompletedHabits comphabit){
        completedhabitlist.add(comphabit);
        notifyListeners();
    }

    public void removeHabit(CompletedHabits comphabit){
        completedhabitlist.remove(comphabit);
        notifyListeners();
    }

    public ArrayList<CompletedHabits> getHabitlist() {
        return completedhabitlist;
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
        return completedhabitlist.size();
    }
}
