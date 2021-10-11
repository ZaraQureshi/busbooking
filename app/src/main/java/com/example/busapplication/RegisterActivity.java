package com.example.busapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Patterns;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, phone, password;
    ImageView image;
    Button register;
    TextView login;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    private DBHandler dbHandler;
   // Bitmap bmpImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);
        login = (TextView) findViewById(R.id.login);
        //image=(ImageView) findViewById(R.id.userImage);
        //bmpImage=null;

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to LoginActivity
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        dbHandler=new DBHandler(RegisterActivity.this);

        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String userName=name.getText().toString();
                String userEmail=email.getText().toString();
                String userContact=phone.getText().toString();
                String userPassword=password.getText().toString();
                //byte[] userImage=DataConverter.convertImage2ByteArray(bmpImage);

                if(userName.isEmpty() && userEmail.isEmpty() && userContact.isEmpty() && userPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;

                }
                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(userName, userEmail, userContact, userPassword);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    final int CAMERA_INTENT=51;
    public void takePicture(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null) {
            startActivityForResult(intent, CAMERA_INTENT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch(requestCode){
            case CAMERA_INTENT:
//                if (requestCode== Activity.RESULT_OK){
                   /* bmpImage=(Bitmap) data.getExtras().get("data");
                    if(bmpImage!=null){
                        image.setImageBitmap(bmpImage);
                    }else{
                        Toast.makeText(this,
                                "Bitmap is null",
                                Toast.LENGTH_SHORT).show();
                    }
//                }else{
//                    Toast.makeText(
//                            this,"Result not ok",Toast.LENGTH_SHORT
//                    ).show();
//                }
                break;

                    */
        }
    }


//    public void saveUser(View view){
//        if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty()
//        || password.getText().toString().isEmpty() || phone.getText().toString().isEmpty()
//        || bmpImage==null){
//            Toast.makeText(
//                    this,"Data is missing",Toast.LENGTH_SHORT
//            ).show();
//        }else{
//            User user=new User();
//            user.setFullName(name.getText().toString());
//            user.setEmail
//        }
//    }

    public void SetValidation() {
        // Check for a valid name.
        if (name.getText().toString().isEmpty()) {
            name.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else  {
            isNameValid = true;
        }

        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            email.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }

        // Check for a valid phone number.
        if (phone.getText().toString().isEmpty()) {
            phone.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else  {
            isPhoneValid = true;
        }

        // Check for a valid password.
        if (password.getText().toString().isEmpty()) {
            password.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (password.getText().length() < 6) {
            password.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if (isNameValid && isEmailValid && isPhoneValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }

    }

}
