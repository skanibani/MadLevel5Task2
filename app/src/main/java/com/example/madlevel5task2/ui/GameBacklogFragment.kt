package com.example.madlevel5task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R

import com.example.madlevel5task2.databinding.FragmentGameBacklogBinding
import com.example.madlevel5task2.model.Game
import java.util.*

class GameBacklogFragment : Fragment() {

    private var _binding: FragmentGameBacklogBinding? = null
    private val binding get() = _binding!!

    private val backlogGames = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(backlogGames)

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGameBacklogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Provider handles
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        initViews()

        observeViewModel()
    }

    private fun initViews() {
        binding.rvGames.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvGames.adapter = gameAdapter
    }

    private fun observeViewModel() {
        viewModel.games.observe(viewLifecycleOwner, Observer<List<Game>> {
            backlogGames.addAll(it)
            gameAdapter.notifyDataSetChanged()
        })
    }

    // Voor de zekerheid
    override fun onResume() {
        super.onResume()
        observeViewModel()
    }
}