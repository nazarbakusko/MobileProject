package com.example.smits.watertemperature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Stats extends AppCompatActivity implements View.OnClickListener {
    private CardView franceCard, greeceCard, italyCard, portugalCard, turkeyCard, ukraineCard, spainCard, australiaCard, brazilCard, egyptCard, cubaCard, jamaicaCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        franceCard = (CardView) findViewById(R.id.francecardid);
        greeceCard = (CardView) findViewById(R.id.greececardid);
        italyCard = (CardView) findViewById(R.id.italycardid);
        portugalCard = (CardView) findViewById(R.id.portugalcardid);
        turkeyCard = (CardView) findViewById(R.id.turkeycardid);
        ukraineCard = (CardView) findViewById(R.id.ukrainecardid);

        spainCard = (CardView) findViewById(R.id.spaincardid);
        australiaCard = (CardView) findViewById(R.id.australiacardid);
        brazilCard = (CardView) findViewById(R.id.brazilcardid);
        egyptCard = (CardView) findViewById(R.id.egyptcardid);
        cubaCard = (CardView) findViewById(R.id.cubacardid);
        jamaicaCard = (CardView) findViewById(R.id.jamaicacardid);

        franceCard.setOnClickListener(this);
        greeceCard.setOnClickListener(this);
        italyCard.setOnClickListener(this);
        portugalCard.setOnClickListener(this);
        turkeyCard.setOnClickListener(this);
        ukraineCard.setOnClickListener(this);

        spainCard.setOnClickListener(this);
        australiaCard.setOnClickListener(this);
        brazilCard.setOnClickListener(this);
        egyptCard.setOnClickListener(this);
        cubaCard.setOnClickListener(this);
        jamaicaCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.francecardid:
                i = new Intent(this, FranceStats.class);
                startActivity(i);
                break;
            case R.id.greececardid:
                i = new Intent(this, GreeceStats.class);
                startActivity(i);
                break;
            case R.id.italycardid:
                i = new Intent(this, ItalyStats.class);
                startActivity(i);
                break;
            case R.id.portugalcardid:
                i = new Intent(this, PortugalStats.class);
                startActivity(i);
                break;
            case R.id.turkeycardid:
                i = new Intent(this, TurkeyStats.class);
                startActivity(i);
                break;
            case R.id.ukrainecardid:
                i = new Intent(this, UkraineStats.class);
                startActivity(i);
                break;
            case R.id.spaincardid:
                i = new Intent(this, SpainStats.class);
                startActivity(i);
                break;
            case R.id.australiacardid:
                i = new Intent(this, AustraliaStats.class);
                startActivity(i);
                break;
            case R.id.brazilcardid:
                i = new Intent(this, BrazilStats.class);
                startActivity(i);
                break;
            case R.id.egyptcardid:
                i = new Intent(this, EgyptStats.class);
                startActivity(i);
                break;
            case R.id.cubacardid:
                i = new Intent(this, CubaStats.class);
                startActivity(i);
                break;
            case R.id.jamaicacardid:
                i = new Intent(this, JamaicaStats.class);
                startActivity(i);
                break;
            default:
                break;


        }

    }
}
