package com.bottlerocketstudios.mapsdemo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bottlerocketstudios.compose.GoogleMapsView
import com.bottlerocketstudios.mapsdemo.ui.theme.AndroidMapsDemoTheme
import com.google.android.libraries.places.api.Places

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidMapsDemoTheme {
                GoogleMapsView(toolbarEnabled = false, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidMapsDemoTheme {
        GoogleMapsView(toolbarEnabled = false, modifier = Modifier.fillMaxSize())
    }
}
