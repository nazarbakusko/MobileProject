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

public class Cuba extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;

    GoogleMap map10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuba);
        lv = (ListView)findViewById(R.id.listView11);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map10);
        mapFragment.getMapAsync(this);
    }
    public void list(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Cuba.this, CubaStats.class);startActivity(i);

            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map10 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(23.0506249,-82.4730896)).title("Havana"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(23.1677032,-81.2849702)).title("Varadero"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(21.9381375,-79.47939)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/central-america/cuba/").get();
                content = doc.select("li.cell");
                titleList.clear();
                for(Element contents : content){
                    titleList.add(contents.text());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(String result){

            lv.setAdapter(adapter);
            adapter.remove(adapter.getItem(0));
            adapter.remove(adapter.getItem(1));
            adapter.notifyDataSetChanged();
            titleList.remove("Baracoa");
            titleList.remove("Cabañas");
            titleList.remove("Caibarién");
            titleList.remove("Campechuela");
            titleList.remove("Centro Habana");
            titleList.remove("Diez de Octubre");
            titleList.remove("Gibara");
            titleList.remove("Habana del Este");
            titleList.remove("Havana");
            titleList.remove("Manzanillo");
            titleList.remove("Mariel");
            titleList.remove("Matanzas");
            titleList.remove("Moa");
            titleList.remove("Niquero");
            titleList.remove("Nuevitas");
            titleList.remove("Santa Cruz del Norte");
            titleList.remove("Santiago de Cuba");
            titleList.remove("Varadero");
            titleList.remove("Camagüey");
            titleList.remove("Ciudad de La Habana");
            titleList.remove("Granma");
            titleList.remove("Guantánamo");
            titleList.remove("Holguín");
            titleList.remove("Matanzas");
            titleList.remove("Provincia Artemisa");
            titleList.remove("Provincia Mayabeque");
            titleList.remove("Santiago de Cuba");
            titleList.remove("Villa Clara");


















        }
    }
}
