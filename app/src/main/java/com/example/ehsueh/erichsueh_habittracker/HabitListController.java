package com.example.ehsueh.erichsueh_habittracker;

/**
 * Created by Eric Shay on 2016-10-01.
 */
public class HabitListController {

    private static HabitList habitList = null;
    static public HabitList getHabitList(){
        if(habitList ==null){
            habitList = new HabitList();
        }
        return habitList;
    }

    public HabitList gethabitlist(){
        return getHabitList();
    }


    public void addHabit(Habit habit){
        getHabitList().AddNewHabit(habit);
    }
}
