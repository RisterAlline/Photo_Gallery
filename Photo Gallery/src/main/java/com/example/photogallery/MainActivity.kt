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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    // Main Content
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Text(text = "It's Photo Gallery APP", modifier = modifier.padding(4.dp))
        Text(text = "don't you believe me?", modifier = modifier.padding(16.dp))
        Image(
            painter = painterResource(id = R.drawable.img_android_plug),
            contentDescription = "Davide Ragusa",
            modifier
                .wrapContentSize()
                .align(CenterHorizontally)
                .size(width = 300.dp, height = 150.dp)
                .border(1.dp, Color.Gray),
        )
        Text(
            text = stringResource(id = R.string.img_android_plug),
            modifier
                .padding(top = 24.dp)
                .border(1.dp, Color.Black)
        )
        // Buttons Row
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .border(1.dp, Color.Red),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { }) {
                Text(text = "Previous")
            }
            Button(onClick = { }) {
                Text(text = "Next")
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhotoGalleryAppPreview() {
    PhotoGalleryTheme {
        PhotoGalleryApp()
    }
}