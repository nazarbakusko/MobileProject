package com.example.smits.watertemperature;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Portugal extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    GoogleMap map4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portugal);
        lv = (ListView) findViewById(R.id.listView3);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map4);
        mapFragment.getMapAsync(this);
    }

    public void list() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Portugal.this, PortugalStats.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map4 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.0177845, -7.9749519)).title("Faro"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(38.7436057, -9.2302436)).title("Lisbon"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(41.1621376, -8.6569732)).title("Porto"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.1152749, -8.7180231)).title("Lagos"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.7449602, -25.6959568)).title("Ponta Delgada"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.1801418, -8.6053194)).title("Portimão"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.1294045, -7.6700564)).title("Tavira"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(38.7150114, -9.4827829)).title("Cascais"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.1121184, -8.288028)).title("Albufeira"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(32.6600368, -16.9596901)).title("Funchal"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(40.2287388, -8.4863146)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/europe/portugal/").get();
                content = doc.select("li.cell");
                titleList.clear();
                for (Element contents : content) {
                    titleList.add(contents.text());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            lv.setAdapter(adapter);
            adapter.remove(adapter.getItem(0));
            adapter.remove(adapter.getItem(1));
            adapter.notifyDataSetChanged();
            titleList.remove("Alcochete");
            titleList.remove("Alhandra");
            titleList.remove("Almada");
            titleList.remove("Alvor");
            titleList.remove("Amora");
            titleList.remove("Angra do Heroísmo");
            titleList.remove("Amadora");
            titleList.remove("Algés");
            titleList.remove("Armação de Pêra");
            titleList.remove("Arrentela");
            titleList.remove("Aver-o-Mar");
            titleList.remove("Buarcos");
            titleList.remove("Cacilhas");
            titleList.remove("Cascais");
            titleList.remove("Corroios");
            titleList.remove("Ericeira");
            titleList.remove("Espinho");
            titleList.remove("Esposende");
            titleList.remove("Esposende");
            titleList.remove("Estoril");
            titleList.remove("Faro");
            titleList.remove("Horta");
            titleList.remove("Funchal");
            titleList.remove("Figueira da Foz");
            titleList.remove("Lagos");
            titleList.remove("Lisbon");
            titleList.remove("Machico");
            titleList.remove("Madalena");
            titleList.remove("Matosinhos");
            titleList.remove("Montijo");
            titleList.remove("Moscavide");
            titleList.remove("Piedade");
            titleList.remove("Ponta Delgada");
            titleList.remove("Ponta do Sol");
            titleList.remove("Porto");
            titleList.remove("Quateira");
            titleList.remove("Sagres");
            titleList.remove("Sines");
            titleList.remove("Tavira");
            titleList.remove("Trafaria");
            titleList.remove("Viana do Castelo");
            titleList.remove("Vila de Porto Santo");
            titleList.remove("Monte Estoril");
            titleList.remove("Peniche");
            titleList.remove("Quarteira");
            titleList.remove("Sesimbra");
            titleList.remove("Porto");
            titleList.remove("Madeira");
            titleList.remove("Lisbon");
            titleList.remove("Leiria");
            titleList.remove("Faro");
            titleList.remove("Caniço");
            titleList.remove("Caniçal");
            titleList.remove("Campanário");
            titleList.remove("Fajã da Ovelha");
            titleList.remove("Fajã de Baixo");
            titleList.remove("Leça da Palmeira");
            titleList.remove("Nazaré");
            titleList.remove("Olhão");
            titleList.remove("Paço de Arcos");
            titleList.remove("Portimão");
            titleList.remove("Póvoa de Santa Iria");
            titleList.remove("Póvoa de Varzim");
            titleList.remove("Praia da Vitória");
            titleList.remove("Rosto de Cão");
            titleList.remove("São João da Talha");
            titleList.remove("São Roque do Pico");
            titleList.remove("São Vicente");
            titleList.remove("Setúbal");
            titleList.remove("Vila Franca de Xira");
            titleList.remove("Vila Franca do Campo");
            titleList.remove("Vila Nova de Milfontes");
            titleList.remove("Aveiro");
            titleList.remove("Azores");
            titleList.remove("Beja");
            titleList.remove("Braga");
            titleList.remove("Coimbra");
            titleList.remove("Viana do Castelo");
            titleList.remove("Setúbal");


        }
    }
}