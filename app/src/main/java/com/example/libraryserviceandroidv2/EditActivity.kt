package com.example.libraryserviceandroidv2

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.libraryserviceandroidv2.databinding.LayouteditactivityBinding
import com.example.libraryserviceandroidv2.libraryservice.adapters.EditGameAdapter
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
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
            binding.gamesToEdit.onItemSelectedListener =
                EditGameAdapter(
                    binding.fragmentViewContainer.findViewById(R.id.gameNameInput),
                    binding.fragmentViewContainer.findViewById(R.id.releaseDateInput),
                    binding.fragmentViewContainer.findViewById(R.id.imageUrlInput),
                    binding.fragmentViewContainer.findViewById(R.id.saveButton)
                )
        }
    }
}