package com.example.bookapp.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.bookapp.R

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onBackClick:() -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize().padding(16.dp)
    ) {
        item {Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
            )
            Text(
                text = "Profile",
                fontSize = 15.sp,

            )
        }

            Image(
                modifier = modifier
                    .fillMaxSize()
                    .height(360.dp)
//                    .padding(16.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.fotor_mypic),
                contentDescription = "profile"
            )
            Text(
                text = "Rafial Kahf",color = (Color(0xFFFFD8A9)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,

                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "rafialkahf315@gmail.com",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }
    }

}
@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview(){
//    ProfileScreen()
}
