package com.example.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
                    PhotoGalleryLayout()
                }
            }
        }
    }
}

@Composable
fun PhotoGalleryLayout(
    imageBridge: Int, @StringRes textBridge: Int, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageBridge),
            contentDescription = stringResource(id = textBridge),
            modifier = modifier
                .size(width = 200.dp, height = 400.dp)
                .align(CenterHorizontally)
        )
        Text(text = stringResource(id = textBridge))
    }

}

@Composable
fun PhotoGalleryLayout(modifier: Modifier = Modifier) {
    var bridgeName by remember { mutableStateOf(0) }

    when (bridgeName) {

        0 -> PhotoGalleryLayout(
            imageBridge = R.drawable.damiano_baschiera, textBridge = R.string.damiano_baschiera
        )

        1 -> PhotoGalleryLayout(
            imageBridge = R.drawable.davide_ragusa, textBridge = R.string.davide_ragusa
        )

        else -> PhotoGalleryLayout(
            imageBridge = R.drawable.img_android_plug, textBridge = R.string.android_plug
        )

    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(onClick = { bridgeName++ }) {
            Text(text = "previous")
        }
        Button(onClick = { bridgeName-- }) {
            Text(text = "next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhotoGalleryAppPreview() {
    PhotoGalleryTheme {
        PhotoGalleryLayout()
    }
}