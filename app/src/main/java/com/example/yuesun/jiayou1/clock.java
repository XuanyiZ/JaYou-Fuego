package com.example.yuesun.jiayou1;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by yuesun on 11/16/16.
 */
public class clock extends AppCompatActivity{
    ImageButton plane;
    ImageButton stop;
    ImageButton back;
    ProgressBar workbar;
    ProgressBar breakbar;
    ProgressBar longbar;
    TextView timestxt;
    TextView error;
    int work=6;
    int mbreak=2;
    int mlong=12;
    int times=3;
    MyCountDownTimer myCountDownTimer;
    boolean pause;
    boolean stoped;
    long future;
    long total=((work+mbreak)*times+mlong)*1000;
    int countdowninterval=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdownpage);

        workbar=(ProgressBar) findViewById(R.id.workBar);
        breakbar=(ProgressBar) findViewById(R.id.breakBar);
        longbar=(ProgressBar) findViewById(R.id.longBar);

        timestxt=(TextView) findViewById(R.id.times);
        error=(TextView) findViewById(R.id.error);

        plane=(ImageButton) findViewById(R.id.plane);
        stop=(ImageButton) findViewById(R.id.stop);
        back=(ImageButton) findViewById(R.id.menu);

        myCountDownTimer=new MyCountDownTimer(total, countdowninterval);
        pause=false;
        stoped=false;
        future=total;
        error.setText("");
        myCountDownTimer.start();

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stoped=true;
                myCountDownTimer.cancel();
                myCountDownTimer=null;
                error.setText("countdown stopped");
            }
        });

        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stoped){
                    myCountDownTimer=new MyCountDownTimer(total, countdowninterval);
                    myCountDownTimer.start();
                    stoped=false;
                    error.setText("countdown start new");
                }
                else {
                    if (!pause){
                        myCountDownTimer.pause();
                        if (future!=total){
                            myCountDownTimer=null;
                        }
                        pause=true;
                        error.setText("countdown paused");
                    }
                    else {
                        myCountDownTimer=new MyCountDownTimer(future, countdowninterval);
                        myCountDownTimer.start();
                        pause=false;
                        error.setText("countdown resumed");
                    }
                }
            }
        });


    }

    public class MyCountDownTimer extends CountDownTimer{
        private boolean pause;

        public MyCountDownTimer(long millisInFuture, long countDownInterval){
            super(millisInFuture, countDownInterval);
            pause=false;
            if(millisInFuture==total){
                workbar.setProgress(0);
                breakbar.setProgress(2);
                longbar.setProgress(12);
                timestxt.setText("* "+times);
            }
        }

        public void pause(){
            pause=true;
        }

        @Override
        public void onTick(long millisUntilFinished){
            if (pause){
                future=millisUntilFinished;
                this.cancel();
            }
            int re_sec=(int) (millisUntilFinished/1000);
            if (re_sec<mlong){
                longbar.setProgress(mlong-re_sec+1);
                timestxt.setText("* 0");
            }
            else {
                int past=(int) ((total-millisUntilFinished)/1000);
                int pasttimes = past/(work+mbreak);
                timestxt.setText("* "+(times-pasttimes));
                int remainder=past % (work+mbreak);
                if (remainder<work){
                    workbar.setProgress(remainder+1);
                }
                else {
                    breakbar.setProgress(remainder-work+1);
                }
            }
        }

        @Override
        public void onFinish(){
            this.cancel();
            stoped=true;
            error.setText("Congratulations!!");
        }

    }

    public void menuClicked(View view){
        Intent menu=new Intent(this, menu.class);
        startActivity(menu);
    }
}
