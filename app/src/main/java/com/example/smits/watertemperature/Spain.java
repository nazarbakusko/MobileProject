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

public class Spain extends AppCompatActivity implements OnMapReadyCallback {
    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    GoogleMap map6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spain);
        lv = (ListView) findViewById(R.id.listView7);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.pro_item, titleList);
        list();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map6);
        mapFragment.getMapAsync(this);
    }

    public void list() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Spain.this, SpainStats.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map6 = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(38.3578356, -0.5075437)).title("Alicante"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(41.3947688, 2.0787276)).title("Barcelona"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(36.7182015, -4.5193073)).title("Málaga"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(38.9073269, 1.4121383)).title("Ibiza"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(28.4578159, -16.3213542)).title("Santa Cruz de Tenerife"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(39.5699316, 2.6107148)).title("Palma de Mallorca"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(28.7272938, -13.8823233)).title("Corralejo"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(43.5314231, -5.703474)).title("Gijón"));
        CameraPosition Liberty = CameraPosition.builder().target(new LatLng(40.4378698, -3.819622)).zoom(5).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Document doc;
            try {
                doc = Jsoup.connect("https://www.seatemperature.org/europe/spain/").get();
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
            titleList.remove("A Guarda");
            titleList.remove("Agaete");
            titleList.remove("Aguadulce");
            titleList.remove("Águilas");
            titleList.remove("Agulo");
            titleList.remove("Alcocéber");
            titleList.remove("Algeciras");
            titleList.remove("Algorta");
            titleList.remove("Alicante");
            titleList.remove("Almería");
            titleList.remove("Almuñécar");
            titleList.remove("Altafulla");
            titleList.remove("Altea");
            titleList.remove("Arenys de Mar");
            titleList.remove("Ares");
            titleList.remove("Argoños");
            titleList.remove("Arrecife");
            titleList.remove("Axpe-San Bartolome");
            titleList.remove("Ayamonte");
            titleList.remove("Badalona");
            titleList.remove("Baiona");
            titleList.remove("Bakio");
            titleList.remove("Barbate de Franco");
            titleList.remove("Barcelona");
            titleList.remove("Bárcena de Cicero");
            titleList.remove("Barlovento");
            titleList.remove("Benicarló");
            titleList.remove("Benicàssim");
            titleList.remove("Benidorm");
            titleList.remove("Bermeo");
            titleList.remove("Blanes");
            titleList.remove("Boiro");
            titleList.remove("Buenavista del Norte");
            titleList.remove("Bueu");
            titleList.remove("Cadaqués");
            titleList.remove("Cadiz");
            titleList.remove("Calp");
            titleList.remove("Camariñas");
            titleList.remove("Cambados");
            titleList.remove("Cambrils");
            titleList.remove("Candelaria");
            titleList.remove("Cangas");
            titleList.remove("Carboneras");
            titleList.remove("Cariño");
            titleList.remove("Cartagena");
            titleList.remove("Castell-Platja d'Aro");
            titleList.remove("Castelló de la Plana");
            titleList.remove("Castro-Urdiales");
            titleList.remove("Castropol");
            titleList.remove("Cedeira");
            titleList.remove("Cee");
            titleList.remove("Ceuta");
            titleList.remove("Chipiona");
            titleList.remove("Ciutat Vella");
            titleList.remove("Colera");
            titleList.remove("Colindres");
            titleList.remove("Combarro");
            titleList.remove("Comillas");
            titleList.remove("Corcubión");
            titleList.remove("Corralejo");
            titleList.remove("Cudillero");
            titleList.remove("Deba");
            titleList.remove("Denia");
            titleList.remove("Donostia / San Sebastián");
            titleList.remove("Ea");
            titleList.remove("Eixample");
            titleList.remove("El Astillero");
            titleList.remove("el Campello");
            titleList.remove("El Cotillo");
            titleList.remove("El Puerto de Santa María");
            titleList.remove("El Varadero");
            titleList.remove("Elantxobe");
            titleList.remove("Elexalde Gorliz");
            titleList.remove("Empuriabrava");
            titleList.remove("es Camp de Mar");
            titleList.remove("Es Castell");
            titleList.remove("Escalante");
            titleList.remove("Estepona");
            titleList.remove("Figueras");
            titleList.remove("Fisterra");
            titleList.remove("Ferrol");
            titleList.remove("Garachico");
            titleList.remove("Garrucha");
            titleList.remove("Getaria");
            titleList.remove("Gijón");
            titleList.remove("Groa de Murviedro");
            titleList.remove("Guardamar del Segura");
            titleList.remove("Hondarribia");
            titleList.remove("Horta-Guinardó");
            titleList.remove("Huelva");
            titleList.remove("Ibiza");
            titleList.remove("Irun");
            titleList.remove("Isla Cristina");
            titleList.remove("L'Ampolla");
            titleList.remove("l'Escala");
            titleList.remove("L'Hospitalet de Llobregat");
            titleList.remove("La Laguna");
            titleList.remove("La Línea de la ");
            titleList.remove("La Manga del Mar Menor");
            titleList.remove("La Matanza de Acentejo");
            titleList.remove("La Pineda");
            titleList.remove("Laredo");
            titleList.remove("Las Palmas de Gran Canaria");
            titleList.remove("Las Rosas");
            titleList.remove("Laxe");
            titleList.remove("Lekeitio");
            titleList.remove("Llanes");
            titleList.remove("Lloret de Mar");
            titleList.remove("Los Alcázares");
            titleList.remove("Luanco");
            titleList.remove("La Línea de la Concepción");
            titleList.remove("Magaluf");
            titleList.remove("Málaga");
            titleList.remove("Malpica");
            titleList.remove("Maó");
            titleList.remove("Mataró");
            titleList.remove("Melilla");
            titleList.remove("Miño");
            titleList.remove("Montgat");
            titleList.remove("Moraira");
            titleList.remove("Mugardos");
            titleList.remove("Mugia");
            titleList.remove("Mundaka");
            titleList.remove("Muros");
            titleList.remove("Mutriku");
            titleList.remove("Navia");
            titleList.remove("Noia");
            titleList.remove("Noja");
            titleList.remove("Nou Barris");
            titleList.remove("O Grove");
            titleList.remove("Ondarroa");
            titleList.remove("Orio");
            titleList.remove("Orpesa/Oropesa del Mar");
            titleList.remove("Palamós");
            titleList.remove("Palma de Mallorca");
            titleList.remove("Pasaia");
            titleList.remove("Peníscola");
            titleList.remove("Playa Blanca");
            titleList.remove("Playa de las Américas");
            titleList.remove("Plentzia");
            titleList.remove("Poio");
            titleList.remove("Pontevedra");
            titleList.remove("Port d'Alcúdia");
            titleList.remove("Portbou");
            titleList.remove("Porto do Son");
            titleList.remove("Portugalete");
            titleList.remove("Puerto de la Cruz");
            titleList.remove("Puerto del Carmen");
            titleList.remove("Puerto del Rosario");
            titleList.remove("Puerto Real");
            titleList.remove("Puerto Rico de Gran Canaria");
            titleList.remove("Punta Umbría");
            titleList.remove("Redondela");
            titleList.remove("Retamar");
            titleList.remove("Rianxo");
            titleList.remove("Ribadeo");
            titleList.remove("Ribadesella");
            titleList.remove("Rincón de la Victoria");
            titleList.remove("Roses");
            titleList.remove("Rota");
            titleList.remove("s'Arenal");
            titleList.remove("Sada");
            titleList.remove("Salou");
            titleList.remove("San Juan de la Rambla");
            titleList.remove("San Vicente de la Barquera");
            titleList.remove("Sant Antoni de Portmany");
            titleList.remove("Sant Carles de la Ràpita");
            titleList.remove("Sant Feliu de Guíxols");
            titleList.remove("Sant Martí");
            titleList.remove("Santa Cruz de Tenerife");
            titleList.remove("Santa Eulària des Riu");
            titleList.remove("Santa Pola");
            titleList.remove("Santa Ponsa");
            titleList.remove("Santa Susanna");
            titleList.remove("Santander");
            titleList.remove("Santoña");
            titleList.remove("Sants-Montjuïc");
            titleList.remove("Santurtzi");
            titleList.remove("Sanxenxo");
            titleList.remove("Sestao");
            titleList.remove("Sitges");
            titleList.remove("Soto del Barco");
            titleList.remove("Suances");
            titleList.remove("Tapia de Casariego");
            titleList.remove("Tarifa");
            titleList.remove("Tarragona");
            titleList.remove("Torrevieja");
            titleList.remove("Tossa de Mar");
            titleList.remove("Valencia");
            titleList.remove("Vigo");
            titleList.remove("Vilagarcía de Arousa");
            titleList.remove("Vilanova de Arousa");
            titleList.remove("Villajoyosa");
            titleList.remove("Vinaròs");
            titleList.remove("Viveiro");
            titleList.remove("Zarautz");
            titleList.remove("Zumaia");
            titleList.remove("Andalusia");
            titleList.remove("Asturias");
            titleList.remove("Balearic Islands");
            titleList.remove("Basque Country");
            titleList.remove("Canary Islands");
            titleList.remove("Cantabria");
            titleList.remove("Catalonia");
            titleList.remove("Ceuta");
            titleList.remove("Galicia");
            titleList.remove("Melilla");
            titleList.remove("Murcia");
            titleList.remove("Valencia");


        }
    }
}
