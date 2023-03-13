package com.example.dat153oblig1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;

import android.provider.ContactsContract;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    //fields

    private Button btnDatabase, btnQuiz, btnAddEntry;
    private Intent intent;
    private final Database database = Database.getInstance();


    @Override
    public void onClick(View view) {

        Log.d(TAG, "onClick-Button clicked: " + view.getResources().getResourceEntryName(view.getId()));

        switch(view.getId()){
            case R.id.btnDatabase:
                intent = new Intent(this, DatabaseActivity.class);

                startActivity(intent);
                break;
            case R.id.btnQuiz:
                intent = new Intent(this, QuizActivity.class);

                startActivity(intent);
                break;
            case R.id.btnAddEntry:
                intent = new Intent(this, AddEntryActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        //add Animal objects to the Singleton database
        database.initializeDatabase();

        //initialize buttons
        btnDatabase = findViewById(R.id.btnDatabase);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnAddEntry = findViewById(R.id.btnAddEntry);


        //set onclickListener

        btnDatabase.setOnClickListener(this);
        btnAddEntry.setOnClickListener(this);
        btnQuiz.setOnClickListener(this);

        System.out.println(R.drawable.dog);


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }
}