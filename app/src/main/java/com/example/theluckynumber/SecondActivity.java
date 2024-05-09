package com.example.theluckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView number;
    Button shareNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initializeViews();

        //getting the data
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        //random number
        int generatedNumber = generateRandomNumber();

        //set text of number
        number.setText(""+generatedNumber);


        //share the Number
        shareNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,generatedNumber);
            }
        });

    }

    /**
     *  shares the data frpm 
     * @param userName
     * @param generatedNumber
     */

    public void shareData(String userName,int generatedNumber) {
    Intent i = new Intent(Intent.ACTION_SEND);
    i.setType("text/plain");


    //additional info
        i.putExtra(Intent.EXTRA_SUBJECT,userName+" Got Lucky Today!");
        i.putExtra(Intent.EXTRA_TEXT,userName+" Lucky Number is "+generatedNumber);


        startActivity(Intent.createChooser(i," Choose Platform "));

    }



    public int generateRandomNumber() {

        Random rand=new Random();
        int upper_limit=1000;
        int generatedNumber=rand.nextInt(upper_limit);
        return  generatedNumber;

    }

    private void initializeViews() {
    number = findViewById(R.id.number);
    shareNumber = findViewById(R.id.Share_number);
    }


}