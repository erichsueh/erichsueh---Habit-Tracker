package com.example.ehsueh.erichsueh_habittracker;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Eric Shay on 2016-10-03.
 */
public class CompletedHabitTest extends TestCase {
    public void testHabit(){
        String habitname = "Durr";
        CompletedHabits habit = new CompletedHabits(habitname);
        assertTrue(habitname == habit.getFinishedhabit());
    }


}
