package com.example.yuesun.jiayou1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
    public void backClicked(View view){
        Intent menu=new Intent(this, menu.class);
        startActivity(menu);
    }
    public void logIn(View view){
        Intent user=new Intent(this, user.class);
        startActivity(user);
    }
}
