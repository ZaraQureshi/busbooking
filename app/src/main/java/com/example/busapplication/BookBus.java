package com.example.busapplication;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookBus extends AppCompatActivity {

//    List<Bus> busList;
//    SQLiteDatabase mDatabase;
    Button bookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_listview);

        try {
            bookBtn = (Button) findViewById(R.id.bookBusTicket);
            bookBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("bookBus", "in bookbutton");
                    Intent intent = new Intent(getApplicationContext(), BusDetails.class);
                    startActivity(intent);
                }
            });
            // redirect to LoginActivity

        }
        catch(Exception e)
        {
            Log.d("BookBus", String.valueOf(e));
        }
        //ListView listViewBus;
       // RecyclerView busRV = null;
        //    BusAdapter adapter;
        ArrayList<Bus> busList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(BookBus.this);

        // getting our course array
        // list from db handler class.
        busList = dbHandler.readBus();

        // on below line passing our array lost to our adapter class.
        BusAdapter busAdapter = new BusAdapter(busList, BookBus.this);
        //listViewBus = findViewById(R.id.listViewBus);

          // setting layout manager for our recycler view.
         // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BookBus.this, RecyclerView.VERTICAL, false);
        // busRV.setLayoutManager(linearLayoutManager);

        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.listViewBus);
        // set a LinearLayoutManager with default orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView

        // setting our adapter to recycler view.
        recyclerView.setAdapter(busAdapter);

        Log.d("BookBus :  ","everthing fine till here");
    }
}




