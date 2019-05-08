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

public class Jamaica extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;

    GoogleMap map11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jamaica);
        lv = (ListView)findViewById(R.id.listView12);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map11);
        mapFragment.getMapAsync(this);
    }
    public void list(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Jamaica.this, JamaicaStats.class);startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map11 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(18.4711336,-77.9398019)).title("Montego Bay"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(18.2692149,-78.357183)).title("Negril"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(18.4008289,-77.099973)).title("Ocho Rios"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(18.1185234,-77.8366189)).zoom(7).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/central-america/jamaica/").get();
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
            titleList.remove("Alligator Pond");
            titleList.remove("Black River");
            titleList.remove("Bluefields");
            titleList.remove("Buff Bay");
            titleList.remove("Discovery Bay");
            titleList.remove("Falmouth");
            titleList.remove("Hope Bay");
            titleList.remove("Kingston");
            titleList.remove("Lucea");
            titleList.remove("Manchioneal");
            titleList.remove("Montego Bay");
            titleList.remove("Morant Bay");
            titleList.remove("Negril");
            titleList.remove("New Kingston");
            titleList.remove("Ocho Rios");
            titleList.remove("Old Harbour Bay");
            titleList.remove("Oracabessa");
            titleList.remove("Port Antonio");
            titleList.remove("Port Maria");
            titleList.remove("Port Royal");
            titleList.remove("Portmore");
            titleList.remove("Rocky Point");
            titleList.remove("Saint Ann’s Bay");
            titleList.remove("Sandy Bay");
            titleList.remove("Savanna-la-Mar");
            titleList.remove("Yallahs");
            titleList.remove("Clarendon");
            titleList.remove("Hanover Parish");
            titleList.remove("Kingston");
            titleList.remove("Portland");
            titleList.remove("Saint Andrew");
            titleList.remove("Saint Ann");
            titleList.remove("Saint Catherine");
            titleList.remove("Saint James");
            titleList.remove("Saint Mary");
            titleList.remove("Saint Thomas");
            titleList.remove("St. Elizabeth");
            titleList.remove("Trelawny");
            titleList.remove("Westmoreland");




















        }
    }
}
