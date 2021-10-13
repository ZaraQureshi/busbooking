package com.example.busapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BusAdd extends AppCompatActivity {

    EditText name, source, destination, amt, date;
    ImageView image;
    Button addBus;
    DBHandler dbHandler = new DBHandler(BusAdd.this);
    //Bitmap bmpImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_add_activity);

        name = (EditText) findViewById(R.id.name);
        source = (EditText) findViewById(R.id.source);
        destination = (EditText) findViewById(R.id.destination);
        amt = (EditText) findViewById(R.id.amt);
        date = (EditText) findViewById(R.id.date);
        addBus = (Button) findViewById(R.id.addbus);

        //image = (ImageView) findViewById(R.id.busImage);
        //bmpImage = null;

        addBus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String busName = String.valueOf(name.getText());
                String busSource = source.getText().toString();
                String busDest = destination.getText().toString();
                String busAmt = amt.getText().toString();
                String busDate = date.getText().toString();
                //byte[] busImage = DataConverter.convertImage2ByteArray(bmpImage);


                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                Log.d("BusAdd :  ",busName + busSource + busDest + busDate + busAmt);
                try {
                    dbHandler.addNewBus(busName, busSource, busDest, busAmt, busDate);
                }
                catch(Exception e)
                {Log.d("BusAdd ", String.valueOf(e));}

                Log.d("BusAdd :  ","after sending data to database");
                Intent intent = new Intent(getApplicationContext(), BookBus.class);
                startActivity(intent);
            }
        });
    }

    final int CAMERA_INTENT = 51;

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_INTENT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_INTENT:
//                if (requestCode== Activity.RESULT_OK){
             /*   bmpImage = (Bitmap) data.getExtras().get("data");
                if (bmpImage != null) {
                    image.setImageBitmap(bmpImage);
                } else {
                    Toast.makeText(this,
                            "Bitmap is null",
                            Toast.LENGTH_SHORT).show();
                }
//                }else{
//                    Toast.makeText(this,"Result not ok",Toast.LENGTH_SHORT
//                    ).show();
//                }
                break;

              */
        }
    }
}