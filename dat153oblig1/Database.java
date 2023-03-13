package com.example.dat153oblig1;

import android.app.Application;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final static String TAG = "Database";

    private static Database instance = null;

    private ArrayList<Animal> database = new ArrayList<>();

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                instance = new Database();
            }
        }
        return instance;
    }

    public Database(){
    }

    public void add(Animal animal){
        database.add(animal);
    }

    public void initializeDatabase(){
        database.add(new Animal("Dog", getUri(R.drawable.dog)));
        database.add(new Animal("Horse", getUri(R.drawable.horse)));
        database.add(new Animal("Cat", getUri(R.drawable.ic_cat)));
    }

    public Uri getUri(int imageID){
        Uri imageUri = Uri.parse("android.resource://com.example.dat153oblig1/" + imageID);
        return imageUri;
    }

    public Animal getAnimal(int i){
        return database.get(i);
    }

    public String getAnimalName(int i){
        return database.get(i).getName();
    }

    public ArrayList<Animal> getDatabase() {
        return database;
    }

    public void setDatabase(ArrayList<Animal> database) {
        this.database = database;
    }
}
