package com.example.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photogallery.ui.theme.PhotoGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    PhotoGalleryApp()
                }
            }
        }
    }
}

@Composable
fun PhotoGalleryApp(modifier: Modifier = Modifier) {
    // Header
    Row(modifier = modifier) {
        Text(
            text = "Photo Gallery",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray)
        )
    }
    // Main content
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(4.dp)
            .border(1.dp, Color.Red),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_android_plug),
            contentDescription = null,
            modifier = modifier
                .size(width = 200.dp, height = 400.dp)
                .align(CenterHorizontally)
                .border(1.dp, Color.Gray),
        )
        Image(
            painter = painterResource(id = R.drawable.damiano_baschiera),
            contentDescription = "damiano baschiera bridge",
            modifier = modifier
                .size(width = 200.dp, height = 400.dp)
                .align(CenterHorizontally)
                .border(1.dp, Color.Gray),
        )
        // Buttons
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .border(1.dp, color = Color.Gray),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "previous")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "next")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PhotoGalleryTheme {
        PhotoGalleryApp()
    }
}