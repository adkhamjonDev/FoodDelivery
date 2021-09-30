package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.databinding.FragmentMyProfileBinding

class MyProfileFragment : Fragment() {
    private lateinit var binding:FragmentMyProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=FragmentMyProfileBinding.inflate(inflater, container, false)
        //(activity as FoodActivity?)?.hideToolbar()


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity?)?.showToolbar()
    }
}