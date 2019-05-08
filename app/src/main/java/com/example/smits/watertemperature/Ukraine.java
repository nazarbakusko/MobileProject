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

public class Ukraine extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukraine);
        lv = (ListView) findViewById(R.id.listView1);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void list() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Ukraine.this, UkraineStats.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.837397, -0.1762295)).title("Brighton"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.6267031, -2.5278644)).title("Weymouth"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.4124693, -5.1119065)).title("Newquay"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.0890838, -2.1748253)).title("Aberdeen"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.9860363, -1.7207378)).title("Bournemouth"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(51.0649977, 0.9360798)).title("Folkestone"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(53.8253885, -3.0942421)).title("Blackpool"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.1505355, -5.0919719)).title("Falmouth"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.3884232, -4.1826098)).title("Plymouth"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(52.4136709, -1.5849578)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));
    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/europe/united-kingdom/").get();
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
            titleList.remove("Aberdeen");
            titleList.remove("Barnstaple");
            titleList.remove("Belfast");
            titleList.remove("Berwick-Upon-Tweed");
            titleList.remove("Bideford");
            titleList.remove("Birkenhead");
            titleList.remove("Blackpool");
            titleList.remove("Blyth");
            titleList.remove("Aberystwyth");
            titleList.remove("Bournemouth");
            titleList.remove("Brighton");
            titleList.remove("Brixham");
            titleList.remove("Broadstairs");
            titleList.remove("Burnham-on-Sea");
            titleList.remove("Cardiff");
            titleList.remove("Buckhaven");
            titleList.remove("Carrickfergus");
            titleList.remove("Christchurch");
            titleList.remove("Cleethorpes");
            titleList.remove("Clevedon");
            titleList.remove("Cowes");
            titleList.remove("Crosby");
            titleList.remove("Deal");
            titleList.remove("Derry");
            titleList.remove("Dumbarton");
            titleList.remove("Dundee");
            titleList.remove("Edinburgh");
            titleList.remove("Emsworth");
            titleList.remove("Erskine");
            titleList.remove("Exmouth");
            titleList.remove("Falmouth");
            titleList.remove("Fareham");
            titleList.remove("Felixstowe");
            titleList.remove("Fleetwood");
            titleList.remove("Folkestone");
            titleList.remove("Gillingham");
            titleList.remove("Gosport");
            titleList.remove("Grays");
            titleList.remove("Greenock");
            titleList.remove("Harwich");
            titleList.remove("Hayling Island");
            titleList.remove("Hull");
            titleList.remove("Hythe");
            titleList.remove("Isle of Lewis");
            titleList.remove("Kirkcaldy");
            titleList.remove("Larne");
            titleList.remove("Littlehampton");
            titleList.remove("Liverpool");
            titleList.remove("Llanelli");
            titleList.remove("Llandudno");
            titleList.remove("Lowestoft");
            titleList.remove("Lytham St Annes");
            titleList.remove("Musselburgh");
            titleList.remove("Newport");
            titleList.remove("Newquay");
            titleList.remove("Newtownabbey");
            titleList.remove("Orkney");
            titleList.remove("Penarth");
            titleList.remove("Penzance");
            titleList.remove("Peterhead");
            titleList.remove("Plymouth");
            titleList.remove("Poole");
            titleList.remove("Saint Andrews");
            titleList.remove("Saint Austell");
            titleList.remove("Sandown");
            titleList.remove("Scarborough");
            titleList.remove("Shetland");
            titleList.remove("Shoreham-by-Sea");
            titleList.remove("South Shields");
            titleList.remove("Southampton");
            titleList.remove("Southend-on-Sea");
            titleList.remove("Sunderland");
            titleList.remove("Swansea");
            titleList.remove("Teignmouth");
            titleList.remove("Totton");
            titleList.remove("Tynemouth");
            titleList.remove("Weston-super-Mare");
            titleList.remove("Weymouth");
            titleList.remove("Whitstable");
            titleList.remove("Widnes");
            titleList.remove("Ryde");
            titleList.remove("Runcorn");
            titleList.remove("Rhyl");
            titleList.remove("Redcar");
            titleList.remove("Ramsgate");
            titleList.remove("Portsmouth");
            titleList.remove("Porthcawl");
            titleList.remove("Port Glasgow");
            titleList.remove("");
            titleList.remove("");
            titleList.remove("");
            titleList.add(1, "Average salinity: 35.9%" + "\n" +
                    "Average flow velocity: 12-13 km / h");
            titleList.add(3, "Average salinity: 35.8%" + "\n" +
                    "Average flow velocity: 12-14 km / h");
            titleList.add(5, "Average salinity: 35.8%" + "\n" +
                    "Average flow velocity: 12-13 km / h");


        }
    }
}