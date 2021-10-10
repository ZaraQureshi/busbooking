package com.example.busapplication;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookBus extends AppCompatActivity {

//    List<Bus> busList;
//    SQLiteDatabase mDatabase;
    ListView listViewBus;
//    BusAdapter adapter;
    private ArrayList<Bus> busList;
    private DBHandler dbHandler;
    private BusAdapter busAdapter;
    private RecyclerView busRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_listview);

        busList = new ArrayList<>();
        dbHandler = new DBHandler(BookBus.this);

        // getting our course array
        // list from db handler class.
        busList = dbHandler.readBus();

        // on below line passing our array lost to our adapter class.
        busAdapter = new BusAdapter(busList, BookBus.this);
        listViewBus = findViewById(R.id.listViewBus);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BookBus.this, RecyclerView.VERTICAL, false);
        busRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        busRV.setAdapter(busAdapter);
    }
}




