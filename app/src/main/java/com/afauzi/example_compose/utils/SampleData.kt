package com.afauzi.example_compose.utils

import com.afauzi.example_compose.model.Message

object SampleData {
    private val message1 = Message("akhmad", "Hello")
    private val message2 = Message("fauzi", "Hello yaaaaaaa")
    val conversationSample = arrayListOf(message1, message2)
}