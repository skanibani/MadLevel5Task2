package com.example.madlevel5task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R

import com.example.madlevel5task2.databinding.FragmentAddGameBinding
import com.example.madlevel5task2.model.Game
import java.util.*

class AddGameFragment : Fragment() {

    private var _binding: FragmentAddGameBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddGameBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        initViews()
    }

    private fun initViews() {
        binding.fabAddGame.setOnClickListener {
            addGame()
            findNavController().navigate(R.id.action_AddGameFragment_to_GameBacklogFragment)
        }
    }

    private fun addGame() {
        val newGame = Game(
            binding.inputGameTitle.text.toString(),
            binding.inputGamePlatform.text.toString(),
            Calendar.getInstance().time
        )

        viewModel.insertGame(newGame)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}