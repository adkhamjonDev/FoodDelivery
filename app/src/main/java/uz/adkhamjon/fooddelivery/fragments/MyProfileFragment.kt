package uz.adkhamjon.fooddelivery.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.databinding.CustomToolbarBinding
import uz.adkhamjon.fooddelivery.databinding.FragmentMyProfileBinding
import uz.adkhamjon.fooddelivery.models.ProfileModelExample
import uz.adkhamjon.fooddelivery.viewmodels.ProfileViewModel
import uz.adkhamjon.fooddelivery.viewmodels.SharedViewModel

class MyProfileFragment : Fragment() {
    private lateinit var binding:FragmentMyProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=FragmentMyProfileBinding.inflate(inflater, container, false)
        binding.save.setOnClickListener {
            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val phoneNumber = binding.phone.text.toString()
            val profileModelExample=ProfileModelExample(name, email, phoneNumber)
            binding.name.setText(name)
            binding.email.setText(email)
            binding.phone.setText(phoneNumber)
            binding.name.isEnabled=false
            binding.email.isEnabled=false
            binding.phone.isEnabled=false

        }
        binding.update.setOnClickListener {
            binding.name.isEnabled=true
            binding.email.isEnabled=true
        }
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }
    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).showToolbar()
        (activity as FoodActivity).showBottomNav()
    }
    override fun onResume() {
        super.onResume()
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }
}