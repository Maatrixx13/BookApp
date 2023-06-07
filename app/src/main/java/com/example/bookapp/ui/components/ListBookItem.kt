@file:OptIn(ExperimentalMaterialApi::class)

package com.example.bookapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookapp.R
import coil.compose.AsyncImage
import com.example.bookapp.ui.navigation.Screen
import com.example.bookapp.ui.theme.BookAppTheme

@Composable
fun ListBookItem(title: String,
                 photo: Int,
                 author: String,
                 modifier: Modifier = Modifier,
//                 navController:NavController
//                 onItemClick: (String) -> Unit
) {
    Column {
        Card(
            modifier = Modifier.background(color = Color(0xFFDEF5E5))
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            elevation = 4.dp
        ){
            Row(
                modifier = modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Box{
                    AsyncImage(
                        model = photo,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(90.dp)
                            .height(140.dp)
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                }
                Spacer(modifier = Modifier
                    .width(2.dp)
                    .height(5.dp))
                Column(
//                    Modifier.fillMaxHeight(1f),
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = author,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp)
                    )
                }
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun ListBookItemPreview() {
    BookAppTheme {
        ListBookItem("Ikigai",R.drawable.the_power_of_now, "Ken Mogi",
//            navController = rememberNavController()
        )
    }
}
