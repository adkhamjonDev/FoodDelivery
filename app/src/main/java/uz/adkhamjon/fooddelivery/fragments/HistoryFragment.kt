package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding:FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentHistoryBinding.inflate(inflater, container, false)



        return binding.root
    }
}