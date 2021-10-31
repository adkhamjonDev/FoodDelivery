package uz.adkhamjon.fooddelivery.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.model.LatLng
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.databinding.FragmentAddressBinding
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location

import android.location.LocationManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
import com.google.android.gms.tasks.Task
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener


class AddressFragment : Fragment(),OnMapReadyCallback {
    private lateinit var client: FusedLocationProviderClient
    private lateinit var binding: FragmentAddressBinding
    private lateinit var mapFragment: SupportMapFragment

    private lateinit var googleMap: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddressBinding.inflate(inflater, container, false)
        mapFragment = (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)!!
        mapFragment.getMapAsync(this)
        client = LocationServices.getFusedLocationProviderClient(requireActivity())
        Dexter.withContext(requireContext())
            .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener {
                @RequiresApi(Build.VERSION_CODES.R)
                override fun onPermissionGranted(response: PermissionGrantedResponse) {

                }
                override fun onPermissionDenied(response: PermissionDeniedResponse) {
                    Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT)
                        .show()
                }
                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }
            }).check()


        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }

    override fun onResume() {
        super.onResume()
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).showToolbar()
    }
    override fun onMapReady(p0: GoogleMap) {
        LocationServices.getFusedLocationProviderClient(requireContext())
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
        }
        val task: Task<Location> = client.lastLocation
        task.addOnSuccessListener { location ->
            if (location != null) {
                    val latLng = LatLng(41.2224819,69.2400725)
                    val options = MarkerOptions().position(latLng).title("I am here")
                    p0.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f))
                    p0.addMarker(options)
            }
        }
    }
}