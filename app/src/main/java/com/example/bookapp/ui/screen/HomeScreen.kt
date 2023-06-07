package com.example.bookapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookapp.di.Injection
import com.example.bookapp.model.BookList
import com.example.bookapp.model.HomeVM
import com.example.bookapp.model.VMFactory
import com.example.bookapp.ui.navigation.UiState
import com.example.bookapp.ui.components.ListBookItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeVM = viewModel(factory = VMFactory(Injection.provideRepository())),
    navigateToDetail: (Long) -> Unit,
//    navController: NavController
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {
        when(it) {
            is UiState.Loading -> {
                viewModel.getAllBook()
            }
            is UiState.Success -> {
                HomeContent(bookList = it.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail)
            }
            is UiState.Error -> {}
        }
    }
}


@Composable
fun HomeContent(
    bookList: List<BookList>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    Box(modifier = Modifier){
        LazyColumn (modifier = modifier){
            items(bookList) {
                ListBookItem(title = it.books.title,
                    photo = it.books.photoUrl,
                    author =it.books.author,
                    modifier = Modifier.clickable { navigateToDetail(it.books.id) }
                )
            }
        }
    }





}
