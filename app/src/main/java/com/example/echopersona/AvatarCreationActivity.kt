package com.example.echopersona

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class AvatarCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_avatar_creation)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create Avatar"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.avatarCreationPage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Personality chips selection
        val chipGroup = findViewById<ChipGroup>(R.id.personalityChipGroup)
        val personalities = listOf("Chill 😎", "Sarcastic 😏", "Gamer 🎮", "Deep Talks 🧠",
            "Funny 😂", "Romantic 💙", "Savage 🔥", "Wholesome 🌸")

        personalities.forEach { label ->
            val chip = Chip(this)
            chip.text = label
            chip.isCheckable = true
            chip.setChipBackgroundColorResource(android.R.color.transparent)
            chip.setTextColor(getColor(android.R.color.white))
            chip.chipStrokeWidth = 2f
            chip.setChipStrokeColorResource(android.R.color.holo_blue_light)
            chipGroup.addView(chip)
        }

        val createBtn = findViewById<Button>(R.id.createEchoBtn)
        createBtn.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}