package com.example.mapcompose01

import android.content.Context
import com.google.android.gms.location.LocationServices

class LocationUtils(context: Context) {
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    //TODO 여기 location 수정하기
    fun getCurrentLocation(
        onSuccess: (Location) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if(location != null) {
                    onSuccess(location)
                }else {
                    onFailure(Exception("위치 얻기 실패"))
                }
            }
            .addOnFailureListener { exception->
                onFailure(exception)
            }
    }

}