package com.example.snowyleung.oven_fresh.Schedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.snowyleung.oven_fresh.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScheduleActivity extends AppCompatActivity {

    private String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        ListView listView = (ListView) findViewById(R.id.schedule);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1);
        listView.setAdapter(adapter);

        DatabaseReference reference_breads = FirebaseDatabase.getInstance().getReference("bread");
        reference_breads.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren() ){
                    item = "Bread: ".concat(ds.child("Name").getValue().toString()).concat("      ").concat("Time: ").concat(ds.child("Time").getValue().toString());
                    adapter.add(item);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }

}
