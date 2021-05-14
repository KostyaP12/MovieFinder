package com.geekbrains.moviefinder.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.moviefinder.R
import com.geekbrains.moviefinder.ViewModel.MainViewModel
import com.geekbrains.moviefinder.ViewModel.RatingViewModel
import com.geekbrains.moviefinder.databinding.RatingFragmentBinding

class RatingFragment : Fragment() {

    private lateinit var binding: RatingFragmentBinding
    companion object {
        fun newInstance() = RatingFragment()
    }

    private lateinit var viewModel: RatingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.rating_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RatingViewModel::class.java)
        // TODO: Use the ViewModel
    }
}