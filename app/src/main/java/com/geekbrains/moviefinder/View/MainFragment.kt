package com.geekbrains.moviefinder.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.moviefinder.R
import com.geekbrains.moviefinder.Repository.Adapters.HorizontalRecyclerAdapter
import com.geekbrains.moviefinder.Repository.AppState
import com.geekbrains.moviefinder.Repository.Model.Movie
import com.geekbrains.moviefinder.ViewModel.MainViewModel
import com.geekbrains.moviefinder.databinding.MainFragmentBinding
import com.google.android.material.snackbar.Snackbar
import com.geekbrains.moviefinder.Repository.Adapters.OnItemViewClickListener as OnItemViewClickListener1

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = HorizontalRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getMovieFromLocalSource()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialization()
    }

    private fun initialization() {
        binding.mainRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }
        binding.lookingRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }
        binding.upcomingRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val movieData = appState.movieData
                adapter.addItems(appState.movieData)
                binding.loadingPopular.visibility = View.GONE
                binding.loadingLookingNow.visibility = View.GONE
                binding.loadingUpComing.visibility = View.GONE

            }
            is AppState.Loading -> {
                binding.loadingPopular.visibility = View.VISIBLE
                binding.loadingLookingNow.visibility = View.VISIBLE
                binding.loadingUpComing.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                binding.loadingPopular.visibility = View.GONE
                binding.loadingLookingNow.visibility = View.GONE
                binding.loadingUpComing.visibility = View.GONE
                Snackbar
                    .make(binding.mainFragmentView, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.reload)) { viewModel.getMovieFromLocalSource() }
                    .show()
            }
        }
    }

}