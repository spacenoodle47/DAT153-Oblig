package com.example.dat153oblig1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "DatabaseActivity";

    //fields

    Button btnAddEntry2, btnSort;
    RecyclerView recyclerView;
    private Intent intent;
    private final Database database = Database.getInstance();
    private MyAdapter myAdapter;


    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick-button: " + view.getResources().getResourceEntryName(view.getId()));
        switch(view.getId()){
            case R.id.btnAddEntry2:

                startActivity(intent);
                break;
            case R.id.btnSort:
                Collections.sort(database.getDatabase(), new Comparator<Animal>() {
                    @Override
                    public int compare(Animal animal, Animal t1) {
                        return animal.getName().toLowerCase().compareTo(t1.getName().toLowerCase());
                    }
                });
                myAdapter.notifyDataSetChanged();
                for (Animal a: database.getDatabase()){
                    System.out.println(a);
                }

                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Log.d(TAG, "onCreate: Database");

        //Initialize
        btnAddEntry2 = findViewById(R.id.btnAddEntry2);
        btnSort = findViewById(R.id.btnSort);
        recyclerView = findViewById(R.id.recyclerView);
        intent = new Intent(this, AddEntryActivity.class);

        //set onCLickListener
        btnAddEntry2.setOnClickListener(this);
        btnSort.setOnClickListener(this);

        //Initialize MyAdapter class
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");
    }
}