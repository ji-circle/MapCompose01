package com.example.mapcompose01

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mapcompose01.ui.GoogleMapScreen
import com.example.mapcompose01.ui.SearchInsertPage
import com.example.mapcompose01.ui.theme.MapCompose01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapCompose01Theme {
                val navController = rememberNavController()
//                val mapViewModel: MapViewModel = viewModel()
                NavHost(
                    navController,
                    startDestination = "mapScreen"
                ) {
                    composable(route = "mapScreen"){
                        GoogleMapScreen { route ->
                            navController.navigate("routeScreen/${route.overview_polyline.points}")
                        }
                    }
                    composable(
                        route = "routeScreen/{polyline}",
                        arguments = //TODO 여기부터
                    )
                }




                NavHost(
                    navController = navController,
                    startDestination = "home",
                ) {
                    composable(route = "home") {
                        GoogleMapScreen(
                            goToSearchInsertPage = {
                                navController.navigate(route = "searchInsert")
                            }
                        )
                    }

                    composable(route = "searchInsert") {
                        SearchInsertPage(
                            //TODO 홈페이지로 돌아가는 게 아니라 추후 작업 수행하기
                            backToHomePage = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    }
}