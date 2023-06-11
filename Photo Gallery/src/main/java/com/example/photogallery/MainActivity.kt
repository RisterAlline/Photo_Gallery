package com.example.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
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

    var currentBridge = painterResource(id = R.drawable.img_android_plug)
    var currentTextBridge = stringResource(id = R.string.img_android_plug)

    var counter by remember { mutableStateOf(0) }
    when (counter) {
        0 -> {
            currentBridge = painterResource(id = R.drawable.bridge_3024773)
            currentTextBridge = stringResource(id = R.string.bridge_3024773)
        }

        1 -> {
            currentBridge = painterResource(id = R.drawable.damiano_baschiera)
            currentTextBridge = stringResource(id = R.string.damiano_baschiera)
        }

        2 -> {
            currentBridge = painterResource(id = R.drawable.davide_ragusa)
            currentTextBridge = stringResource(id = R.string.davide_ragusa)
        }

        3 -> {
            currentBridge = painterResource(id = R.drawable.simon_stratford)
            currentTextBridge = stringResource(id = R.string.simon_stratford)
        }

        4 -> {
            currentBridge = painterResource(id = R.drawable.evren_aydin)
            currentTextBridge = stringResource(id = R.string.evren_aydin)
        }

        else -> {
            counter = 0
        }
    }
    // Main Content
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = CenterHorizontally
    ) {// Header joke
        Text(
            text = "It's Photo Gallery APP",
        )
        Text(
            text = "don't you believe me?",
        )
        // Bridge Image
        Image(
            painter = currentBridge,
            contentDescription = null,
            modifier
                .wrapContentSize()
                .align(CenterHorizontally)
                .padding(top = 24.dp)
                .size(width = 300.dp, height = 150.dp),
        )
        // Bridge Text description
        Text(
            text = currentTextBridge, modifier.padding(top = 24.dp)
        )
        // Buttons Row
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { counter-- }) {
                Text(text = "Previous")
            }
            Button(onClick = { counter++ }) {
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