package com.example.caso5


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.caso5.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val latitud = intent.getDoubleExtra("latitud", 0.0)
        val longitud = intent.getDoubleExtra("longitud", 0.0)
        
        mMap.addMarker(MarkerOptions().position(LatLng(37.56640275933285 ,-4.7406737719892265))
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.andalucia_icon))
            .title("Andalucía - Capital:Sevilla").snippet("Habitantes:8472407"))
        mMap.addMarker(MarkerOptions()
            .position(LatLng(41.61162981125681, -0.9738034948937436))
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.aragon_icon))
            .title("Aragón - Capital: Zaragoza")
            .snippet("Habitantes: 1326261")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(43.45998093597627, -5.864665888274809))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.asturias_icon))
                .title("Asturias - Capital: Oviedo")
                .snippet("Habitantes: 1011792")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(39.57880491837696, 2.904506700284016))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.baleares_icon))
                .title("Baleares - Capital: Palma de Mallorca")
                .snippet("Habitantes: 1173008")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(28.334567287944736, -15.913870062646897))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.canarias_icon))
                .title("Canarias - Capital: Las Palmas de GC y SC de Tenerife")
                .snippet("Habitantes: 2172944")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(43.36511077650701, -3.8398424912727958))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cantabria_icon))
                .title("Cantabria - Capital: Santander")
                .snippet("Habitantes: 584507")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(41.82966675375594, -4.841538702082391))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.castillaleon_icon))
                .title("Castilla y León - Capital: No tiene (Valladolid)")
                .snippet("Habitantes: 2383139")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(39.42393852713387, -3.4784057150456764))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.castillamancha_icon))
                .title("Castilla La Mancha - Capital: No tiene (Toledo)")
                .snippet("Habitantes: 2049562")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(42.07542633707148, 1.5197485699265891))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.catalunya_icon))
                .title("Cataluña - Capital: Barcelona")
                .snippet("Habitantes: 7763362")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(35.90091766842379, -5.309980167928874))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ceuta_icon))
                .title("Ceuta - Capital: Ceuta")
                .snippet("Habitantes: 83517")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(39.05050233766541, -6.351254430283863))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.extremadura_icon))
                .title("Extremadura - Capital: Mérida")
                .snippet("Habitantes: 1059501")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(42.789055617025404, -7.996440102093343))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.galicia_icon))
                .title("Galicia - Capital: Santiago de Compostela")
                .snippet("Habitantes: 2695645")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(42.568072855089895, -2.470916178908127))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.larioja_icon))
                .title("La Rioja - Capital: Logroño")
                .snippet("Habitantes: 319796")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(40.429642598652, -3.76167856716930))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.madrid_icon))
                .title("Madrid - Capital: Madrid")
                .snippet("Habitantes: 6751251")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(35.34689811596408, -2.957162284523383))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.melilla_icon))
                .title("Melilla - Capital: Melilla")
                .snippet("Habitantes: 86261")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(38.088904824462176, -1.4100155858243844))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.murcia_icon))
                .title("Murcia - Capital: Murcia")
                .snippet("Habitantes: 1518486")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(42.71764719490406, -1.657559057849277))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.navarra_icon))
                .title("Navarra - Capital: Pamplona")
                .snippet("Habitantes: 661537")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(43.11260202399828, -2.594687915428055))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.paisvasco_icon))
                .title("País Vasco - Capital: Vitoria")
                .snippet("Habitantes: 2213993")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(39.515011403926145, -0.6939076854376838))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.valencia_icon))
                .title("Valencia - Capital: Valencia")
                .snippet("Habitantes: 5058138")
        )
        val objetivo=LatLng(latitud,longitud)
        val cameraPosition=CameraPosition.Builder().target(objetivo).zoom(7.0f).build()
        val cameraUpdate=CameraUpdateFactory.newCameraPosition(cameraPosition)
        mMap.moveCamera(cameraUpdate)
        mMap.mapType=GoogleMap.MAP_TYPE_TERRAIN
    }
}