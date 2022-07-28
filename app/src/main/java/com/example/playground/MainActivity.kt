package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext
import com.example.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val context = LocalContext.current
      PlaygroundTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          Column {
            Text(text = "Version code: " + BuildConfig.VERSION_CODE)
            Text(text = "Version name: " + BuildConfig.VERSION_NAME)
          }
        }
      }
    }
  }
}
