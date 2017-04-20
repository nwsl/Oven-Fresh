package com.example.snowyleung.oven_fresh.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SnowyLeung on 20/4/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Alarming!!!!!!", Toast.LENGTH_LONG).show();
    }

}
