package uz.adkhamjon.fooddelivery.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.databinding.FragmentMainLoginBinding
import android.text.Editable

import android.text.TextWatcher
import android.widget.Toast


class MainLoginFragment : Fragment() {
    private lateinit var binding: FragmentMainLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentMainLoginBinding.inflate(inflater, container, false)


        binding.loginBtn.setOnClickListener {
            startActivity(Intent(requireContext(), FoodActivity::class.java))
            activity?.finish()
//            val toString = binding.code.text.toString()
//            Toast.makeText(requireContext(), toString, Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}