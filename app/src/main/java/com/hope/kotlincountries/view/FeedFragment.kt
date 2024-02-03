package com.hope.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hope.kotlincountries.R
import com.hope.kotlincountries.databinding.CountryAdapter
import com.hope.kotlincountries.databinding.FragmentFeedBinding

import com.hope.kotlincountries.viewmodel.FeedViewModel

class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel : FeedViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())
    private lateinit var countryList: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryList = binding.countryList
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        countryList.layoutManager = LinearLayoutManager(context)
        countryList.adapter = countryAdapter



        /*
        binding.fragmentButton.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)

            */
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.countryList.visibility = View.GONE
            binding.countryError.visibility = View.GONE
            binding.countryLoading.visibility = View.VISIBLE
            viewModel.refreshData()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()
        }
    fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer {countries ->
            countries?.let {
                countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })
        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if(it){
                    binding.countryError.visibility = View.VISIBLE
                }else{
                    binding.countryError.visibility = View.GONE
                }
            }
        })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer {  loading ->
            loading?.let {
                if(it){
                    binding.countryLoading.visibility = View.VISIBLE
                    binding.countryList.visibility = View.GONE
                    binding.countryError.visibility = View.GONE
                }
                else{
                    binding.countryLoading.visibility = View.GONE
                }
            }
        })
    }















    }


