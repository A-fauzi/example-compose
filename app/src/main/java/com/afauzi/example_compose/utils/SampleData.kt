package com.afauzi.example_compose.utils

import com.afauzi.example_compose.model.Message

object SampleData {
    private val message1 = Message("akhmad", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ")
    private val message2 = Message("fauzi", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ")
    val conversationSample = arrayListOf(message1, message2)
}