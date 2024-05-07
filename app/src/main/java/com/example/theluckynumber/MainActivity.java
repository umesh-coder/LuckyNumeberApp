package com.example.theluckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button getNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        getNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Check if name is empty or contains non-alphabetic characters
                if(name.getText().toString().trim().isEmpty() || !name.getText().toString().trim().matches("[a-zA-Z]+")) {
                    name.setError("Please enter a valid name");
                }else{
                    String userName = name.getText().toString();
                    //Explicit Intent
                    Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

                    //passing the data
                    intent.putExtra("name",userName);

                    startActivity(intent);

                }

            }
        });

    }

    private void initializeViews() {
    name = findViewById(R.id.name);
    getNumber = findViewById(R.id.get_number);

    }
}