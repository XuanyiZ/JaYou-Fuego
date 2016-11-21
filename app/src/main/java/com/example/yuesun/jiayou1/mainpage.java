package com.example.yuesun.jiayou1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
    }

    public void countdown(View view){
        Intent clock=new Intent(this, clock.class);
        startActivity(clock);
    }

    public void menuClicked(View view){
        Intent menu=new Intent(this, menu.class);
        startActivity(menu);
    }

}
