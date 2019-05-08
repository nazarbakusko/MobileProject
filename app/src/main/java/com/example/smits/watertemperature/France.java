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

public class France extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    GoogleMap map3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_france);
        lv = (ListView)findViewById(R.id.listView6);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map3);
        mapFragment.getMapAsync(this);
    }
    public void list(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(France.this, FranceStats.class);startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map3 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(43.5370022, 6.97468)).title("Cannes"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(43.2803051, 5.2404115)).title("Marseille"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(46.1620507, -1.2112805)).title("La Rochelle"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(43.5822601, 7.0348074)).title("Antibes"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(43.4709757, -1.590812)).title("Biarritz"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.9518803, 1.8339366)).title("Calais"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(43.7031691, 7.1827769)).title("Nice"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(48.6462607, -2.0771709)).title("Saint-Malo"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(43.2618617, 6.632071)).title("Saint-Tropez"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(47.0780167, 2.3282634)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/europe/france/").get();
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
            titleList.remove("Antibes");
            titleList.remove("Biarritz");
            titleList.remove("Brest");
            titleList.remove("Calais");
            titleList.remove("Cannes");
            titleList.remove("Cherbourg-Octeville");
            titleList.remove("Concarneau");
            titleList.remove("Dieppe");
            titleList.remove("Douarnenez");
            titleList.remove("La Ciotat");
            titleList.remove("La Rochelle");
            titleList.remove("Lanester");
            titleList.remove("La Seyne-sur-Mer");
            titleList.remove("Le Havre");
            titleList.remove("Marseille");
            titleList.remove("Martigues");
            titleList.remove("Menton");
            titleList.remove("Nice");
            titleList.remove("Port-de-Bouc");
            titleList.remove("Royan");
            titleList.remove("Saint-Malo");
            titleList.remove("Saint-Nazaire");
            titleList.remove("Sanary-sur-Mer");
            titleList.remove("Toulon");
            titleList.remove("Aquitaine");
            titleList.remove("Basse-Normandie");
            titleList.remove("Brittany");
            titleList.remove("Corsica");
            titleList.remove("Haute-Normandie");
            titleList.remove("Languedoc-Roussillon");
            titleList.remove("Nord-Pas-de-Calais");
            titleList.remove("Picardie");
            titleList.remove("Poitou-Charentes");
            titleList.remove("Pays de la Loire");
            titleList.remove("Cagnes-sur-Mer");
            titleList.remove("Équeurdreville-Hainneville");
            titleList.remove("Fécamp");
            titleList.remove("Saint-Raphaël");
            titleList.remove("Provence-Alpes-Côte d'Azur");
            titleList.remove("Sète");










        }
    }
}
