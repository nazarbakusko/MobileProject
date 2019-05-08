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

public class Egypt extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;

    GoogleMap map9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egypt);
        lv = (ListView)findViewById(R.id.listView10);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map9);
        mapFragment.getMapAsync(this);
    }
    public void list(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Egypt.this, EgyptStats.class);startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map9 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(27.9650372,34.2124905)).title("Sharm El-Sheikh"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(31.2386733,32.2501498)).title("Port Said"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(26.989945,33.8986363)).title("Makadi Bay"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(26.1068143,34.2656039)).title("Al-Qusayr"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(27.3956823,33.5809106)).title("El Gouna"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(28.4955981,34.4654066)).title("Dahahab"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(29.9770586,32.4764753)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/africa/egypt/").get();
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
            titleList.remove("Al Ghardaqah");
            titleList.remove("Al Maţarīyah");
            titleList.remove("Alexandria");
            titleList.remove("Dhahab");
            titleList.remove("El Gouna");
            titleList.remove("Idkū");
            titleList.remove("Makadi Bay");
            titleList.remove("Marsá Maţrūḩ");
            titleList.remove("Nuwaybi‘a");
            titleList.remove("Port Said");
            titleList.remove("Sharm el-Sheikh");
            titleList.remove("Suez");
            titleList.remove("‘Izbat al Burj");
            titleList.remove("Ad Daqahlīyah");
            titleList.remove("Al Baḩr al Aḩmar");
            titleList.remove("Al Buḩayrah");
            titleList.remove("Alexandria");
            titleList.remove("As Suways");
            titleList.remove("Būr Sa‘īd");
            titleList.remove("Janūb Sīnāʼ");
            titleList.remove("Maţrūḩ");


















        }
    }
}
