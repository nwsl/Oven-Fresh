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

    private AlarmFragment alarmFragment; // displays contact list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        if (savedInstanceState == null &&
                findViewById(R.id.fragmentContainer) != null) {
            // create ScheduleFragment
            alarmFragment = new AlarmFragment();

            // add the fragment to the FrameLayout
            FragmentTransaction transaction =
                    getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentContainer, alarmFragment);
            transaction.commit(); // display ScheduleFragment
        }
        else {
            alarmFragment =
                    (AlarmFragment) getSupportFragmentManager().
                            findFragmentById(R.id.alarmFragment);
        }
    }

    @Override
    public void onAlarmSelected(Uri alarmUri) {
        if (findViewById(R.id.fragmentContainer) != null) // phone
            displayAddEditFragment(R.id.fragmentContainer, alarmUri);
        else { // tablet
            // removes top of back stack
            getSupportFragmentManager().popBackStack();

            displayAddEditFragment(R.id.rightPaneContainer, alarmUri);
        }
    }

    @Override
    public void onAddAlarm() {
        if (findViewById(R.id.fragmentContainer) != null) // phone
            displayAddEditFragment(R.id.fragmentContainer, null);
        else // tablet
            displayAddEditFragment(R.id.rightPaneContainer, null);
    }

    private void displayAddEditFragment(int viewID, Uri alarmUri) {
        AddEditFragment addEditFragment = new AddEditFragment();

        // if editing existing contact, provide contactUri as an argument
        if (alarmUri != null) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(ALARM_URI, alarmUri);
            addEditFragment.setArguments(arguments);
        }

        // use a FragmentTransaction to display the AddEditFragment
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(viewID, addEditFragment);
        transaction.addToBackStack(null);
        transaction.commit(); // causes AddEditFragment to display
    }

    @Override
    public void onAddEditCompleted(Uri alarmUri) {
        // removes top of back stack
        getSupportFragmentManager().popBackStack();
        alarmFragment.updateAlarmList(); // refresh contacts

        if (findViewById(R.id.fragmentContainer) == null) { // tablet
            // removes top of back stack
            getSupportFragmentManager().popBackStack();

            // on tablet, display contact that was just added or edited
            displayAddEditFragment(R.id.rightPaneContainer, alarmUri);
        }
    }
}
