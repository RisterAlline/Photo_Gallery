package com.example.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
                    PhotoGalleryApp(
                        imageBridge = R.drawable.img_android_plug,
                        textBridge = R.string.img_android_plug,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun PhotoGalleryApp(
    imageBridge: Int, @StringRes textBridge: Int, modifier: Modifier = Modifier
) {
    var bridgeHolder by remember { mutableStateOf(0) }

    when (bridgeHolder) {
        0 -> PhotoGalleryApp(
            imageBridge = R.drawable.davide_ragusa, textBridge = R.string.davide_ragusa
        )

        1 -> PhotoGalleryApp(
            imageBridge = R.drawable.damiano_baschiera, textBridge = R.string.damiano_baschiera
        )

        2 -> PhotoGalleryApp(
            imageBridge = R.drawable.evren_aydin, textBridge = R.string.evren_aydin
        )

        3 -> PhotoGalleryApp(
            imageBridge = R.drawable.simon_stratford, textBridge = R.string.simon_stratford
        )

        else -> bridgeHolder = 0
    }
    // Main Content
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "It's Photo Gallery APP", modifier = modifier.padding(16.dp))
        Text(text = "don't you believe me?", modifier = modifier.padding(16.dp))
        Image(
            painter = painterResource(id = imageBridge),
            contentDescription = "Davide Ragusa",
            modifier
                .size(width = 300.dp, height = 150.dp)
                .border(1.dp, Color.Gray),
            alignment = Alignment.CenterStart
        )
        Text(
            text = stringResource(id = textBridge),
            modifier
                .padding(top = 24.dp)
                .border(1.dp, Color.Black)
        )
        // Buttons
        Row(
            modifier = modifier.border(1.dp, Color.Red),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {  } ) {
                Text(text = "Previous")
            }
            Button(onClick = {  } ) {
                Text(text = "Next")
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhotoGalleryAppPreview() {
    PhotoGalleryTheme {
        PhotoGalleryApp(
            imageBridge = R.drawable.img_android_plug,
            textBridge = R.string.img_android_plug,
            modifier = Modifier
        )
    }
}