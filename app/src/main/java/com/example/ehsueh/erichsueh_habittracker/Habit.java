package com.example.ehsueh.erichsueh_habittracker;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Eric Shay on 2016-09-28.
 */
public class Habit {
    private String message;
    private Date date;
    private ArrayList arrayList;
    private Integer timescompleted;

    public Habit(String newmessage, ArrayList dayotweek){
        message = newmessage;
        arrayList = dayotweek;
        date = new Date();
        timescompleted = 0;
    }

    public void Edithabit(String newmessage, ArrayList dayotweek){
        message = newmessage;
        arrayList = dayotweek;
    }

    public void IncreaseCompletion(){
        timescompleted = 1 + timescompleted;
    }

}
