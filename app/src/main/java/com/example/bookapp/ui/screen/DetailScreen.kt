package com.example.bookapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.bookapp.R
import com.example.bookapp.di.Injection
import com.example.bookapp.model.DetailVM
import com.example.bookapp.model.VMFactory
import com.example.bookapp.ui.navigation.UiState
import com.example.bookapp.ui.theme.BookAppTheme

@Composable
fun DetailScreen(
    id: Long,
    viewModel: DetailVM = viewModel(
        factory = VMFactory(Injection.provideRepository())
    ),
    navigateBack: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {
        when(it) {
            is UiState.Loading -> {
                viewModel.getBookById(id)
            }
            is UiState.Success -> {
                val data = it.data
                DetailBook(
                    title = data.books.title,
                    author = data.books.author,
                    description = data.books.description,
                    photoUrl = data.books.photoUrl,
                    onBackClick = navigateBack)
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailBook(
    title: String,
    author:String,
    description: String,
    photoUrl: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                        .clickable { onBackClick() }
                )
                Text(
                    text = "Book Details",
                    fontSize = 15.sp,

                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = photoUrl,
                    contentDescription = "book_image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(250.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = author,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Description",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = description,
                fontSize = 15.sp,
                lineHeight = 24.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    BookAppTheme {
        DetailBook(
            title = "ListBook",
            author = "Rafi",
            description = "ADA APA YAAA",
            photoUrl = R.drawable.the_book_of_ikigai_make_life_worth_living,
            onBackClick = {}
        )
    }
}