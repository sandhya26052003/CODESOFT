package com.example.quote

import kotlin.random.Random

data class Quote(val text: String, val author: String)

class QuoteManager {
    private val quotes = listOf(
        Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
        Quote("Life is what happens when you're busy making other plans.", "John Lennon"),
        Quote("The purpose of our lives is to be happy.", "Dalai Lama"),
        Quote("Get busy living or get busy dying.", "Stephen King"),
        Quote("You only live once, but if you do it right, once is enough.", "Mae West"),
        Quote("Many of life's failures are people who did not realize how close they were to success when they gave up.", "Thomas A. Edison"),
        Quote("If you want to live a happy life, tie it to a goal, not to people or things.", "Albert Einstein"),
        Quote("Never let the fear of striking out keep you from playing the game.", "Babe Ruth"),
        Quote("Money and success don’t change people; they merely amplify what is already there.", "Will Smith"),
        Quote("Your time is limited, so don’t waste it living someone else’s life.", "Steve Jobs")
    )

    fun getRandomQuote(): Quote {
        return quotes[Random.nextInt(quotes.size)]
    }
}

