package uz.adkhamjon.fooddelivery.fragments
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.MainActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.MyPagerAdapter2
import uz.adkhamjon.fooddelivery.databinding.FragmentHomeBinding
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryList:ArrayList<String>
    private lateinit var myPagerAdapter2: MyPagerAdapter2
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        loadCategory()
        myPagerAdapter2= MyPagerAdapter2(categoryList,requireActivity())
        binding.viewPager.adapter=myPagerAdapter2
        TabLayoutMediator(binding.tablayout,binding.viewPager
        ) { tab, position -> tab.text = categoryList[position] }.attach()
        binding.search.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
            (activity as FoodActivity).hideBottomNav()
            (activity as FoodActivity).hideToolbar()
        }
        return binding.root
    }

    private fun loadCategory() {
        categoryList=ArrayList<String>()
        categoryList.add("Foods")
        categoryList.add("Drinks")
        categoryList.add("Snacks")
        categoryList.add("Sauce")
    }
}