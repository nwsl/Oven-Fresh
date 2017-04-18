package com.example.snowyleung.oven_fresh.Schedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.snowyleung.oven_fresh.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {

    private String item;
    private ArrayList<Bread> list = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        DatabaseReference reference_breads = FirebaseDatabase.getInstance().getReference("bread");
        reference_breads.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                recyclerView = (RecyclerView) findViewById(R.id.schedule2);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ScheduleActivity.this));

                BreadAdapter adapter = new BreadAdapter(list);
                recyclerView.setAdapter(adapter);

                for (DataSnapshot ds : dataSnapshot.getChildren() ){
                    Bread bread = ds.getValue(Bread.class);
                    list.add(bread);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }
}
