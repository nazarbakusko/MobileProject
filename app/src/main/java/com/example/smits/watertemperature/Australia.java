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

public class Australia extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;

    GoogleMap map7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_australia);
        lv = (ListView)findViewById(R.id.listView8);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map7);
        mapFragment.getMapAsync(this);
    }
    public void list(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Australia.this, AustraliaStats.class);startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map7 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-32.0388312,115.4010582)).title("Perth"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-33.8679049,151.1924823)).title("Sydney"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-33.8909748,151.2639875)).title("Bondi Beach"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-37.8588043,144.9264751)).title("Port Phillip"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-33.8033469,151.2735736)).title("Manly"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-31.4611962,152.8236602)).title("Port Macquarie"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-27.9987563,153.404871)).title("Surfers Paradise"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-34.4282514,150.8755489)).title("Wollongong"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-37.8274812,144.9352465)).title("Melbourne"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-12.4258916,130.8632674)).title("Darwin"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(-25.2068915,130.9000137)).zoom(3).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/australia-pacific/australia/").get();
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
            titleList.remove("Cairns");
            titleList.remove("Caloundra");
            titleList.remove("Caringbah");
            titleList.remove("Cronulla");
            titleList.remove("Darwin");
            titleList.remove("Deception Bay");
            titleList.remove("Dee Why");
            titleList.remove("Devonport");
            titleList.remove("Forster");
            titleList.remove("Geelong");
            titleList.remove("Geelong West");
            titleList.remove("Gladstone");
            titleList.remove("Gold Coast");
            titleList.remove("Hobart");
            titleList.remove("Mandurah");
            titleList.remove("Melbourne");
            titleList.remove("Mooloolaba");
            titleList.remove("Mornington");
            titleList.remove("Mosman");
            titleList.remove("Newcastle");
            titleList.remove("North Shore");
            titleList.remove("Perth");
            titleList.remove("Port Macquarie");
            titleList.remove("Port Phillip");
            titleList.remove("Port Stephens");
            titleList.remove("Rainbow Beach");
            titleList.remove("Saint Kilda");
            titleList.remove("Surfers Paradise");
            titleList.remove("Sydney");
            titleList.remove("Townsville");
            titleList.remove("Wollongong");
            titleList.remove("New South Wales");
            titleList.remove("Northern Territory");
            titleList.remove("Queensland");
            titleList.remove("South Australia");
            titleList.remove("Tasmania");
            titleList.remove("Victoria");
            titleList.remove("Western Australia");















        }
    }
}
