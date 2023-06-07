package com.example.bookapp.di

import com.example.bookapp.data.BookRepository

object Injection {
    fun provideRepository(): BookRepository {
        return BookRepository.getInstance()
    }
}