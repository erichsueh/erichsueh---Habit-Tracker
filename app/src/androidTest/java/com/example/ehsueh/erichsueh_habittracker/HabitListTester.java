package com.example.ehsueh.erichsueh_habittracker;

import com.example.ehsueh.erichsueh_habittracker.Habit;
import com.example.ehsueh.erichsueh_habittracker.HabitList;
import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Eric Shay on 2016-10-01.
 */
public class HabitListTester  extends TestCase{


    public void testHabitListAddnRemove(){
        HabitList newlist = new HabitList();
        String habitname = "Durr";
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        Habit habit = new Habit(habitname,days);

        newlist.AddNewHabit(habit);
        assertTrue(newlist.getSize()== 1);
        newlist.removeHabit(habit);
        assertTrue(newlist.getSize() == 0);
    }

    public void testCounters(){
        String habitname = "Durr";
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        Habit habit = new Habit(habitname,days);

        HabitList newlist = new HabitList();
        newlist.AddNewHabit(habit);
        newlist.IncreaseCounter(habit);
        assertTrue(habit.getTimescompleted() == 1);
        newlist.DecreaseCounter(habit);
        assertTrue(habit.getTimescompleted()==0);

    }

    public void testfindHabit(){
        String habitname = "Durr";
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        Habit habit = new Habit(habitname,days);

        HabitList newlist = new HabitList();
        newlist.AddNewHabit(habit);
        Habit anotherhabit = newlist.findHabit(habitname);
        assertTrue(anotherhabit == habit);
    }

    public void testhabitlistsetandget(){
        ArrayList<Habit> hablist = new ArrayList<Habit>();
        HabitList newlist = new HabitList();
        newlist.SetHabitList(hablist);
        assertTrue(hablist == newlist.getHabitlist());
    }

}
