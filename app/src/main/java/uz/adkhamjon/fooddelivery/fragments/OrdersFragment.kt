package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {
    private lateinit var binding:FragmentOrdersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentOrdersBinding.inflate(inflater, container, false)
        if(arguments!=null){
            binding.back.visibility=View.GONE
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).showToolbar()
        (activity as FoodActivity).showBottomNav()
    }

    override fun onResume() {
        super.onResume()
        (activity as FoodActivity).hideToolbar()
    }
}