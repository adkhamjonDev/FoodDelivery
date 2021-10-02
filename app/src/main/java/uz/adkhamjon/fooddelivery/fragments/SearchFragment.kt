package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.HomeRvRvAdapter
import uz.adkhamjon.fooddelivery.adapters.SearchRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchRvAdapter: SearchRvAdapter
    private lateinit var list: ArrayList<Int>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=FragmentSearchBinding.inflate(inflater, container, false)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
            (activity as FoodActivity).showBottomNav()
            (activity as FoodActivity).showToolbar()
        }
        list= ArrayList()
        for (i in 0 until 10){
            list.add(1)
        }
        searchRvAdapter= SearchRvAdapter(list,object: SearchRvAdapter.OnItemClickListener{
            override fun onItem(position: Int) {
                findNavController().navigate(R.id.infoFragment)
                (activity as FoodActivity).hideToolbar()
                (activity as FoodActivity).hideBottomNav()
            }
        })
        binding.recView.adapter=searchRvAdapter
        return binding.root
    }
}