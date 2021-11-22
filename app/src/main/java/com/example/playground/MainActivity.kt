package com.example.playground

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.NameNotFoundException
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
            Greeting("Android")
            Text(text = "Version = " + versionNumber(context))
          }
        }
      }
    }
  }
}

private fun versionNumber(context: Context): String {
  return try {
    val pInfo: PackageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0)
    pInfo.versionName
  } catch (e: NameNotFoundException) {
    "Unknown"
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  PlaygroundTheme {
    Greeting("Android")
  }
}