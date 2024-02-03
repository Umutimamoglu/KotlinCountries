package com.hope.kotlincountries.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hope.kotlincountries.R
import com.hope.kotlincountries.model.Country
import com.hope.kotlincountries.databinding.ItemCountryBinding // Eklenen satır
import com.hope.kotlincountries.util.dowloadFromUrl
import com.hope.kotlincountries.util.placeHolderProgressBar
import com.hope.kotlincountries.view.FeedFragmentDirections

class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country, parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.country = countryList[position]

        holder.binding.root.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.binding.imageView.dowloadFromUrl(countryList[position].imageUrl,
            placeHolderProgressBar(holder.binding.root.context)
        )
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}




















