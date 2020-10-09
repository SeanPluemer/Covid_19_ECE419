package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void onBtnClick (View view){


        TextView textViewFirstName = findViewById(R.id.textViewFirstName);
        TextView textViewLastName = findViewById(R.id.textViewLastName);
        TextView textViewEmail = findViewById(R.id.textViewEmail);

        EditText editTextFirstName = findViewById(R.id.editTxtFirstName);
        EditText editTextLastName = findViewById(R.id.editTxtLastName);
        EditText editTextEmail = findViewById(R.id.editTxtEmail);

        textViewFirstName.setText(editTextFirstName.getText().toString());
        textViewLastName.setText( editTextLastName.getText().toString());
        textViewEmail.setText(editTextEmail.getText().toString());


    }
}