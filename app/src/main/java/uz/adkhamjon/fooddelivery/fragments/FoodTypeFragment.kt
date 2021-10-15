package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.FoodTypeRvAdapter
import uz.adkhamjon.fooddelivery.adapters.MyPagerAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentFoodTypeBinding
import uz.adkhamjon.fooddelivery.models.ExampleModel

private const val ARG_PARAM1 = "param1"
class FoodTypeFragment : Fragment() {
    private var param1: ExampleModel? = null
    private lateinit var binding:FragmentFoodTypeBinding
    private lateinit var myPagerAdapter: MyPagerAdapter
    private lateinit var categoryList:ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentFoodTypeBinding.inflate(inflater, container, false)
        (activity as FoodActivity).setTittle("Veggie tomato")
        categoryList= ArrayList()
        categoryList.add("Soup")
        categoryList.add("Main Food")
        categoryList.add("Drinks")
        myPagerAdapter= MyPagerAdapter(requireActivity(),categoryList)
        binding.viewPager.adapter=myPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = categoryList[position]
        }.attach()
        return binding.root
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
    companion object {
        @JvmStatic
        fun newInstance(exampleModel: ExampleModel) =
            FoodTypeFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, exampleModel)
                }
            }
    }
}