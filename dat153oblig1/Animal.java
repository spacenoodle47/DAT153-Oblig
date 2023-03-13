package com.example.dat153oblig1;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Comparator;

public class Animal {

    private static final String TAG = "Animal";

    private String name;
    private Uri image;

    public Animal(String name, Uri image) {
        this.name = name;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", image=" + image +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
