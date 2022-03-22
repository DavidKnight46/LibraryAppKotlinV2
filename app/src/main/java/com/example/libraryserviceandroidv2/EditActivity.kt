package com.example.libraryserviceandroidv2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.libraryserviceandroidv2.databinding.LayouteditactivityBinding
import com.example.libraryserviceandroidv2.libraryservice.adapters.EditGameAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.gameobjects.GenreText
import com.example.libraryserviceandroidv2.libraryservice.adapters.gameobjects.PlatformText
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {
    private lateinit var appDatabase: AppDatabase
    private lateinit var binding: LayouteditactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayouteditactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        lifecycleScope.launch {
            appDatabase = MyDataBaseBuilder.getInstance(applicationContext)

            var arrayAdapter = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_spinner_item,
                appDatabase.gameDao().getAll()
            )

            binding.gamesToEdit.adapter = arrayAdapter
            var editGameAdapter =
                EditGameAdapter(
                    binding.fragmentViewContainer.findViewById(R.id.gameNameInput),
                    binding.fragmentViewContainer.findViewById(R.id.releaseDateInput),
                    binding.fragmentViewContainer.findViewById(R.id.imageUrlInput),
                    binding.fragmentViewContainer.findViewById(R.id.saveButton),
                    binding.fragmentViewContainer.findViewById(R.id.ratingBar)
                )

            binding.gamesToEdit.onItemSelectedListener = editGameAdapter

            binding.layouteditactivity.findViewById<Button>(R.id.saveButton).setOnClickListener {
                binding.layouteditactivity.findViewById<Button>(R.id.delete).isEnabled = false
                val game = editGameAdapter.getGame()
                game.gameName = binding.fragmentViewContainer.findViewById<TextInputEditText>(R.id.gameNameInput).text.toString()
                game.releaseDate = binding.fragmentViewContainer.findViewById<TextInputEditText>(R.id.releaseDateInput).text.toString()
                game.imageUri = binding.fragmentViewContainer.findViewById<TextInputEditText>(R.id.imageUrlInput).text.toString()
                game.gamePlatform = PlatformText.getPlatform()
                game.gameGenre = GenreText.getGenre()

                lifecycleScope.launch {
                    appDatabase.gameDao().update(game)
                }
            }

            binding.layouteditactivity.findViewById<Button>(R.id.delete).setOnClickListener{
                binding.layouteditactivity.findViewById<Button>(R.id.saveButton).isEnabled = false
                val game = editGameAdapter.getGame()

                lifecycleScope.launch {
                    appDatabase.gameDao().delete(game)
                }
            }

        }

    }
}