package com.example.mapcompose01

import android.content.Context
import android.location.Geocoder
import com.google.android.gms.location.LocationServices
import java.util.Locale

//class LocationUtils(context: Context) {
//    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
//
//    //TODO 여기 location 수정하기
//    fun getCurrentLocation(
//        onSuccess: (Location) -> Unit,
//        onFailure: (Exception) -> Unit
//    ) {
//        fusedLocationClient.lastLocation
//            .addOnSuccessListener { location ->
//                if(location != null) {
//                    onSuccess(location)
//                }else {
//                    onFailure(Exception("위치 얻기 실패"))
//                }
//            }
//            .addOnFailureListener { exception->
//                onFailure(exception)
//            }
//    }
//
//}

class LocationUtils {
    fun getCountryFromLatLng(context: Context, lat: Double, lng: Double): String? {
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses = geocoder.getFromLocation(lat, lng, 1)
        return if (addresses?.isNotEmpty() == true) {
            val address = addresses[0]
            address.countryName
        } else {
            null
        }
    }
}