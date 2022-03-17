package com.example.libraryserviceandroidv2

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.lifecycleScope
import com.example.libraryserviceandroidv2.databinding.ActivityMainBinding
import com.example.libraryserviceandroidv2.databinding.LayouteditactivityBinding
import com.example.libraryserviceandroidv2.libraryservice.adapters.EditGameAdapter
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import kotlinx.coroutines.launch
import java.lang.reflect.Array

class EditActivity : AppCompatActivity() {
    private lateinit var appDatabase : AppDatabase
    private lateinit var binding: LayouteditactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayouteditactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item,
            arrayOf("test1", "test2") )

        binding.gamesToEdit.adapter = arrayAdapter
        binding.gamesToEdit.onItemSelectedListener = EditGameAdapter()

    }

    private fun getMyGames(){
        lifecycleScope.launch {
            appDatabase = MyDataBaseBuilder.getInstance(applicationContext)

            appDatabase.gameDao().getAll()
        }
    }
}