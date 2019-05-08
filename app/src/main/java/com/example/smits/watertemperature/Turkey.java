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

public class Turkey extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    GoogleMap map5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turkey);
        lv = (ListView) findViewById(R.id.listView2);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map5);
        mapFragment.getMapAsync(this);
    }

    public void list() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Turkey.this, TurkeyStats.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map5 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.897917, 30.6480647)).title("Antalya"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.789876, 31.2960806)).title("Side"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.0357892, 27.3952643)).title("Bodrum"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.8480838, 28.2439359)).title("Marmaris"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.6023917, 30.5271904)).title("Kemer"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.6584849, 28.8364408)).title("Fethiye"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.3752683, 29.3132815)).title("Kaş"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.8556968, 27.2257935)).title("Kuşadası"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(38.3607792, 33.9305761)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/middle-east/turkey/").get();
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
            titleList.remove("Adalar");
            titleList.remove("Alanya");
            titleList.remove("Alaplı");
            titleList.remove("Aliağa");
            titleList.remove("Amasra");
            titleList.remove("Antalya");
            titleList.remove("Araklı");
            titleList.remove("Ardeşen");
            titleList.remove("Arhavi");
            titleList.remove("Ataşehir");
            titleList.remove("Ayancık");
            titleList.remove("Ayvalık");
            titleList.remove("Bağcılar");
            titleList.remove("Bahçelievler");
            titleList.remove("Bandırma");
            titleList.remove("Bodrum");
            titleList.remove("Bozcaada");
            titleList.remove("Büyükçekmece");
            titleList.remove("Çanakkale");
            titleList.remove("Çandarlı");
            titleList.remove("Çatalzeytin");
            titleList.remove("Çeşme");
            titleList.remove("Çınarcık");
            titleList.remove("Datça");
            titleList.remove("Derepazarı");
            titleList.remove("Dikili");
            titleList.remove("Eceabat");
            titleList.remove("Eminönü");
            titleList.remove("Erdek");
            titleList.remove("Ereğli");
            titleList.remove("Esenler");
            titleList.remove("Fatsa");
            titleList.remove("Fethiye");
            titleList.remove("Fındıklı");
            titleList.remove("Finike");
            titleList.remove("Foça");
            titleList.remove("Gebze");
            titleList.remove("Gelibolu");
            titleList.remove("Gemlik");
            titleList.remove("Gerze");
            titleList.remove("Giresun");
            titleList.remove("Göcek");
            titleList.remove("Görele");
            titleList.remove("Gülyalı");
            titleList.remove("Halıdere");
            titleList.remove("İskenderun");
            titleList.remove("İstanbul");
            titleList.remove("İzmir");
            titleList.remove("İzmit");
            titleList.remove("Kalkan");
            titleList.remove("Karabağlar");
            titleList.remove("Karaburun");
            titleList.remove("Karamürsel");
            titleList.remove("Kaş");
            titleList.remove("Kemer");
            titleList.remove("Keşap");
            titleList.remove("Kınalı");
            titleList.remove("Koru");
            titleList.remove("Kurucaşile");
            titleList.remove("Kuşadası");
            titleList.remove("Lâpseki");
            titleList.remove("Maltepe");
            titleList.remove("Marmara");
            titleList.remove("Marmaraereğlisi");
            titleList.remove("Marmaris");
            titleList.remove("Mercin");
            titleList.remove("Mimarsinan");
            titleList.remove("Mudanya");
            titleList.remove("Of");
            titleList.remove("Ordu");
            titleList.remove("Perşembe");
            titleList.remove("Piraziz");
            titleList.remove("Rize");
            titleList.remove("Samsun");
            titleList.remove("Sarigerme");
            titleList.remove("Side");
            titleList.remove("Şile");
            titleList.remove("Silivri");
            titleList.remove("Sinop");
            titleList.remove("Şişli");
            titleList.remove("Skefe");
            titleList.remove("Sürmene");
            titleList.remove("Tavşancıl");
            titleList.remove("Tekirdağ");
            titleList.remove("Tepecik");
            titleList.remove("Tirebolu");
            titleList.remove("Trabzon");
            titleList.remove("Türkeli");
            titleList.remove("Umraniye");
            titleList.remove("Üsküdar");
            titleList.remove("Yalova");
            titleList.remove("Zeytinburnu");
            titleList.remove("Zonguldak");
            titleList.remove("Antalya");
            titleList.remove("Aydin");
            titleList.remove("Balikesir");
            titleList.remove("Bartin");
            titleList.remove("Bursa");
            titleList.remove("Giresun");
            titleList.remove("Hatay");
            titleList.remove("Istanbul");
            titleList.remove("İzmir");
            titleList.remove("Kastamonu");
            titleList.remove("Kocaeli");
            titleList.remove("Mersin");
            titleList.remove("Mugla");
            titleList.remove("Ordu");
            titleList.remove("Rize");
            titleList.remove("Samsun");
            titleList.remove("Sinop");
            titleList.remove("Tekirdağ");
            titleList.remove("Trabzon");
            titleList.remove("Yalova");
            titleList.remove("Zonguldak");
            titleList.remove("Artvin");
            titleList.remove("Aydın");
            titleList.remove("Balıkesir");
            titleList.remove("Bartın");
            titleList.remove("Çanakkale");
            titleList.remove("Muğla");


        }
    }
}