package com.example.libraryserviceandroidv2.libraryservice.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.databinding.FragmentFirst2Binding
import com.example.libraryserviceandroidv2.libraryservice.adapters.GenreSpinnerAdapter
import com.example.libraryserviceandroidv2.libraryservice.adapters.PlatformSpinnerAdapter
import com.example.libraryserviceandroidv2.libraryservice.client.game.LibraryServiceGameClientImpl
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
    private lateinit var libraryServiceGameClient: LibraryServiceGameClientImpl
    private lateinit var myGameList : ArrayList<GameModel>

    private var _binding: FragmentFirst2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        myGameList = GameList.getGameList()
        GameList.setGameList(myGameList)

        getActivity()?.setTitle(R.string.editTitle)

        _binding = FragmentFirst2Binding.inflate(inflater, container, false)

        genreSpinnerAdapter = GenreSpinnerAdapter(_binding!!.genreSpinner)
        platformSpinnerAdapter = PlatformSpinnerAdapter(_binding!!.platFormSpinner)

        if(!IsAdded.getIsAdded()) {
            _binding?.saveButton?.text = resources.getText(R.string.editGame)
            _binding?.gameNameInput1?.isEnabled = false
        }

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.delete.isVisible = !IsAdded.getIsAdded()

            binding.genreSpinner.onItemSelectedListener = genreSpinnerAdapter
            binding.platFormSpinner.onItemSelectedListener = platformSpinnerAdapter

            binding.preOrderSwitchAdd.setText("Is Pre-order?")

            binding.delete.setOnClickListener {
                var libraryServiceGameClientImpl = LibraryServiceGameClientImpl()

                GlobalScope.launch {
                    libraryServiceGameClientImpl.deleteAnGame(
                        User.getUserName(),
                        binding.gameNameInput1.text.toString()
                    )
                }
            }

            binding.saveButton.setOnClickListener {

                binding.saveButton.isEnabled = false

                GlobalScope.launch {
                    var gameModel = createGameModel()

                    var libraryServiceGameClientImpl = LibraryServiceGameClientImpl()

                    if (IsAdded.getIsAdded()) {
                        libraryServiceGameClientImpl.addAnGame(gameModel)
                    } else {
                        libraryServiceGameClientImpl.updateAnGame(gameModel)
                    }

                    binding.saveButton.isEnabled = true
                }
            }

    }

    private fun createGameModel() : GameModel{
        return GameModel(
            binding.gameNameInput1.text.toString(),
            GenreText.getGenre(),
            PlatformText.getPlatform(),
            binding.ratingBar.rating,
            binding.imageUrlInput.text.toString(),
            binding.preOrderSwitchAdd.isChecked,
            binding.releaseDateInput.text.toString(),
            User.getUserName()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}