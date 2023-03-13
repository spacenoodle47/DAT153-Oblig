package com.example.dat153oblig1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class AddEntryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AddEntryActivity";
    private static Database database = Database.getInstance();
    //fields
    private ImageView imgImage;
    private Button btnAddEntry, btnChooseImage;
    private EditText edtText;
    private Uri uriImage;
    private ActivityResultLauncher<Intent> chooseImageResult;


    @Override
    public void onClick(View view) {

        Log.d(TAG, "onClick-button: " + view.getResources().getResourceEntryName(view.getId()));

        switch (view.getId()) {
            case R.id.btnAddEntry:
                AddEntry();
                Toast.makeText(this, "Added to database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, DatabaseActivity.class);
                startActivity(intent);
                break;
            case R.id.btnChooseImage:
                selectImage();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);


        Log.d(TAG, "onCreate");

        //initialize views
        imgImage = findViewById(R.id.imageView);
        btnAddEntry = findViewById(R.id.btnAddEntry);
        btnChooseImage = findViewById(R.id.btnChooseImage);
        edtText = findViewById(R.id.edtText);

        //set onClickListener
        btnAddEntry.setOnClickListener(this);
        btnChooseImage.setOnClickListener(this);


        chooseImageResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() != Activity.RESULT_OK || result.getData() == null) return;
            uriImage = result.getData().getData();
            getContentResolver().takePersistableUriPermission(uriImage, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Log.d(TAG, "onActivityResult: uri: " + uriImage);
            Log.d(TAG, "onActivityResult: result: " + result);
            imgImage.setImageURI(uriImage);
        });

    }

        public void selectImage () {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            chooseImageResult.launch(intent);
        }

        public void AddEntry(){
            Animal animal = new Animal(edtText.getText().toString(), uriImage);
            database.add(animal);
        }
}
