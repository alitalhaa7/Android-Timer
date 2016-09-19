package talha.timer.talha.mytimerapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    private Handler customHandler=new Handler();
    TextView timerVal;
    private long time=0L;
    MyCountDownTimer countdownTimer;
    private long startTime=0L;
    TimerDraw Circle;
    TimerAnimation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        timerVal=(TextView)findViewById(R.id.timerVal);
         Circle = (TimerDraw) findViewById(R.id.view);

        animation = new TimerAnimation(Circle, 360);
    Intent intent=getIntent();

        String minsmessage=intent.getStringExtra(MainActivity.EXTRA_MIN);
        String secsmessage=intent.getStringExtra(MainActivity.EXTRA_SEC);
        String millismessage=intent.getStringExtra(MainActivity.EXTRA_MILLI);

        int mins=0;
        int secs=0;
        int milliseconds=0;
        if(minsmessage.matches("")){
    mins=0;
}else {
            mins = Integer.parseInt(minsmessage);
}

        if(secsmessage.matches("")){
            secs=0;
        }else {
            secs = Integer.parseInt(secsmessage);
        }

        if(millismessage.matches("")){
            milliseconds=0;
        }else {
            milliseconds = Integer.parseInt(millismessage);
        }





        time=(mins*3600000)+(secs*60000)+(milliseconds*1000);
        //TextView textView=new TextView(this);

        timerVal.setText("" + String.format("%02d", mins) + ":"
                + String.format("%02d", secs) + ":"
                + String.format("%02d", milliseconds));






    }



public void startTimer(View view){
    countdownTimer=new MyCountDownTimer(time,1);

    animation.setDuration(time);
    Circle.startAnimation(animation);
    countdownTimer.start();


    }
    public void pauseTimer(View view){
    if(countdownTimer!=null) {
        countdownTimer.cancel();
    }
    }
    public void stopTimer(View view){
        super.onBackPressed();
        this.overridePendingTransition(0, 0);


    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            timerVal.setText("Time's up!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timerVal.setText(""+String.format("%02d",millisUntilFinished / 3600000)+":"+ String.format("%02d",(millisUntilFinished%3600000)/60000)+":"+String.format("%02d",(millisUntilFinished%60000)/1000));
            time=millisUntilFinished;
        }
    }
//            timerVal.setText("" + String.format("%02d",millisUntilFinished / 60000)+":"+String.format("%02d",(millisUntilFinished%60000)/1000)+":"+String.format("%03d",(millisUntilFinished%60000)%1000));





}
