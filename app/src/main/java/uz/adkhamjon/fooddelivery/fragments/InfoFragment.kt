package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.databinding.FragmentInfoBinding
import uz.adkhamjon.fooddelivery.db.AppDataBase
import uz.adkhamjon.fooddelivery.models.ExampleModel2

class InfoFragment : Fragment() {
    private lateinit var binding:FragmentInfoBinding
    private var exampleModel:ExampleModel2?=null
    private lateinit var appDataBase: AppDataBase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentInfoBinding.inflate(inflater, container, false)
        appDataBase= AppDataBase.getInstance(requireContext())
        if(arguments!=null){
            exampleModel=requireArguments().getSerializable("object")as ExampleModel2
        }
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.like.setOnClickListener {
            appDataBase.scannerDao().addLiked(exampleModel!!)
            binding.like.visibility=View.GONE
            binding.unLike.visibility=View.VISIBLE
        }
        binding.unLike.setOnClickListener {
            appDataBase.scannerDao().removeLiked(exampleModel!!)
            binding.like.visibility=View.VISIBLE
            binding.unLike.visibility=View.GONE
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }
    override fun onResume() {
        super.onResume()
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).showToolbar()
    }
}