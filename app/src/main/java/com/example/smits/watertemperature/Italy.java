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

public class Italy extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    GoogleMap map1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italy);
        lv = (ListView) findViewById(R.id.listView4);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    public void list() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Italy.this, ItalyStats.class);startActivity(i);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map1 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(40.7775302, 13.9804513)).title("Naples"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(44.2478044, 12.3181096)).title("Cervia"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(44.4468921, 8.7507474)).title("Genoa"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(45.4042007, 12.1015559)).title("Venice"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(39.2253991, 9.0933585)).title("Cagliari"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(44.053458, 12.5396675)).title("Rimini"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(40.7266875, 13.8740105)).title("Ischia"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(38.1405228, 13.2872482)).title("Palermo"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(40.5659702, 8.2869004)).title("Alghero"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(38.6746694, 15.8843936)).title("Tropea"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(41.909986, 12.3959128)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;

            try {
                doc = Jsoup.connect("https://www.seatemperature.org/europe/italy/").get();
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
            titleList.remove("Agropoli");
            titleList.remove("Anzio");
            titleList.remove("Augusta");
            titleList.remove("Bacoli");
            titleList.remove("Bari");
            titleList.remove("Barletta");
            titleList.remove("Bisceglie");
            titleList.remove("Ancona");
            titleList.remove("Bagnoli");
            titleList.remove("Cagliari");
            titleList.remove("Catania");
            titleList.remove("Cervia");
            titleList.remove("Cesenatico");
            titleList.remove("Chioggia");
            titleList.remove("Civitanova Marche");
            titleList.remove("Civitavecchia");
            titleList.remove("Crotone");
            titleList.remove("Follonica");
            titleList.remove("Formia");
            titleList.remove("Francavilla al Mare");
            titleList.remove("Gaeta");
            titleList.remove("Genoa");
            titleList.remove("Giovinazzo");
            titleList.remove("Imperia");
            titleList.remove("Ischia");
            titleList.remove("Licata");
            titleList.remove("Livorno");
            titleList.remove("Manfredonia");
            titleList.remove("Marina di Carrara");
            titleList.remove("Marsala");
            titleList.remove("Messina");
            titleList.remove("Mestre");
            titleList.remove("Milazzo");
            titleList.remove("Molfetta");
            titleList.remove("Monopoli");
            titleList.remove("Naples");
            titleList.remove("Nettuno");
            titleList.remove("Ortona");
            titleList.remove("Palermo");
            titleList.remove("Pescara");
            titleList.remove("Polignano a Mare");
            titleList.remove("Portica");
            titleList.remove("Porto Empedocle");
            titleList.remove("Porto San Giorgio");
            titleList.remove("Porto Sant'Elpidio");
            titleList.remove("Pozzallo");
            titleList.remove("Pozzuoli");
            titleList.remove("Rapallo");
            titleList.remove("Reggio Calabria");
            titleList.remove("Rimini");
            titleList.remove("Roseto degli Abruzzi");
            titleList.remove("Salerno");
            titleList.remove("San Remo");
            titleList.remove("Savona");
            titleList.remove("Sciacca");
            titleList.remove("Sestri Levante");
            titleList.remove("Siracusa");
            titleList.remove("Sorrento");
            titleList.remove("Taranto");
            titleList.remove("Temini Imerese");
            titleList.remove("Tor San Lorenzo");
            titleList.remove("Torre Annunziata");
            titleList.remove("Trani");
            titleList.remove("Trapani");
            titleList.remove("Trieste");
            titleList.remove("Venice");
            titleList.remove("Viareggio");
            titleList.remove("Vico Equense");
            titleList.remove("Abruzzo");
            titleList.remove("Apulia");
            titleList.remove("Calabria");
            titleList.remove("Campania");
            titleList.remove("Emilia-Romagna");
            titleList.remove("Friuli Venezia Giulia");
            titleList.remove("Latium");
            titleList.remove("Liguria");
            titleList.remove("Sardinia");
            titleList.remove("Sicily");
            titleList.remove("The Marches");
            titleList.remove("Tuscany");
            titleList.remove("Veneto");
            titleList.remove("Albenga");
            titleList.remove("Gallipoli");
            titleList.remove("La Spezia");
            titleList.remove("Portici");
            titleList.remove("Termini Imerese");
            titleList.remove("Torre del Greco");










        }
    }
}
