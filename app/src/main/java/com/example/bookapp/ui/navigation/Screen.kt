package com.example.bookapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("home/{bookId}") {
        fun createRoute(bookId: Long) = "home/$bookId"
    }
}
