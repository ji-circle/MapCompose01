package com.example.mapcompose01

import com.example.mapcompose01.api.RouteNetworkClient
import com.example.mapcompose01.data.DirectionsRepositoryImpl
import com.example.mapcompose01.domain.DirectionsRepository
import com.example.mapcompose01.domain.usecase.GetDirWithArrTmRpUseCase
import com.example.mapcompose01.domain.usecase.GetDirWithDepTmRpUseCase
import com.example.mapcompose01.domain.usecase.GetDirWithTmRpUseCase
import com.example.mapcompose01.domain.usecase.GetDirectionsUseCase
import com.example.mapcompose01.ui.DirectionsViewModelFactory

class AppContainer {

    private val directionsApiService = RouteNetworkClient.directionsApiService

    val directionsRepository: DirectionsRepository by lazy {
        DirectionsRepositoryImpl(directionsApiService)
    }

    val getDirectionsUseCase: GetDirectionsUseCase by lazy {
        GetDirectionsUseCase(directionsRepository)
    }

    val getDirWithTmRpUseCase: GetDirWithTmRpUseCase by lazy {
        GetDirWithTmRpUseCase(directionsRepository)
    }

    val directionsContainer: DirectionsContainer by lazy {
        DirectionsContainer(
            getDirectionsUseCase,
            getDirWithDepTmRpUseCase,
            getDirWithTmRpUseCase,
            getDirWithArrTmRpUseCase
        )
    }

    val getDirWithDepTmRpUseCase: GetDirWithDepTmRpUseCase by lazy {
        GetDirWithDepTmRpUseCase(directionsRepository)
    }


    val getDirWithArrTmRpUseCase: GetDirWithArrTmRpUseCase by lazy {
        GetDirWithArrTmRpUseCase(directionsRepository)
    }
}

class DirectionsContainer(
    private val getDirectionsUseCase: GetDirectionsUseCase,
    private val getDirWithDepTmRpUseCase: GetDirWithDepTmRpUseCase,
    private val getDirWithTmRpUseCase: GetDirWithTmRpUseCase,
    private val getDirWithArrTmRpUseCase: GetDirWithArrTmRpUseCase
) {
    val directionsViewModel1Factory = DirectionsViewModelFactory(
        getDirectionsUseCase,
        getDirWithDepTmRpUseCase,
        getDirWithTmRpUseCase,
        getDirWithArrTmRpUseCase
    )
}