package com.hllbr.kotlinmapbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hllbr.kotlinmapbasic.databinding.ActivityMapsBinding

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
        mapFragment.getMapAsync(this)//Harita initialize işlemleri
        //Eğer bu tür uygulamaları çalıştıramıyorsan emülatorde google play servisleri yok demektir.
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
        /*
        Haritayla ilgili işlemleri onCreate altında değil onMapReady altında gerçekleştiriyoruz
        bunun sebebi bu yapının harita hazır olduğunda çalıştırılıyor olmasıdır.
        mMap = googleMap ile haritamız tanımlanıyor
        bunun ardından sydney adlı bir sabit tanımlanıyor.bu sabit için LatLng denilen bir sınır(obje) kullanılmış
        LatLng = latitude/longitude birlişiminden üretilmiştir.
        Latitude = enlem
        Longitutde = botlam bunların kendi sınıflarıda bulunuyor bu sınıfların haricinde birde Latlng sınıfıda bulunuyor.
        Bu bizim için bir konum objesi olarak tanımlanabilir.
        bu tanımlama işleminin ardından marker olarak ifade edilen harita üzerindeki ataç/işaretleyici kırmızı sembolü üretmemeiz gerekiyor.
        bunu eklerken markerOptions() dediğimiz bir sınıftan çağırıp hangi pozisyonda olacağını nasıl bir başlık olmasını istiyorsak bunu ifade edreek kurduğum bir yapıya sahiptir.
        bu işlemin de bitmesinin ardından ekrandaki görüntünün/Cameranın bu alana gelmesini sağlayabilmek için
        moveToCamere fonksioynundan yararlanarak nereye zoomlanması gerektğini ifade edebiliyorum

         */
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val amsterdam = LatLng(52.363478, 4.8808445)
        mMap.addMarker(MarkerOptions().position(amsterdam).title("Marker in Amsterdam"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(amsterdam))
    }
}