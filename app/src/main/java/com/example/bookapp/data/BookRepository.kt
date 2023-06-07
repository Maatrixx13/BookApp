package com.example.bookapp.data

import com.example.bookapp.model.BookList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BookRepository {
    private val dataBooks = mutableListOf<BookList>()

    init {
        if (dataBooks.isEmpty()){
            BookDataDummy.books.forEach {
                dataBooks.add(BookList(it, 0))
            }
        }
    }

    fun getAllBook(): Flow<List<BookList>> {
        return flowOf(dataBooks)
    }

    fun getBookById(id: Long): BookList {
        return dataBooks.first {
            it.books.id == id
        }
    }


    companion object {
        @Volatile
        private var instance: BookRepository? = null

        fun getInstance(): BookRepository =
            instance ?: synchronized(this) {
                BookRepository().apply {
                    instance = this
                }
            }
    }
}

//fun searchBook(query: String): List<Book>{
//    return BookDataDummy.books.filter {
//        it.title.contains(query, ignoreCase = true)
//    }
//}