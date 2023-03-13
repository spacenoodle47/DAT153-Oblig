package com.example.dat153oblig1;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private final Database database = Database.getInstance();



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);

        Log.d(TAG, "onCreateViewHolder: Test");

        return new MyViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Animal animal = database.getAnimal(position);
        holder.txtAnimalNames.setText(animal.getName());
        holder.imgImage.setImageURI(animal.getImage());

    }

    @Override
    public int getItemCount() {
        return database.getDatabase().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView txtAnimalNames;
        ImageView imgImage;

        private MyAdapter adapter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            txtAnimalNames = itemView.findViewById(R.id.txtAnimalNames);
            imgImage = itemView.findViewById(R.id.imgImage);
            itemView.findViewById(R.id.btnDelete).setOnClickListener(view -> {
                adapter.database.getDatabase().remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });
        }

        public MyViewHolder linkAdapter(MyAdapter adapter){
            this.adapter = adapter;
            return this;
        }
    }
}
