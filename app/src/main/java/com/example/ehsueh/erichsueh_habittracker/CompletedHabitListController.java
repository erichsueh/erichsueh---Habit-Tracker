package com.example.ehsueh.erichsueh_habittracker;

/**
 * Created by Eric Shay on 2016-10-02.
 *
 * This code is modeled after Student Pick in android
 * (your saga thing)
 * This is the Completed Habit List Controller made so I can access the old completed habits from anywhere
 */
public class CompletedHabitListController {

    private static CompletedHabitList comphabitList = null;
    static public CompletedHabitList getcompHabitList(){
        if(comphabitList ==null){
            comphabitList = new CompletedHabitList();
        }
        return comphabitList;
    }

    public CompletedHabitList getComphabitlist(){
        return getcompHabitList();
    }


    public void addHabit(CompletedHabits habit){ getcompHabitList().AddCompletedHabit(habit);
    }
}
