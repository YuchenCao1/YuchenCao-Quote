package com.example.quote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.quote.ui.theme.QuoteTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuoteApp(modifier: Modifier = Modifier) {
    val quotes = listOf(
        "The best way to predict the future is to create it.",
        "Do not watch the clock. Do what it does. Keep going.",
        "The only limit to our realization of tomorrow is our doubts of today.",
        "Act as if what you do makes a difference. It does.",
        "Success is not how high you have climbed, but how you make a positive difference to the world.",
        "The only way to achieve the impossible is to believe it is possible.",
        "Success is not final, failure is not fatal: It is the courage to continue that counts.",
        "The future belongs to those who believe in the beauty of their dreams.",
        "Hard work beats talent when talent doesn't work hard.",
        "Your limitation—it's only your imagination.",
        "Push yourself, because no one else is going to do it for you.",
        "Dream it. Wish it. Do it.",
        "Great things never come from comfort zones.",
        "Don’t stop when you’re tired. Stop when you’re done.",
        "The harder you work for something, the greater you'll feel when you achieve it.",
        "Success doesn’t just find you. You have to go out and get it.",
        "Wake up with determination. Go to bed with satisfaction.",
        "Do something today that your future self will thank you for.",
        "Little things make big days.",
        "It’s going to be hard, but hard does not mean impossible.",
        "Don’t wait for opportunity. Create it.",
        "Sometimes we’re tested not to show our weaknesses, but to discover our strengths.",
        "The key to success is to focus on goals, not obstacles.",
        "You don’t have to be great to start, but you have to start to be great.",
        "Believe in yourself, take on your challenges, dig deep within yourself to conquer fears."
    )


    var currentQuoteIndex by remember { mutableStateOf(0) }

    fun changeQuote() {
        currentQuoteIndex = Random.nextInt(quotes.size)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = quotes[currentQuoteIndex],
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { changeQuote() },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        ){
            Text(text = "Change Quote", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteAppPreview() {
    QuoteTheme {
        QuoteApp()
    }
}
