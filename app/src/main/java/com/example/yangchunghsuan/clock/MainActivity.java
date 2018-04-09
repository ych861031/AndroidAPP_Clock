package com.example.yangchunghsuan.clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    EditText editText_hour;
    EditText editText_minute;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    TextView textView_setview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_hour = findViewById(R.id.editTextHour);
        editText_minute = findViewById(R.id.editTextMinute);
        textView_setview = findViewById(R.id.textView_settime);

        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Clock.class);

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this,1,intent,0);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }


    public void fn_setClock(View v){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());

        //設定觸發時間
        c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(editText_hour.getText().toString()));
        c.set(Calendar.MINUTE, Integer.parseInt(editText_minute.getText().toString()));
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);


        //設定alarmManger模式
        alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis()-500,pendingIntent);

        Toast.makeText(MainActivity.this,"鬧鐘設定完成",Toast.LENGTH_SHORT).show();
        textView_setview.setText("鬧鐘設定時間:"+editText_hour.getText().toString()+":"+editText_minute.getText().toString());
    }
}
