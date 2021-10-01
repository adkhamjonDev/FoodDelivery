package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=FragmentSearchBinding.inflate(inflater, container, false)
        binding.searchView.background=null
        binding.back.setOnClickListener {
            findNavController().popBackStack()
            (activity as FoodActivity).showBottomNav()
            (activity as FoodActivity).showToolbar()
        }
        return binding.root
    }
}