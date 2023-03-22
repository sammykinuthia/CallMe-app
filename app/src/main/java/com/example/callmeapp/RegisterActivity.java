package com.example.callmeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onRegister(View v) {
        String email = ((EditText) findViewById(R.id.r_email)).getText().toString();
        String name = ((EditText) findViewById(R.id.r_name)).getText().toString();
        String contact = ((EditText) findViewById(R.id.r_contact)).getText().toString();
        String password = ((EditText) findViewById(R.id.r_password)).getText().toString();
        String password_confirm = ((EditText) findViewById(R.id.r_password_confirm)).getText().toString();

        String printCr = "email: " + email + "\nname: " + name + "\ncontact: " + contact + "\npassword: " + password;
        Toast.makeText(this, printCr, Toast.LENGTH_LONG).show();


//        user cls
        User newUser = new User();
        newUser.name = name;
        newUser.email = email;
        newUser.contact = contact;
        newUser.password = password;
//        DB Room
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mainDB").build();
        UserDao userDao = db.userDao();
        userDao.insert(newUser);

//        redirect to Homepage
        launchMain();

    }

    public void launchMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

