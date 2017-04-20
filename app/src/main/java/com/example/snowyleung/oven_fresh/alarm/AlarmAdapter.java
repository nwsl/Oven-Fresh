// AlarmAdapter.java
// Subclass of RecyclerView.Adapter that binds alarm to RecyclerView
package com.example.snowyleung.oven_fresh.alarm;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snowyleung.oven_fresh.alarm.data.DatabaseDescription.Alarm;

public class   AlarmAdapter
   extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {

   public interface AlarmClickListener {
      void onClick(Uri alarmUri);
   }

   public class ViewHolder extends RecyclerView.ViewHolder {
      public final TextView textView;
      private long rowID;

      public ViewHolder(View itemView) {
         super(itemView);
         textView = (TextView) itemView.findViewById(android.R.id.text1);

         itemView.setOnClickListener(
            new View.OnClickListener() {
               // executes when the contact in this ViewHolder is clicked
               @Override
               public void onClick(View view) {
                  clickListener.onClick(Alarm.buildAlarmUri(rowID));
               }
            }
         );
      }

      public void setRowID(long rowID) {
         this.rowID = rowID;
      }
   }

   private Cursor cursor = null;
   private final AlarmClickListener clickListener;

   public AlarmAdapter(AlarmClickListener clickListener) {
      this.clickListener = clickListener;
   }

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(
         android.R.layout.simple_list_item_1, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(ViewHolder holder, int position) {
      cursor.moveToPosition(position);
      holder.setRowID(cursor.getLong(cursor.getColumnIndex(Alarm._ID)));
      holder.textView.setText(cursor.getString(cursor.getColumnIndex(
         Alarm.COLUMN_NAME)));
   }

   @Override
   public int getItemCount() {
      return (cursor != null) ? cursor.getCount() : 0;
   }

   public void swapCursor(Cursor cursor) {
      this.cursor = cursor;
      notifyDataSetChanged();
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
