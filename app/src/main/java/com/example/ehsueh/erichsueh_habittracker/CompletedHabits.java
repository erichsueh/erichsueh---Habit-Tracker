package com.example.ehsueh.erichsueh_habittracker;

import java.util.Date;

/**
 * Created by Eric Shay on 2016-09-30.
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

    public Date getDate() {
        return date;
    }
}
