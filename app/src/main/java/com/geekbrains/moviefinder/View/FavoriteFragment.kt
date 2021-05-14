package com.geekbrains.moviefinder.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.moviefinder.R
import com.geekbrains.moviefinder.ViewModel.FavoriteViewModel
import com.geekbrains.moviefinder.ViewModel.MainViewModel
import com.geekbrains.moviefinder.databinding.FavoriteFragmentBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding: FavoriteFragmentBinding

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    private lateinit var viewModel: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        // TODO: Use the ViewModel
    }
}