package com.example.ehsueh.erichsueh_habittracker;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Eric Shay on 2016-10-03.
 */
public class CompletedListTest extends TestCase {
    public void testhabitlistsetandget(){
        ArrayList<CompletedHabits> hablist = new ArrayList<CompletedHabits>();
        CompletedHabitList newlist = new CompletedHabitList();
        newlist.SetHabitList(hablist);
        assertTrue(hablist == newlist.getHabitlist());
    }

    public void testHabitListAddnRemove(){
        CompletedHabitList newlist = new CompletedHabitList();
        String habitname = "Durr";
        CompletedHabits habit = new CompletedHabits(habitname);

        newlist.AddCompletedHabit(habit);
        assertTrue(newlist.getSize()== 1);
        newlist.removeHabit(habit);
        assertTrue(newlist.getSize() == 0);
    }
}
