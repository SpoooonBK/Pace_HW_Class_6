package nyc.esteban.pace_hw_class_6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class Activity_2 extends Activity {
    TextView textView;
    LinearLayout linearLayout;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_2);
        Log.d(Activity_1.TAG,"Activity2 created");

        textView = (TextView)findViewById(R.id.activity2_TextView);
        linearLayout = (LinearLayout) findViewById(R.id.layout_2);

        //Clicking this button changes the background to a random color and counts
        ImageButton button_Execute = (ImageButton)findViewById(R.id.button_execute);
        button_Execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Activity_1.TAG, "Execute clicked!");
                changeBackgroundColor(linearLayout);
                changeTextViewCounter(textView);
            }
        });

        //Clicking this button starts a timer which changes the bg and counts
        ImageButton button_Timer = (ImageButton)findViewById(R.id.button_timer);
        button_Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Activity_1.TAG, "Timer clicked!");

                Timer timer = new Timer();
                timer.schedule(new MyTimerTask(), 500, 5 * 1000);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyTimerTask extends TimerTask{
        @Override
        public void run() {

            changeBackgroundColor(linearLayout);
            changeTextViewCounter(textView);

        }
    }
    public void changeBackgroundColor (LinearLayout linearLayout){
        int color = RandomColorGenerator.getRandomColor();
        Log.d(Activity_1.TAG,"Random Color " + color);
        linearLayout.setBackgroundColor(color);
        Log.d(Activity_1.TAG,"Color changed!");
    }

    public void changeTextViewCounter(TextView textView){
        textView.setText("" + ++counter);
        Log.d(Activity_1.TAG, "Times color change executed: " + counter);
    }
}
