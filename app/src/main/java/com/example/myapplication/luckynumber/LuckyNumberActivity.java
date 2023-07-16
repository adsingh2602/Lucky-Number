package com.example.myapplication.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;
    private String name;
    private String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_number_btn);

        //username
        Intent i = getIntent();
        String userName = i.getStringExtra("name");



        //Random Number Generated
        int random_Num = generateRandomNumber();

        luckyNumberTxt.setText(""+random_Num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random_Num);
            }
        });


    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(1000);
        return randomNumberGenerated;

        //return 0;
    }

    public void shareData(String userName, int random_Num){

        //Implicit Intents
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        //convert the int to string
        String number = String.valueOf(random_Num);

        i.putExtra(Intent.EXTRA_SUBJECT, userName);
        i.putExtra(Intent.EXTRA_TEXT, number);

        startActivity(Intent.createChooser(i,"Choose a platform"));


    }


}
