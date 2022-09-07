package com.afauzi.example_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.afauzi.example_compose.ui.theme.ExamplecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Akhmad Fauzi", "Luar Biasa"))
        }
    }

    data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message){
        Text(msg.author)
        Text(msg.body)
    }
}