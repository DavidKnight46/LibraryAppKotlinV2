package com.example.libraryserviceandroidv2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.example.libraryserviceandroidv2.databinding.LayouteditactivityBinding
import com.example.libraryserviceandroidv2.libraryservice.adapters.EditGameAdapter
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GenreText
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.PlatformText
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GameList
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import java.util.stream.Collectors

class EditActivity : AppCompatActivity() {
    private lateinit var appDatabase: AppDatabase
    private lateinit var binding: LayouteditactivityBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayouteditactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        lifecycleScope.launch {
            appDatabase = MyDataBaseBuilder.getInstance(applicationContext)

            var mutableListOf = mutableListOf<GameEntity>()

            GameList.getGameList().stream().forEach {
                e -> mutableListOf.add(e)
            }

            var arrayAdapter = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_spinner_item,
                mutableListOf
            )

            binding.gamesToEdit.adapter = arrayAdapter
            var editGameAdapter =
                EditGameAdapter(
                    binding.fragmentViewContainer.findViewById(R.id.gameNameInput),
                    binding.fragmentViewContainer.findViewById(R.id.releaseDateInput),
                    binding.fragmentViewContainer.findViewById(R.id.imageUrlInput),
                    binding.fragmentViewContainer.findViewById(R.id.saveButton),
                    binding.fragmentViewContainer.findViewById(R.id.ratingBar),
                    binding.fragmentViewContainer.findViewById(R.id.platFormSpinner),
                    binding.fragmentViewContainer.findViewById(R.id.genreSpinner)
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