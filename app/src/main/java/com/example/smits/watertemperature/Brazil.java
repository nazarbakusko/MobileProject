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

public class Brazil extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;

    GoogleMap map8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brazil);
        lv = (ListView)findViewById(R.id.listView9);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map8);
        mapFragment.getMapAsync(this);
    }
    public void list(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Brazil.this, BrazilStats.class);startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map8 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-22.913885,-43.7261811)).title("Rio de Janeiro"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-27.6158935,-48.7628725)).title("Florianópolis"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-8.0555435,-34.8790755)).title("Recife"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-12.880916,-38.6162057)).title("Salvador"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-1.3413479,-48.5904701)).title("Belém"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-28.2230501,-48.8284334)).title("Imbituba"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(-13.700415,-69.7176533)).zoom(3).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/south-america/brazil/").get();
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
            titleList.remove("Ananindeua");
            titleList.remove("Angra dos Reis");
            titleList.remove("Antonina");
            titleList.remove("Aracaju");
            titleList.remove("Areia Branca");
            titleList.remove("Armação");
            titleList.remove("Armação de Búzios");
            titleList.remove("Arraial do Cabo");
            titleList.remove("Augusto Corrêa");
            titleList.remove("Balneário Camboriú");
            titleList.remove("Barcarena");
            titleList.remove("Barra de Santo Antônio");
            titleList.remove("Barra dos Coqueiros");
            titleList.remove("Barra Velha");
            titleList.remove("Belém");
            titleList.remove("Belmonte");
            titleList.remove("Bertioga");
            titleList.remove("Biguaçu");
            titleList.remove("Cabedelo");
            titleList.remove("Cabo Frio");
            titleList.remove("Cametá");
            titleList.remove("Camocim");
            titleList.remove("Campinas");
            titleList.remove("Cananéia");
            titleList.remove("Canavieiras");
            titleList.remove("Capão da Canoa");
            titleList.remove("Caraguatatuba");
            titleList.remove("Caucaia");
            titleList.remove("Conceição da Barra");
            titleList.remove("Costeira do Pirajubae");
            titleList.remove("Disney");
            titleList.remove("Duque de Caxias");
            titleList.remove("Fernando de Noronha (Distrito Estadual)");
            titleList.remove("Florianópolis");
            titleList.remove("Fortaleza");
            titleList.remove("Freguesia do Ribeirao da Ilha");
            titleList.remove("Guaíba");
            titleList.remove("Guarapari");
            titleList.remove("Guaratuba");
            titleList.remove("Guarujá");
            titleList.remove("Iguape");
            titleList.remove("Ilhabela");
            titleList.remove("Ilhéus");
            titleList.remove("Imbituba");
            titleList.remove("Itacaré");
            titleList.remove("Itajaí");
            titleList.remove("Itamaracá");
            titleList.remove("Itanhaém");
            titleList.remove("Itapema");
            titleList.remove("Itapissuma");
            titleList.remove("Jaboatão");
            titleList.remove("João Pessoa");
            titleList.remove("Joinville");
            titleList.remove("Laguna");
            titleList.remove("Limoeiro do Ajuru");
            titleList.remove("Luís Correia");
            titleList.remove("Macaé");
            titleList.remove("Macapá");
            titleList.remove("Macau");
            titleList.remove("Maceió");
            titleList.remove("Madre de Deus");
            titleList.remove("Mangaratiba");
            titleList.remove("Maragogi");
            titleList.remove("Marapanim");
            titleList.remove("Marataizes");
            titleList.remove("Marechal Deodoro");
            titleList.remove("Mucuri");
            titleList.remove("Natal");
            titleList.remove("Navegantes");
            titleList.remove("Niterói");
            titleList.remove("Nova Viçosa");
            titleList.remove("Oeiras do Pará");
            titleList.remove("Olinda");
            titleList.remove("Palhoça");
            titleList.remove("Pantano do Sul");
            titleList.remove("Paracuru");
            titleList.remove("Paranaguá");
            titleList.remove("Parati");
            titleList.remove("Paulista");
            titleList.remove("Penha");
            titleList.remove("Peruíbe");
            titleList.remove("Pitimbu");
            titleList.remove("Piúma");
            titleList.remove("Porto Alegre");
            titleList.remove("Porto Belo");
            titleList.remove("Porto Seguro");
            titleList.remove("Praia Grande");
            titleList.remove("Recife");
            titleList.remove("Rio das Ostras");
            titleList.remove("Rio de Janeiro");
            titleList.remove("Rio Grande");
            titleList.remove("Saco dos Limoes");
            titleList.remove("Salinópolis");
            titleList.remove("Salvador");
            titleList.remove("Santa Cruz Cabrália");
            titleList.remove("Santana");
            titleList.remove("Santos");
            titleList.remove("São Caetano de Odivelas");
            titleList.remove("São Francisco do Conde");
            titleList.remove("São Francisco do Sul");
            titleList.remove("São João de Pirabas");
            titleList.remove("São José da Coroa Grande");
            titleList.remove("São José de Ribamar");
            titleList.remove("São Luís");
            titleList.remove("São Sebastião");
            titleList.remove("São Vicente");
            titleList.remove("Soure");
            titleList.remove("Tapera");
            titleList.remove("Tapes");
            titleList.remove("Tijucas");
            titleList.remove("Touros");
            titleList.remove("Tramandaí");
            titleList.remove("Trindade");
            titleList.remove("Tutóia");
            titleList.remove("Ubatuba");
            titleList.remove("Vigia");
            titleList.remove("Vila Velha");
            titleList.remove("Vitória");
            titleList.remove("Alagoas");
            titleList.remove("Amapá");
            titleList.remove("Ceará");
            titleList.remove("Espírito Santo");
            titleList.remove("Estado de Bahía");
            titleList.remove("Maranhão");
            titleList.remove("Pará");
            titleList.remove("Paraíba");
            titleList.remove("Paraná");
            titleList.remove("Pernambuco");
            titleList.remove("Piauí");
            titleList.remove("Rio de Janeiro");
            titleList.remove("Rio Grande do Norte");
            titleList.remove("Rio Grande do Sul");
            titleList.remove("Santa Catarina");
            titleList.remove("São Paulo");
            titleList.remove("Sergipe");

















        }
    }
}
