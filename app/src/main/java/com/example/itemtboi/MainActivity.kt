package com.example.itemtboi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CollectibleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewCollectibles)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Пример данных (замените на загрузку из базы/JSON)
        val collectibles = listOf(
            Collectible(1, "The Sad Onion", "Increases tear rate"),
            Collectible(2, "The Inner Eye", "Triple shot"),
            Collectible(3, "Spoon Bender", "Homing tears")
            // Добавьте все ваши предметы
        )

        adapter = CollectibleAdapter(collectibles, this)
        recyclerView.adapter = adapter
    }
}
