package com.example.bookapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.data.BookRepository
import com.example.bookapp.ui.navigation.UiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeVM(private val bookRepository: BookRepository): ViewModel() {
//    fun getBooks(): List<Book> {
//        return BookDataDummy.books
//    }
//
//    fun searchBooks(query: String): List<Book>{
//        return BookDataDummy.books.filter {
//            it.title.contains(query, ignoreCase = true)
//        }
//    }

    private val _uiState: MutableStateFlow<UiState<List<BookList>>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<List<BookList>>>
        get() = _uiState


    fun getAllBook() {
        viewModelScope.launch {
            bookRepository.getAllBook()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { listBook ->
                    _uiState.value = UiState.Success(listBook)
                }
        }
    }
}
