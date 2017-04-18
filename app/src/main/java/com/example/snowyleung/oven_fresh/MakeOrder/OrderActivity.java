package com.example.snowyleung.oven_fresh.MakeOrder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snowyleung.oven_fresh.R;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {

    private ImageView breadImage;
    private TextView breadPrice;
    private TextView breadName;
    private Button makeOrder;
    private EditText quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        breadImage = (ImageView)findViewById(R.id.BreadView);
        breadPrice = (TextView)findViewById(R.id.textPrice);
        breadName = (TextView)findViewById(R.id.textBread);
        makeOrder = (Button)findViewById(R.id.btnOrder);
        quantity = (EditText)findViewById(R.id.editQuantity);



        makeOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(OrderActivity.this, "You have purchased ".concat(quantity.getText().toString().concat(breadName.getText().toString())), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
