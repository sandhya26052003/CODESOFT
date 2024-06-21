package com.example.quote

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var quoteTextView: TextView
    private lateinit var quoteManager: QuoteManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteTextView = findViewById(R.id.quoteTextView)
        quoteManager = QuoteManager()

        displayRandomQuote()

        findViewById<Button>(R.id.refreshButton).setOnClickListener {
            displayRandomQuote()
        }

        findViewById<Button>(R.id.shareButton).setOnClickListener {
            shareQuote()
        }
    }

    private fun displayRandomQuote() {
        val randomQuote = quoteManager.getRandomQuote()
        val formattedQuote = getString(R.string.quote_format, randomQuote.text, randomQuote.author)
        quoteTextView.text = formattedQuote
    }

    private fun shareQuote() {
        val quote = quoteTextView.text.toString()
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, quote)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)))
    }
}
