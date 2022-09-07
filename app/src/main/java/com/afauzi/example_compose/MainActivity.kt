package com.afauzi.example_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.example_compose.ui.theme.ExamplecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Akhmad Fauzi", "Luar Biasa"))
                }
            }
        }
    }

    data class Message(val author: String, val body: String)


    @Composable
    fun MessageCard(msg: Message){
       Row(
           modifier = Modifier
               .padding(15.dp)
       ) {
           Image(
               painter = painterResource(id = R.drawable.ic_launcher_background),
               contentDescription = "Example photo",
               modifier = Modifier
                   // Set Image Size
                   .size(40.dp)
                   // Clip image to be shaped as a circle
                   .clip(CircleShape)
                   .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
           )
           Spacer(modifier = Modifier.width(4.dp))
           Column {
               Text(msg.author, color = MaterialTheme.colors.secondary)
               Text(msg.body)
           }
       }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MaterialTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                MessageCard(Message("Akhmad Fauzi", "Luar Biasa"))
            }
        }
    }
}