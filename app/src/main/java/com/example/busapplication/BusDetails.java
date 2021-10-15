package com.example.busapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BusDetails extends AppCompatActivity {
    TextView source,dest,amt,date,name;
    Button book;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_details);

        book=findViewById(R.id.bookBusAddDb);
        name=findViewById(R.id.nameShow);
        source=findViewById(R.id.sourceShow);
        dest=findViewById(R.id.destShow);
        amt=findViewById(R.id.amtShow);
        date=findViewById(R.id.dateShow);




        book.setOnClickListener(new View.OnClickListener() {
            private int userid;
            private String name1=name.getText().toString();
            @Override
            public void onClick(View v) {
//                int userid;
                dbHandler.update(name1,this.userid);
                Toast.makeText(BusDetails.this,"Successful",Toast.LENGTH_SHORT).show();
            }
        });

    }
}