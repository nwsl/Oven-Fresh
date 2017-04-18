// AddEditFragment.java
// Fragment for adding a new contact or editing an existing one
package com.example.snowyleung.oven_fresh.Alarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.snowyleung.oven_fresh.R;
import com.example.snowyleung.oven_fresh.Alarm.data.DatabaseDescription.Alarm;

import java.util.Calendar;

public class AddEditFragment extends Fragment
   implements LoaderManager.LoaderCallbacks<Cursor> {

   // defines callback method implemented by MainActivity
   public interface AddEditFragmentListener {
      // called when contact is saved
      void onAddEditCompleted(Uri contactUri);
   }

   // constant used to identify the Loader
    private static final int ALARM_LOADER = 0;

    private AddEditFragmentListener listener; // MainActivity
    private Uri alarmUri; // Uri of selected contact
    private boolean addingNewAlarm = true; // adding (true) or editing

    // EditTexts for contact information
    private EditText breadTextInput;
    private Button btnSetAlarm;
    private Button btnTimeFormat;
    private Button btnCancelAlarmSetting;
    private TimePicker timePicker;

    private CoordinatorLayout coordinatorLayout; // used with SnackBars

    // set AddEditFragmentListener when Fragment attached
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddEditFragmentListener) context;
    }

    // remove AddEditFragmentListener when Fragment detached
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    // called when Fragment's view needs to be created
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // inflate GUI and get references to EditTexts
        View view =
            inflater.inflate(R.layout.fragment_alarm_setting, container, false);

        timePicker = (TimePicker) view.findViewById(R.id.clock);

        // set FloatingActionButton's event listener
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

        btnCancelAlarmSetting.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                getActivity().finish();
            }
        });

        return view;
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
        // create ContentValues object containing contact's key-value pairs
        ContentValues contentValues = new ContentValues();
        contentValues.put(Alarm.COLUMN_NAME,
            breadTextInput.getText().toString());

        if (addingNewAlarm) {
            // use Activity's ContentResolver to invoke
            // insert on the AlarmContentProvider
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
         // use Activity's ContentResolver to invoke
         // insert on the AlarmContentProvider
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
   }

   // called by LoaderManager to create a Loader
   @Override
   public Loader<Cursor> onCreateLoader(int id, Bundle args) {
      // create an appropriate CursorLoader based on the id argument;
      // only one Loader in this fragment, so the switch is unnecessary
      switch (id) {
         case ALARM_LOADER:
            return new CursorLoader(getActivity(),
               alarmUri, // Uri of contact to display
               null, // null projection returns all columns
               null, // null selection returns all rows
               null, // no selection arguments
               null); // sort order
         default:
            return null;
      }
   }

   // called by LoaderManager when loading completes
   @Override
   public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
      // if the contact exists in the database, display its data
      if (data != null && data.moveToFirst()) {
         // get the column index for each data item
         int nameIndex = data.getColumnIndex(Alarm.COLUMN_NAME);

         // fill EditTexts with the retrieved data
         breadTextInput.setText(
            data.getString(nameIndex));
      }
   }

   // called by LoaderManager when the Loader is being reset
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
