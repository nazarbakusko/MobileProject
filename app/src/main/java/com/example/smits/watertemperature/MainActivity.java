package com.example.smits.watertemperature;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView tempCard, statCard, exitCard, mapCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempCard = (CardView) findViewById(R.id.tempcardid);
        statCard = (CardView) findViewById(R.id.statcardid);
        exitCard = (CardView) findViewById(R.id.exitcardid);
        mapCard = (CardView) findViewById(R.id.mapppcardid);
        mapCard.setOnClickListener(this);
        tempCard.setOnClickListener(this);
        statCard.setOnClickListener(this);
        exitCard.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.tempcardid:
                i = new Intent(this, Temp.class);
                startActivity(i);
                break;
            case R.id.statcardid:
                i = new Intent(this, Stats.class);
                startActivity(i);
                break;
            case R.id.mapppcardid:
                i = new Intent(this, Map.class);
                startActivity(i);
                break;
            case R.id.exitcardid:
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("Ви хочете закрити додаток?")
                        .setCancelable(false)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Закриття додатку");
                alert.show();
            default:
                break;
        }
    }
}