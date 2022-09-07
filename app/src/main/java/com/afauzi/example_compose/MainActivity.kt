package com.afauzi.example_compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.example_compose.model.Message
import com.afauzi.example_compose.utils.SampleData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                Conversation(SampleData.conversationSample)
            }
        }
    }


    @Composable
    fun MessageCard(msg: Message){

        var isExpanded by remember { mutableStateOf(false)}
        val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface)

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
           Column(modifier = Modifier.clickable{isExpanded = !isExpanded}) {
               Text(msg.author, color = MaterialTheme.colors.secondary)
               Spacer(modifier = Modifier.height(4.dp))
               Surface(
                   shape = MaterialTheme.shapes.medium,
                   elevation = 1.dp,
                   color = surfaceColor,
                   modifier = Modifier
                       .animateContentSize()
                       .padding(1.dp)
               ) {
                   Text(
                       msg.body,
                       modifier = Modifier.padding(4.dp),
                       style = MaterialTheme.typography.body2,
                       maxLines = if (isExpanded) Int.MAX_VALUE else 1
                   )
               }
           }
       }
    }


    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn(content = {
            items(messages) {message ->
                MessageCard(message)
            }
        })
    }

    @Preview(name = "Preview Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        MaterialTheme {
            Conversation(SampleData.conversationSample)
        }
    }

}