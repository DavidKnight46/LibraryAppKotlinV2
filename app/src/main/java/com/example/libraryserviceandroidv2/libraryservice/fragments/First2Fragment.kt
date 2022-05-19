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
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.databinding.FragmentFirst2Binding
import com.example.libraryserviceandroidv2.libraryservice.adapters.GenreSpinnerAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.PlatformSpinnerAdapter
import com.example.libraryserviceandroidv2.libraryservice.client.game.LibraryServiceGameClientImpl
import com.example.libraryserviceandroidv2.libraryservice.database.AppDatabase
import com.example.libraryserviceandroidv2.libraryservice.database.MyDataBaseBuilder
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity
import com.example.libraryserviceandroidv2.libraryservice.gameobjects.*
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import kotlinx.coroutines.GlobalScope
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

        getActivity()?.setTitle(R.string.editTitle)

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

        binding.preOrderSwitchAdd.setText("Is Pre-order?")

        binding.saveButton.setOnClickListener {

            binding.saveButton.isEnabled = false

            GlobalScope.launch {
                var id = GameList.getGameList().last().id

                var gameModel = GameModel(
                    ++id,
                    User.getId().toInt(),
                    binding.gameNameInput1.text.toString(),
                    GenreText.getGenre(),
                    PlatformText.getPlatform(),
                    binding.ratingBar.rating,
                    binding.imageUrlInput.text.toString(),
                    binding.preOrderSwitchAdd.isChecked,
                    binding.releaseDateInput.text.toString()
                )

                var libraryServiceGameClientImpl = LibraryServiceGameClientImpl()

                libraryServiceGameClientImpl.addAnGame(gameModel)

                clearScreen()

                binding.saveButton.isEnabled = true
            }
        }
    }

    fun clearScreen(){
        binding.gameNameInput1.text?.clear()
        binding.imageUrlInput.text?.clear()
        binding.releaseDateInput.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveToDatabase(gameEntity: GameEntity) {
        lifecycleScope.launch {
            appDatabase.gameDao().insertAll(gameEntity)
        }
    }

}