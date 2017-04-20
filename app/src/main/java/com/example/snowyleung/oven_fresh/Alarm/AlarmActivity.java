package com.example.snowyleung.oven_fresh.Alarm;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.snowyleung.oven_fresh.R;

public class AlarmActivity extends AppCompatActivity
        implements AlarmFragment.AlarmFragmentListener,
        AddEditFragment.AddEditFragmentListener{

    public static final String ALARM_URI = "alarm_uri";

    private AlarmFragment alarmFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        if (savedInstanceState == null &&
                findViewById(R.id.fragmentContainer) != null) {
            alarmFragment = new AlarmFragment();

            FragmentTransaction transaction =
                    getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentContainer, alarmFragment);
            transaction.commit();
        }
        else {
            alarmFragment =
                    (AlarmFragment) getSupportFragmentManager().
                            findFragmentById(R.id.alarmFragment);
        }
    }

    @Override
    public void onAlarmSelected(Uri alarmUri) {
        if (findViewById(R.id.fragmentContainer) != null)
            displayAddEditFragment(R.id.fragmentContainer, alarmUri);
        else {
            getSupportFragmentManager().popBackStack();

            displayAddEditFragment(R.id.rightPaneContainer, alarmUri);
        }
    }

    @Override
    public void onAddAlarm() {
        if (findViewById(R.id.fragmentContainer) != null) // phone
            displayAddEditFragment(R.id.fragmentContainer, null);
        else
            displayAddEditFragment(R.id.rightPaneContainer, null);
    }

    private void displayAddEditFragment(int viewID, Uri alarmUri) {
        AddEditFragment addEditFragment = new AddEditFragment();

        if (alarmUri != null) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(ALARM_URI, alarmUri);
            addEditFragment.setArguments(arguments);
        }

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(viewID, addEditFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onAddEditCompleted(Uri alarmUri) {
        getSupportFragmentManager().popBackStack();
        alarmFragment.updateAlarmList(); // refresh contacts

        if (findViewById(R.id.fragmentContainer) == null) { // tablet
            getSupportFragmentManager().popBackStack();

            displayAddEditFragment(R.id.rightPaneContainer, alarmUri);
        }
    }
}
