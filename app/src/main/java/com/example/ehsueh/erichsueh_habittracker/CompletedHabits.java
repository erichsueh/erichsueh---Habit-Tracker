package com.example.ehsueh.erichsueh_habittracker;

import java.util.Date;

/**
 * Created by Eric Shay on 2016-09-30.
 *
 * This is the completed habits class, for the habits that have been completed, i creat a new "completed habit"
 */
public class CompletedHabits {
    private String finishedhabit;
    private Date date;

    public CompletedHabits(String comphabit){
        finishedhabit = comphabit;
        date = new Date();

    }

    public String getFinishedhabit() {
        return finishedhabit;
    }


    @Override
    public String toString() {
        return "Habit completed on" + date.toString() + "\n" + "Habit that was completed: " + finishedhabit;
    }
}


