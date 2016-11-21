package com.example.yuesun.jiayou1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by yuesun on 11/16/16.
 */
public class menu extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void mainClicked(View view){
        Intent main=new Intent(this, mainpage.class);
        startActivity(main);
    }

    public void playClicked(View view) {
        Intent play = new Intent(this, play.class);
        startActivity(play);
    }

    public void settingClicked(View view){
        Intent setting=new Intent(this, setting.class);
        startActivity(setting);
    }

    public void pieClicked(View view){
        Intent clock=new Intent(this, clock.class);
        startActivity(clock);
    }

    public void userClicked(View view){
        Intent user=new Intent(this, user.class);
        startActivity(user);
    }
}
