package com.example.bookapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.bookapp.ui.navigation.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookapp.ui.components.TopBar
import com.example.bookapp.ui.screen.DetailScreen
import com.example.bookapp.ui.screen.HomeScreen
import com.example.bookapp.ui.screen.ProfileScreen
import com.example.bookapp.ui.theme.BookAppTheme

@Composable
fun BookApps(modifier: Modifier = Modifier,
             navController: NavHostController = rememberNavController(),

) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
//    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route) {
                TopBar(navController = navController, modifier = modifier.padding(start = 10.dp))
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navigateToDetail = { bookId ->
                    navController.navigate(Screen.Detail.createRoute(bookId))
                })
            }
            composable(route = Screen.Detail.route,
                arguments = listOf(navArgument("bookId") { type = NavType.LongType })) {
                val id = it.arguments?.getLong("bookId") ?: -1L
                DetailScreen(
                    id = id,
                    navigateBack = {
                        navController.navigateUp()
                    })
            }
            composable(route = Screen.Profile.route) {
                ProfileScreen(onBackClick = { navController.navigateUp() })
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BookAppsPreview() {
    BookAppTheme {
        BookApps()
    }
}