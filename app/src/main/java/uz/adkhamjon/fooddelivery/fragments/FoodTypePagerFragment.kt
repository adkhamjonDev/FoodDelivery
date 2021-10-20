package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.viewbinding.ViewBinding
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.FoodTypeRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentFoodTypePagerBinding
import uz.adkhamjon.fooddelivery.models.ExampleModel
import uz.adkhamjon.fooddelivery.viewmodels.SharedViewModel

class FoodTypePagerFragment : Fragment() {
    private lateinit var typeRvAdapter: FoodTypeRvAdapter
    private lateinit var list:ArrayList<Int>
    private lateinit var binding:FragmentFoodTypePagerBinding
    private lateinit var viewmodel:SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentFoodTypePagerBinding.inflate(inflater, container, false)
        loadData()
        viewmodel= ViewModelProviders.of(requireActivity())[SharedViewModel::class.java]
        typeRvAdapter= FoodTypeRvAdapter(requireContext(),list,object :FoodTypeRvAdapter.OnItemClickListener{
            override fun onItem(position: Int) {
                viewmodel.setData(ExampleModel("example",R.drawable.food))
            }
        })
        binding.rv.adapter=typeRvAdapter
        return binding.root
    }
    private fun loadData() {
        list= ArrayList()
        for (i in 0 until 10){
            list.add(1)
        }
    }
}