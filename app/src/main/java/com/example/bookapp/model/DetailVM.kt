package com.example.bookapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapp.data.BookRepository
import com.example.bookapp.ui.navigation.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailVM(
    private val repository: BookRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<BookList>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<BookList>>
        get() = _uiState

    fun getBookById(bookId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getBookById(bookId))
        }
    }
}