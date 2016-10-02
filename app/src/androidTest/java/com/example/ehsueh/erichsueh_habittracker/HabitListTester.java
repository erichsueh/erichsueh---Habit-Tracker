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
    public void testHabit(){
        String habitname = "Durr";
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        Habit habit = new Habit(habitname,days);
        //assertTrue(habitname == habit.getMessage());
        assertTrue("Monday Tuesday" == habit.getDays());
    }

    /**public void testHabitList(){
        Habit newhabit = new Habit("ehfosihfo");
        HabitList habitlist = new HabitList();
        assertTrue(habitlist.getCount(0));
        habitlist.AddNewHabit(newhabit);
        assertTrue(habitlist.getCount(1));
        int[] mArray = new int[]{0,0,0,0,1};



    }*/


}
