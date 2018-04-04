package com.example.yangchunghsuan.clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by yangchunghsuan on 2018/4/4.
 */

public class Clock extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Time's up go to sleep!!!",Toast.LENGTH_SHORT).show();
    }

}
