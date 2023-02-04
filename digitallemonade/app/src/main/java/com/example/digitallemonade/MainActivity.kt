package com.example.digitallemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.digitallemonade.ui.theme.DigitalLemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitalLemonadeTheme {
                // A surface container using the 'background' color from the theme
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf( 1) }
    val (phrase, imageResource) = when (result) {
        1 -> Pair("Tap the lemon tree to select a lemon", R.drawable.lemon_tree)
        2 -> Pair("Keep tapping the lemon to squeeze it", R.drawable.lemon_squeeze)
        3 -> Pair("Tap the lemonade to drink it", R.drawable.lemon_drink)
        else -> Pair("Tap the empty glass to start again", R.drawable.lemon_restart)
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = phrase, textAlign = TextAlign.Justify)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { result += 1 }) {

            Image(painter = painterResource(imageResource), contentDescription = result.toString())

            if (result > 4) result = 1
        }
    }
}