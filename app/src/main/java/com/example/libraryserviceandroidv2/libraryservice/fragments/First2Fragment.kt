package com.example.libraryserviceandroidv2.libraryservice.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.libraryserviceandroidv2.databinding.FragmentFirst2Binding
import com.example.libraryserviceandroidv2.libraryservice.adapters.GenreSpinnerAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.ImageUrlContentListener
import com.example.libraryserviceandroidv2.libraryservice.adapters.PlatformSpinnerAdapter
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.GenreText
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.PlatformText
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.IsAdded
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class First2Fragment : Fragment() {

    private lateinit var genreSpinnerAdapter: GenreSpinnerAdapter
    private lateinit var platformSpinnerAdapter: PlatformSpinnerAdapter
    private lateinit var appDatabase: AppDatabase

    private var _binding: FragmentFirst2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        appDatabase = MyDataBaseBuilder.getInstance(requireContext());

        genreSpinnerAdapter = GenreSpinnerAdapter()
        platformSpinnerAdapter = PlatformSpinnerAdapter()

        _binding = FragmentFirst2Binding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.delete.isVisible = !IsAdded.getIsAdded()

        binding.genreSpinner.onItemSelectedListener = genreSpinnerAdapter
        binding.platFormSpinner.onItemSelectedListener = platformSpinnerAdapter

        var gameEntity: GameEntity

        binding.imageUrlInput.setOnReceiveContentListener(null, ImageUrlContentListener())

        binding.saveButton.setOnClickListener {
            gameEntity = GameEntity(
                0,
                binding.gameNameInput.text.toString(),
                GenreText.getGenre(),
                PlatformText.getPlatform(),
                binding.ratingBar.rating,
                binding.releaseDateInput.text.toString(),
                binding.imageUrlInput.text.toString()
            )

            saveToDatabase(gameEntity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveToDatabase(gameEntity: GameEntity){
        lifecycleScope.launch {
            appDatabase.gameDao().insertAll(gameEntity)
        }
    }

}