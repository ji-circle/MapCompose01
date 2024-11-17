package com.example.mapcompose01.domain.usecase

import com.example.mapcompose01.domain.DirectionsRepository

class GetDirWithDepTmRpUseCase
constructor(private val repository: DirectionsRepository) {
    suspend operator fun invoke(
        origin: String,
        destination: String,
        departureTime: Int,
        transitMode: String,
        transitRoutingPreference: String
    ) = repository.getDirectionsWithDepartureTmRp(
        origin,
        destination,
        departureTime,
        transitMode,
        transitRoutingPreference
    )
}