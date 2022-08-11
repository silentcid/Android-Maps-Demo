package com.bottlerocketstudios.mapsdemo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bottlerocketstudios.compose.GoogleMapsView
import com.bottlerocketstudios.mapsdemo.ui.theme.AndroidMapsDemoTheme
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Secrets Gradle Plugin is being used here. To give Places the API Key use BuildConfig
        // to get the variable.
        Places.initialize(applicationContext, BuildConfig.MAPS_API_KEY)
        val placesClient = Places.createClient(this)
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
