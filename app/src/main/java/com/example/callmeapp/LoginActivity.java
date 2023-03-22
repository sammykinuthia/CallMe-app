package com.example.callmeapp;

import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLogin(View v) {
        String email = ((EditText) findViewById(R.id.email)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();


//        db auth
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mainDB").build();
        UserDao userDao = db.userDao();
        User user = userDao.findByEmail(email);

        if (user.password.equals(password)) {
            Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show();
            launchMain();
//            TODO : check on login
        } else {

            TextView view = (TextView) findViewById(R.id.error_msg);
            view.setVisibility(VISIBLE);


        }
    }

    public void launchMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}