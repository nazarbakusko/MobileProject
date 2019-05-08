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

public class Greece extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    GoogleMap map2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greece);
        lv = (ListView)findViewById(R.id.listView5);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
    }
    public void list(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Greece.this, GreeceStats.class);startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map2 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.5075659, 24.0072304)).title("Chania"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(35.3220114, 25.1000512)).title("Heraklion"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.1673367, 27.6853187)).title("Rhodes"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(39.6110111, 19.8744794)).title("Kerkyra"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.8912598, 27.2595205)).title("Kos"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(40.6211872, 22.9110077)).title("Thessaloniki"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(34.7726773, 32.397991)).title("Paphos"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(38.910804, 21.7954845)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/europe/greece/").get();
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
            titleList.remove("Athens");
            titleList.remove("Alexandroúpoli");
            titleList.remove("Chalkída");
            titleList.remove("Chaniá");
            titleList.remove("Chíos");
            titleList.remove("Elefsína");
            titleList.remove("Ellinikó");
            titleList.remove("Irákleion");
            titleList.remove("Kallithéa");
            titleList.remove("Kavála");
            titleList.remove("Keratsíni");
            titleList.remove("Kérkyra");
            titleList.remove("Kos");
            titleList.remove("Mytilíni");
            titleList.remove("Heraklion");
            titleList.remove("Moskháton");
            titleList.remove("Préveza");
            titleList.remove("Réthymno");
            titleList.remove("Thessaloníki");
            titleList.remove("Salamís");
            titleList.remove("Paphos");
            titleList.remove("Náfpaktos");
            titleList.remove("Pátra");
            titleList.remove("Piraeus");
            titleList.remove("Paphos");
            titleList.remove("Voúla");
            titleList.remove("Μεσολόγγι");
            titleList.remove("Rhodes");












        }
    }
}
