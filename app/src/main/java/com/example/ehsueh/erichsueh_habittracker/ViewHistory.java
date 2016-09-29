package com.example.ehsueh.erichsueh_habittracker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class ViewHistory extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);


    }
    public void BackToMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
