package com.tishukoff.playzonekmp.android

import GamesRepository
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import di.Inject.instance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)

        val gamesRepository = instance<GamesRepository>()

        CoroutineScope(context = Dispatchers.IO).launch {
            val game = gamesRepository.searchGame("a")

            withContext(Dispatchers.Main) {
                textView.text = "Game name: ${game.firstOrNull()?.title}"
            }
        }
    }
}