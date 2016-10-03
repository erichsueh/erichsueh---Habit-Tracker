package com.example.ehsueh.erichsueh_habittracker;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Eric Shay on 2016-10-03.
 */
public class HabitTester extends TestCase {
    public void testHabit(){
        String habitname = "Durr";
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        Habit habit = new Habit(habitname,days);
        assertTrue(habitname == habit.getMessage());
    }

    public void testIncComp(){
        String habitname = "Durr";
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        Habit habit = new Habit(habitname,days);

        assertTrue(habit.getTimescompleted() == 0);
        habit.IncreaseCompletion();
        assertTrue(habit.getTimescompleted() == 1);
        habit.DecreaseCompletion();
        assertTrue(habit.getTimescompleted() == 0);
    }

}
