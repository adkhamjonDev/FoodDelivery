package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayoutMediator
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.FoodTypeRvAdapter
import uz.adkhamjon.fooddelivery.adapters.MyPagerAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentFoodTypeBinding
import uz.adkhamjon.fooddelivery.models.ExampleModel
import uz.adkhamjon.fooddelivery.viewmodels.SharedViewModel

class BusinessLunchFragment : Fragment() {
    private lateinit var binding:FragmentFoodTypeBinding
    private lateinit var myPagerAdapter: MyPagerAdapter
    private lateinit var categoryList:ArrayList<String>
    private lateinit var viewModel: SharedViewModel
    private var tittle:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentFoodTypeBinding.inflate(inflater, container, false)
        if(arguments!=null){
            tittle=requireArguments().getString("tittle")as String
        }
        (activity as FoodActivity).setTittle(tittle)
        viewModel= ViewModelProviders.of(requireActivity())[SharedViewModel::class.java]

        viewModel.getData().observe(viewLifecycleOwner,object:Observer<ExampleModel>{
            override fun onChanged(t: ExampleModel?) {
                binding.soupImage.setImageResource(t?.image!!)
            }
        })
        loadData()
        myPagerAdapter= MyPagerAdapter(requireActivity(),categoryList)
        binding.viewPager.adapter=myPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = categoryList[position]
        }.attach()
        binding.soupImage.setOnClickListener {
            removeSoup()
        }
        return binding.root
    }

    private fun loadData() {
        categoryList= ArrayList()
        categoryList.add("Soup")
        categoryList.add("Burgers")
        categoryList.add("Drinks")
    }

    fun removeSoup(){
        binding.soupImage.setImageResource(R.drawable.ic_circle_white)
    }
    fun removeMainFood(){
        binding.soupImage.setImageResource(R.drawable.ic_launcher_background)
    }
    fun removeDrink(){
        binding.soupImage.setImageResource(R.drawable.ic_launcher_background)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as FoodActivity).hideBottomNav()
        (activity as FoodActivity).hideBell()
    }
    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).setTittle("")
        (activity as FoodActivity).showBottomNav()
        (activity as FoodActivity).showBell()
    }
}