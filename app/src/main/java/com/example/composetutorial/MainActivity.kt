package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

import com.example.composetutorial.ui.theme.ComposeTutorialTheme


          /* https://developer.android.com/develop/ui/compose/tutorial */

// Lesson 1.1 - Adding A text element to our page w/ a library call.
import androidx.compose.material3.Text

// Lesson 1.2 - Defining a composable function w/ @Composable annot.
import androidx.compose.runtime.Composable

// Lesson 1.3 - Previewing function w/in  Studio for unit testing.
// Can only be used on a function that does not take [PARAMETERS]
import androidx.compose.ui.tooling.preview.Preview

// Lesson 2.2 - Using Column to avoid text on top of each other
import androidx.compose.foundation.layout.Column

// Lesson 2.4 - Utilizing Image & row library calls.
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // setContent "defines the activity's layout where composable functions are called."
        setContent {
            // Text("Hello World!") // [1.1]
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}


/*
@Composable // [1.2]
fun MessageCard(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true) // [1.3] NO PARAMETERS = OKAY
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        MessageCard("World")
    }
}
*/

// [2.1] Adding multiple texts
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message){



    Column { // [2.3] Use of Column
        Text(text = msg.author)
        Text(text = msg.body)
    }
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(
        msg = Message("Nash", "Hey, take a look at this jetpack compost, it's great!")
    )
}

