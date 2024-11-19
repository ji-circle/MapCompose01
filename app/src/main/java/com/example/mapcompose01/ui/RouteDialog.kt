package com.example.mapcompose01.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.mapcompose01.AppContainer
import com.example.mapcompose01.presentation.DirectionsModel
import com.example.mapcompose01.presentation.DirectionsRouteModel
import okhttp3.Route

@Composable
fun RouteDialog(
    routes: List<DirectionsModel>,
    onSelectRoute: (DirectionsModel) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "경로 선택") },
        text = {
            Column {
                routes.forEachIndexed { index, route ->
                    Button(onClick = { onSelectRoute(route) }) {
                        Text("경로 ${index + 1}: ${route.legs.first().distance.text}, ${route.legs.first().duration.text}")
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("닫기")
            }
        }
    )
}