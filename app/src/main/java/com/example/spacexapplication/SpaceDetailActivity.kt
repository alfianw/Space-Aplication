package com.example.spacexapplication

import Space
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class SpaceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val space = intent.getParcelableExtra<Space>("SPACE_EXTRA")

        space?.let {
            val tvName: TextView = findViewById(R.id.tvNameDetail)
            val tvDescription: TextView = findViewById(R.id.tvDescriptionDetail)
            val tvAverage: TextView = findViewById(R.id.tvAverageDetail)
            val tvCharacter: TextView = findViewById(R.id.tvCharacterDetail)
            val imgPhoto: ImageView = findViewById(R.id.imgDetail)

            tvName.text = it.name.orEmpty()
            tvDescription.text = it.descriptor.orEmpty()
            tvAverage.text = "Average: ${it.averange.orEmpty()}"  // Menampilkan average jika tidak null
            tvCharacter.text = "Character: ${it.character.orEmpty()}"  // Menampilkan character jika tidak null
            imgPhoto.setImageResource(it.photo ?: R.drawable.ic_launcher_foreground)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
