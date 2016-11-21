package com.example.yuesun.jiayou1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by yuesun on 11/16/16.
 */
public class setting extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }

    public void backClicked(View view){
        Intent menu=new Intent(this, menu.class);
        startActivity(menu);
    }
}
