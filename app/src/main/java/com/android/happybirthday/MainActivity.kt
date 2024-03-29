package com.android.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingText(message = "Happy Birthday Sam!", from = "From Emma", modifier = Modifier.padding(8.dp))
                    GreetingImage(message = "Happy Birthday Sam!", from = "From Emma", modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String,  modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.padding(8.dp),
        modifier = modifier.fillMaxSize(),
        content = {
            Text(text = message, fontSize = 75.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
            Text(text = from, fontSize = 36.sp, modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .align(alignment = Alignment.CenterHorizontally))
//            Text("Some text",fontSize =  30.sp, lineHeight = 116.sp)
//            Text("Some more text")
//            Text("Last text")
        }
    )
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.5F)
        GreetingText(message = stringResource(R.string.happy_birthday_text), from = stringResource(R.string.from_text), modifier = Modifier.padding(8.dp))
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Kishore's Preview"
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = "Happy Birthday Sam!", from = "From Emma", modifier = Modifier)
    }
}