package com.example.libraryserviceandroidv2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.google.android.material.textfield.TextInputEditText

class EditActivity : AppCompatActivity() {
    private lateinit var appDatabase: AppDatabase

    //private lateinit var binding: LayouteditactivityBinding
    private lateinit var gameNameInputEditText: TextInputEditText

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layouteditactivity)

        //binding = LayouteditactivityBinding.inflate(layoutInflater)

        gameNameInputEditText = findViewById(R.id.gameNameInput1)

        System.out.println("smurf")

        //setContentView(binding.root)

//        lifecycleScope.launch {
//            appDatabase = MyDataBaseBuilder.getInstance(applicationContext)
//
//            var mutableListOf = mutableListOf<GameEntity>()
//
//            GameList.getGameList().stream().forEach {
//                e -> mutableListOf.add(e)
//            }
//
//            var arrayAdapter = ArrayAdapter(
//                applicationContext,
//                android.R.layout.simple_spinner_item,
//                mutableListOf
//            )
//
//            binding.gamesToEdit.adapter = arrayAdapter
//            var gameSelectedListener =
//                GameSelectedListener(
//                    binding.fragmentViewContainer.findViewById(R.id.gameNameInput),
//                    binding.fragmentViewContainer.findViewById(R.id.releaseDateInput),
//                    binding.fragmentViewContainer.findViewById(R.id.imageUrlInput),
//                    binding.fragmentViewContainer.findViewById(R.id.saveButton),
//                    binding.fragmentViewContainer.findViewById(R.id.ratingBar),
//                    binding.fragmentViewContainer.findViewById(R.id.platFormSpinner),
//                    binding.fragmentViewContainer.findViewById(R.id.genreSpinner)
//                )
//
//            binding.gamesToEdit.onItemSelectedListener = gameSelectedListener
//
//            binding.layouteditactivity.findViewById<Button>(R.id.saveButton).setOnClickListener {
//                binding.layouteditactivity.findViewById<Button>(R.id.delete).isEnabled = false
//                val game = gameSelectedListener.getGame()
//                game.gameName = binding.fragmentViewContainer.findViewById<TextInputEditText>(R.id.gameNameInput).text.toString()
//                game.releaseDate = binding.fragmentViewContainer.findViewById<TextInputEditText>(R.id.releaseDateInput).text.toString()
//                game.imageUri = binding.fragmentViewContainer.findViewById<TextInputEditText>(R.id.imageUrlInput).text.toString()
//                game.gamePlatform = PlatformText.getPlatform()
//                game.gameGenre = GenreText.getGenre()
//
//                lifecycleScope.launch {
//                    appDatabase.gameDao().update(game)
//                }
//            }
//
//            binding.layouteditactivity.findViewById<Button>(R.id.delete).setOnClickListener{
//                binding.layouteditactivity.findViewById<Button>(R.id.saveButton).isEnabled = false
//                val game = gameSelectedListener.getGame()
//
//                lifecycleScope.launch {
//                    appDatabase.gameDao().delete(game)
//                }
//            }
//
//        }

    }
}