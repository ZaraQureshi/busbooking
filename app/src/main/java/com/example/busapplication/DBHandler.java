package com.example.busapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Blob;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    static final String DB_NAME = "busdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_USER = "users";
    private static final String TABLE_BUS = "bus";

    // below variable is for our id column.
    private static final String ID_COL = "id";
    private static final String ID_BUS = "bus_id";

    // below variable is for name column
    private static final String NAME_COL = "name";
    private static final String NAME_BUS = "bus_name";

    // below variable id for email column.
    private static final String EMAIL_COL = "email";

    // below variable for contact column.
    private static final String CONTACT_COL = "contact";

    // below variable is for password column.
    private static final String PASSWORD_COL = "password";

    // below variable is for image column.
    private static final String IMAGE_COL = "image";

    private static final String SOURCE_COL = "bus_source";
    private static final String DEST_COL = "bus_destination";
    private static final String AMT_COL = "bus_amt";
    private static final String DATE_COL = "date";





    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_USER + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + CONTACT_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        String CREATE_BUS = "CREATE TABLE "
                + TABLE_BUS + "(" + ID_BUS + " INTEGER PRIMARY KEY,"
                + NAME_BUS+" TEXT,"
                + SOURCE_COL + " TEXT,"
                + DEST_COL + " TEXT,"
                + AMT_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + IMAGE_COL + " BLOB)";
        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
        db.execSQL(CREATE_BUS);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String userName, String userEmail, String userContact, String userPassword, byte[] userImage) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, userName);
        values.put(EMAIL_COL, userEmail);
        values.put(CONTACT_COL, userContact);
        values.put(PASSWORD_COL, userPassword);
        values.put(IMAGE_COL, userImage);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_USER, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addNewBus(String busName, String busSource, String busDest, String busAmt, String busDate, byte[] busImage) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_BUS, busName);
        values.put(SOURCE_COL, busSource);
        values.put(DEST_COL, busDest);
        values.put(AMT_COL, busAmt);
        values.put(DATE_COL, busDate);
        values.put(IMAGE_COL, busImage);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_BUS, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<Bus> readBus() {

        SQLiteDatabase db = this.getReadableDatabase();
        //we used rawQuery(sql, selectionargs) for fetching all the employees
        Cursor cursorBus = db.rawQuery("SELECT * FROM bus", null);

        // on below line we are creating a new array list.
        ArrayList<Bus> busList = new ArrayList<>();

        //if the cursor has some data
        if (cursorBus.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                busList.add(new Bus(
                        cursorBus.getInt(0),
                        cursorBus.getString(1),
                        cursorBus.getString(2),
                        cursorBus.getString(3),
                        cursorBus.getString(4),
                        cursorBus.getDouble(5),
                        cursorBus.getBlob(5)
                ));
            } while (cursorBus.moveToNext());
        }
        //closing the cursor
        cursorBus.close();
        return busList;
//        //creating the adapter object
//        adapter = new BusAdapter(this, R.layout.list_layout_bus, busList,mDatabase);
//
//        //adding the adapter to listview
//        listViewBus.setAdapter(adapter);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUS);
        onCreate(db);
    }



}
