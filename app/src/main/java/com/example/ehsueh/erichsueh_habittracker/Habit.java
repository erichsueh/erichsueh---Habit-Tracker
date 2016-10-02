package com.example.ehsueh.erichsueh_habittracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Eric Shay on 2016-09-28.
 */
public class Habit {
    private String message;
    private Date date;
    private String daysoftheweek;
    private Integer timescompleted;

    public Habit(String newmessage, ArrayList<String> dayotweek){
        message = newmessage;

        //StringBuilder Method from
        // stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
        String days = "";
        for (String s : dayotweek) {
            days = days + s + " ";
        }


        daysoftheweek = days;
        date = new Date();
        timescompleted = 0;
    }

    public void IncreaseCompletion(){
        timescompleted = 1 + timescompleted;
    }

    @Override
    public String toString(){
        return  date.toString() +
                "\n"+ "Habit: " + message +
                "\n" + "Times Completed: " + timescompleted+
                "\n"  + "Days:" + daysoftheweek;
    }

    public String getMessage() {
        return message;
    }

    public String getDays(){
        return daysoftheweek;
    }

    public void DecreaseCompletion() { timescompleted = timescompleted -1;
    }
}
