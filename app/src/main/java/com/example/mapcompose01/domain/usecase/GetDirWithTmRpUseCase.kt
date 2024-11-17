package com.example.mapcompose01.domain.usecase

import com.example.mapcompose01.domain.DirectionsRepository

class GetDirWithTmRpUseCase
constructor(private val repository: DirectionsRepository) {
    suspend operator fun invoke(
        origin: String,
        destination: String,
        transitMode: String,
        transitRoutingPreference: String
    ) = repository.getDirectionsWithTmRp(origin, destination, transitMode, transitRoutingPreference)
}