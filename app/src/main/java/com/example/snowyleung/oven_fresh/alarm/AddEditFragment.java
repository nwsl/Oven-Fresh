// AddEditFragment.java
// Fragment for adding a new contact or editing an existing one
package com.example.snowyleung.oven_fresh.alarm;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.snowyleung.oven_fresh.R;
import com.example.snowyleung.oven_fresh.alarm.data.DatabaseDescription.Alarm;

import java.util.Calendar;
import java.util.Date;

import static android.R.color.background_dark;

public class AddEditFragment extends Fragment
   implements LoaderManager.LoaderCallbacks<Cursor> {

   public interface AddEditFragmentListener {
      void onAddEditCompleted(Uri alarmUri);

       void onAlarmDelete();
   }

    private static final int ALARM_LOADER = 0;

    private AddEditFragmentListener listener; // MainActivity
    private Uri alarmUri; // Uri of selected contact
    private boolean addingNewAlarm = true; // adding (true) or editing

    private EditText breadTextInput;
    private Button btnSetAlarm;
    private Button btnTimeFormat;
    private Button btnCancelAlarmSetting;
    private TimePicker timePicker;
    private PendingIntent pendingIntent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddEditFragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        View view =
            inflater.inflate(R.layout.fragment_alarm_setting, container, false);

        timePicker = (TimePicker) view.findViewById(R.id.clock);

        breadTextInput = (EditText) view.findViewById(R.id.bread);

        btnSetAlarm = (Button) view.findViewById(
            R.id.btnSetAlarm);
        btnSetAlarm.setOnClickListener(setAlarmButtonClicked);

        Bundle arguments = getArguments(); // null if creating new contact

        if (arguments != null) {
            addingNewAlarm = false;
            alarmUri = arguments.getParcelable(AlarmActivity.ALARM_URI);
        }

        // if editing an existing contact, create Loader to get the contact
        if (alarmUri != null)
            getLoaderManager().initLoader(ALARM_LOADER, null, this);

        btnTimeFormat = (Button) view.findViewById(R.id.btnTimeFormat);

        btnTimeFormat.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setIs24HourView(!timePicker.is24HourView());
                if (!timePicker.is24HourView()){
                    timePicker.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
                }
            }
        });

        breadTextInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                breadTextInput.setText("");
                breadTextInput.setTextColor(Color.parseColor("black"));
            }
        });

        btnCancelAlarmSetting = (Button) view.findViewById(R.id.btnCancelAlarmSetting);
        btnCancelAlarmSetting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getActivity().onBackPressed();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_addedit_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getActivity());

                builder.setTitle(R.string.confirm_title);
                builder.setMessage(R.string.confirm_message);

                // provide an OK button that simply dismisses the dialog
                builder.setPositiveButton(R.string.button_delete,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(
                                    DialogInterface dialog, int button) {

                                // use Activity's ContentResolver to invoke
                                // delete on the AddressBookContentProvider
                                getActivity().getContentResolver().delete(
                                        alarmUri, null, null);
                                listener.onAlarmDelete();
                                dialog.dismiss();
                            }
                        }
                );

                builder.setNegativeButton(R.string.button_cancel, null);

                builder.show();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // responds to event generated when user saves a contact
    private final View.OnClickListener setAlarmButtonClicked =
        new View.OnClickListener() {
         @Override
         public void onClick(View v) {
                // hide the virtual keyboard
                ((InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                getView().getWindowToken(), 0);
                setAlarm(); // save contact to the database
           }
      };

    // saves contact information to the database
    private void setAlarm() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Alarm.COLUMN_NAME,
            breadTextInput.getText().toString());

        if (addingNewAlarm) {
            Uri newAlarmUri = getActivity().getContentResolver().insert(
                Alarm.CONTENT_URI, contentValues);

         if (newAlarmUri != null) {
            listener.onAddEditCompleted(newAlarmUri);
         }
         else {
            Toast.makeText(getActivity().getApplicationContext(), "The Alarm is not set due to error", Toast.LENGTH_SHORT).show();
         }
      }
      else {
         int updatedRows = getActivity().getContentResolver().update(
            alarmUri, contentValues, null, null);

         if (updatedRows > 0) {
            listener.onAddEditCompleted(alarmUri);
            Toast.makeText(getActivity().getApplicationContext(), "Alarm is set", Toast.LENGTH_SHORT).show();
         }
         else {
            Toast.makeText(getActivity().getApplicationContext(), "The Alarm is not updated due to error", Toast.LENGTH_SHORT).show();
         }
      }

        AlarmManager manager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        Calendar cal_alarm = Calendar.getInstance();
        cal_alarm.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        cal_alarm.set(Calendar.MINUTE, timePicker.getCurrentHour());
        cal_alarm.set(Calendar.SECOND, 0);

        Intent myIntent = new Intent(getActivity().getApplicationContext(), AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(getActivity().getApplicationContext(), 0, myIntent, 0);

        manager.set(AlarmManager.RTC_WAKEUP,cal_alarm.getTimeInMillis(), pendingIntent);
   }

   @Override
   public Loader<Cursor> onCreateLoader(int id, Bundle args) {
      switch (id) {
         case ALARM_LOADER:
            return new CursorLoader(getActivity(),
               alarmUri,
               null,
               null,
               null,
               null);
         default:
            return null;
      }
   }

   @Override
   public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
      if (data != null && data.moveToFirst()) {
         int nameIndex = data.getColumnIndex(Alarm.COLUMN_NAME);

         breadTextInput.setText(
            data.getString(nameIndex));
      }
   }

   @Override
   public void onLoaderReset(Loader<Cursor> loader) { }

}


/**************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/
