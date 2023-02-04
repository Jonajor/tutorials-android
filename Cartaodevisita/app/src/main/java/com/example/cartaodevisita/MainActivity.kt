package com.example.cartaodevisita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaodevisita.ui.theme.CartaoDeVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaoDeVisitaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NameCompletedScreen()
                }
            }
        }
    }
}

@Composable
fun NameCompletedScreen() {
    Surface(color = Color(0xFF024750)){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(R.drawable.android_logo)
            Image(painter = image, contentDescription = null)
            Text(
                text = "Jonathan Jorge",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE4EDE5),
                modifier = Modifier.padding(top = 34.dp, bottom = 8.dp)
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3ddc84),
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(top = 8.dp, bottom = 40.dp)
            )
            ContactInformation("+00 (00)000 000", "@socialmediahandler", "email@domain.com")

        }
    }
}

@Composable
fun ContactInformation(phone: String, user: String, email: String) {
    Column {
        Row {
            Icon(Icons.Rounded.Call, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(text = phone, color = Color.White, textAlign = TextAlign.Justify)
        }
        Row {
            Icon(Icons.Rounded.Share, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(text = user, color = Color.White, textAlign = TextAlign.Justify)
        }
        Row {
            Icon(Icons.Rounded.Email, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(text = email, color = Color.White, textAlign = TextAlign.Justify)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CartaoDeVisitaTheme {
        NameCompletedScreen()
    }
}