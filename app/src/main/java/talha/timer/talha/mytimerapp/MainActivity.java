package talha.timer.talha.mytimerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
    public static final String EXTRA_MIN="com.example.talha.mytimerapp.minutes";
    public static final String EXTRA_SEC="com.example.talha.mytimerapp.seconds";
    public static final String EXTRA_MILLI="com.example.talha.mytimerapp.milli";
    public static final String EXTRA_TIME="com.example.talha.mytimerapp.time";
    private EditText editTextmin;
    private EditText editTextsec;
    private EditText editTextmilli;
    private String min;
    private String sec;
    private String milli;

    private TextView timer_initial;
    private NumberPicker minPicker;
    private NumberPicker secPicker;
    private NumberPicker milliPicker;





    String timerinitial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer_initial=(TextView)findViewById(R.id.timerVal);
        timerinitial=timer_initial.getText().toString();
        min="00";
        sec="00";
        milli="00";

        minPicker=(NumberPicker)findViewById(R.id.minPicker);
        minPicker.setMaxValue(59);
        minPicker.setMinValue(0);
        minPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        minPicker.setOnValueChangedListener(this);
        secPicker=(NumberPicker)findViewById(R.id.secPicker);
        secPicker.setMaxValue(59);
        secPicker.setMinValue(0);
        secPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        secPicker.setOnValueChangedListener(this);

        milliPicker=(NumberPicker)findViewById(R.id.milliPicker);
        milliPicker.setMaxValue(59);
        milliPicker.setMinValue(0);
        milliPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        milliPicker.setOnValueChangedListener(this);







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startTimerActivity(View view){


        Intent intent=new Intent(this,TimerActivity.class);



     //   String min=editTextmin.getText().toString();
     //   String sec=editTextsec.getText().toString();
     //   String milli=editTextmilli.getText().toString();
        String min=Integer.toString(minPicker.getValue());
        String sec=Integer.toString(secPicker.getValue());
        String milli=Integer.toString(milliPicker.getValue());

        Log.d("VALUE OF MIN:", min);
        Log.d("VALUE OF SEC:", sec);
        Log.d("VALUE OF MILLI:", milli);

        if(min.matches("0")&&sec.matches("0")&&milli.matches("0")){
            Context context = getApplicationContext();
            CharSequence text = "Please Enter a Timer Value!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {

            intent.putExtra(EXTRA_MIN, min);
            intent.putExtra(EXTRA_SEC, sec);
            intent.putExtra(EXTRA_MILLI, milli);

            long startTime = SystemClock.uptimeMillis();

            // intent.putExtra(EXTRA_TIME,startTime);

            startActivity(intent);
            this.overridePendingTransition(0, 0);

        }
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal){

        if(picker==minPicker){
            min= String.format("%02d", newVal);


            timer_initial.setText(min+":"+sec+":"+milli);
        }
        if(picker==secPicker){
            sec= String.format("%02d", newVal);


            timer_initial.setText(min+":"+sec+":"+milli);

        }
        if(picker==milliPicker){

            milli= String.format("%02d", newVal);


            timer_initial.setText(min+":"+sec+":"+milli);

        }
    }


}
