package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

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

// Lesson 2.3 - Utilizing Image & row library calls.
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource

// Lesson 2.4 - Configuring the Layout
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

// Lesson 3.1 - Understanding ComposeTutorialTheme and Theme.kt
// Lesson 3.2 -> 3.4 - Material Design is built around (3) pillars:
// Lesson *.2 - Color
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme

// Lesson *.3 - Typography

// Lesson *.4 - Shape -> Surface Allows customizing the messages' body shape and elevation
import androidx.compose.material3.Surface


// Lesson 3.5 - Enabling Dark Theme
import android.content.res.Configuration


class MainActivity : ComponentActivity() {
    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        enableEdgeToEdge()


        // setContent "defines the activity's layout where composable functions are called."
        setContent {
            // 'ProjectNameTheme' allows for consistency across the entire app.
            ComposeTutorialTheme { // [3.1] - Allows composable/s style inheritance as defined in Theme.kt.
                Surface( modifier=Modifier.fillMaxSize() ){ // [3.1] - Surfaces relate to our Theme.
                    // Text("Hello World!") // [1.1]
                    MessageCard( Message("Android", "Jetpack Compose") )
                }


            }
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
        MessageCard( "World" )
    }
}
*/

// [2.1] Adding multiple texts
data class Message( val author: String, val body: String )

@Composable
fun MessageCard( msg: Message ) {
    // [2.3] Use of Row
    Row( modifier = Modifier.padding(all = 8.dp) ) { // [2.4] Use of modifiers
        Image(
            painter = painterResource( R.drawable._16047357 ),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size( 40.dp ) // Setting image size to 40 dp
                .clip( CircleShape ) // Clip image to be shaped like a circle
                .border( 2.0.dp, MaterialTheme.colorScheme.primary, CircleShape ) // [3.2] Adding a colored border.
        )


        Spacer( modifier = Modifier.width(8.dp) ) // [2.4] - Adding horizontal space between image and columns.


        Column {// [2.3] - Use of Column
            Text( text = msg.author,
                  color = MaterialTheme.colorScheme.secondary, // [3.2] Adding color to msg.author.
                  style = MaterialTheme.typography.titleSmall // [3.3] Typography
                )

            Spacer( modifier = Modifier.height(4.dp) ) // [2.4] Adding vertical space between author and the message.

            // [3.4] Allows customizing the messages' body shape and elevation
            Surface ( shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp ) {
                Text( text = msg.body,
                      modifier = Modifier.padding(all = 4.dp),
                      style = MaterialTheme.typography.bodyMedium  // [3.3] Typography
                )
            }
        }
    }
}

// [3.5] Enabling dark mode while comparing its Light Mode counterpart.
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Composable
fun PreviewMessageCard(){
    ComposeTutorialTheme { // [3.1]
        Surface { // [3.1]
            MessageCard(
                msg = Message("Nash",
                               "Hey, take a look at this message card example, it's great!")
            )
        }
    }
}

