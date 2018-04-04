package com.example.yangchunghsuan.clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editText_hour;
    EditText editText_minute;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_hour = findViewById(R.id.editTextHour);
        editText_minute = findViewById(R.id.editTextMinute);

        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Clock.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this,1,intent,0);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);



    }


    public void fn_setClock(View v){



        Toast.makeText(MainActivity.this,"鬧鐘設定完成",Toast.LENGTH_SHORT).show();
    }
}
