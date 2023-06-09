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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
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
    Column {
        Text(text = "It's Photo Gallery APP", modifier = modifier.padding(16.dp))
        Text(text = "don't you believe me?", modifier = modifier.padding(16.dp))

    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.davide_ragusa),
            contentDescription = "Davide Ragusa",
            modifier
                .size(width = 300.dp, height = 150.dp)
                .border(1.dp, Color.Gray)
        )
        Text(text = "Davide Ragusa bridge",
            modifier
                .padding(top = 24.dp)
                .border(1.dp, Color.Black))
    }

    Row (modifier = modifier) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Next")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Previous")
        }
    }


}

// TODO: /* fun PhotoGalleryViewer */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PhotoGalleryTheme {
        PhotoGalleryApp()
    }
}