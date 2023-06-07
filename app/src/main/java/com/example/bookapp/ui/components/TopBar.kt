package com.example.bookapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.bookapp.ui.navigation.Screen

@Composable
fun TopBar(navController: NavHostController, modifier: Modifier) {
    TopAppBar(
        backgroundColor = Color(0xFFD6E8DB)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .weight(0.8f).padding(top = 5.dp)
        ) {
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Book Apps",
                fontSize = 15.sp,
                color = Color(0xFF27374D),
            )
        }
        IconButton(
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "about_page",
                tint = Color(0xFF27374D)
            )
        }
    }
}
