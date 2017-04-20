package com.example.snowyleung.oven_fresh.alarm;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snowyleung.oven_fresh.R;
import com.example.snowyleung.oven_fresh.alarm.data.DatabaseDescription.Alarm;

public class AlarmFragment extends Fragment
   implements LoaderManager.LoaderCallbacks<Cursor>{

   public interface AlarmFragmentListener {
      void onAlarmSelected(Uri alarmUri);

      void onAddAlarm();
   }

   private static final int ALARM_LOADER = 0;

   private AlarmFragmentListener listener;

   private AlarmAdapter alarmAdapter;

   @Override
   public View onCreateView(
           LayoutInflater inflater, ViewGroup container,
           Bundle savedInstanceState) {
      super.onCreateView(inflater, container, savedInstanceState);
      setHasOptionsMenu(true);

      View view = inflater.inflate(
         R.layout.fragment_alarm_list, container, false);
      RecyclerView recyclerView =
         (RecyclerView) view.findViewById(R.id.recyclerView);

      recyclerView.setLayoutManager(
         new LinearLayoutManager(getActivity().getBaseContext()));

      alarmAdapter = new AlarmAdapter(
         new AlarmAdapter.AlarmClickListener() {
            @Override
            public void onClick(Uri alarmUri) {
               listener.onAlarmSelected(alarmUri);
            }
         }
      );
      recyclerView.setAdapter(alarmAdapter);

      recyclerView.addItemDecoration(new ItemDivider(getContext()));

      recyclerView.setHasFixedSize(true);

      FloatingActionButton addButton =
              (FloatingActionButton) view.findViewById(R.id.btnAddAlarm);
      addButton.setOnClickListener(
              new View.OnClickListener() {
                 // displays the AddEditFragment when FAB is touched
                 @Override
                 public void onClick(View view) {
                    listener.onAddAlarm();
                 }
              }
      );

      return view;
   }

   @Override
   public void onAttach(Context context) {
      super.onAttach(context);
      listener = (AlarmFragmentListener) context;
   }

   @Override
   public void onDetach() {
      super.onDetach();
      listener = null;
   }

   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      getLoaderManager().initLoader(ALARM_LOADER, null, this);
   }

   public void updateAlarmList() {
      alarmAdapter.notifyDataSetChanged();
   }

   @Override
   public Loader<Cursor> onCreateLoader(int id, Bundle args) {
      switch (id) {
         case ALARM_LOADER:
            return new CursorLoader(getActivity(),
               Alarm.CONTENT_URI,
               null,
               null,
               null,
               Alarm.COLUMN_NAME + " COLLATE NOCASE ASC"); // sort order
         default:
            return null;
      }
   }

   @Override
   public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
      alarmAdapter.swapCursor(data);
   }

   @Override
   public void onLoaderReset(Loader<Cursor> loader) {
      alarmAdapter.swapCursor(null);
   }
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
