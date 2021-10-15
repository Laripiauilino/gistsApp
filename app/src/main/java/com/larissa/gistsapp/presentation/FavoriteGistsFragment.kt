package com.larissa.gistsapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.databinding.FragmentGistsBinding
import com.larissa.gistsapp.domain.ClickListener

class FavoriteGistsFragment : Fragment(), ClickListener {

    private lateinit var binding: FragmentGistsBinding
    private lateinit var rvGists: RecyclerView
    private lateinit var gistsAdapter: GistsAdapter
    private lateinit var gistsViewModel: FavoriteGistsViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater ,
        container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGistsBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        gistsViewModel = ViewModelProvider(requireActivity()).get(FavoriteGistsViewModel::class.java)
        gistsViewModel.getFavoriteGists()

        setupRecyclerView()
        setupObserveFavoriteGistList()
    }

    private fun setupRecyclerView() {
        gistsAdapter = GistsAdapter(requireContext(), this, mutableListOf())
        rvGists = binding.rvGists
        rvGists.adapter = gistsAdapter
        linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvGists.layoutManager = linearLayoutManager
        rvGists.setHasFixedSize(true)

    }

    private fun setupObserveFavoriteGistList() {
        gistsViewModel.favoritesLiveData.observe(viewLifecycleOwner,
            { result -> result?.let {
                gistsAdapter.dataSet.clear()
                gistsAdapter.dataSet.addAll(it)
                gistsAdapter.notifyDataSetChanged()
                }
            }
        )
    }

    override fun onFavoriteClickListener(gist: Gist, isChecked: Boolean, position: Int) {
         if (isChecked) {
            if (gist.isFavorite) {
                gist.isFavorite = false
                gistsViewModel.deleteFavorite(gist)
            }
        }
    }
}



