package uz.adkhamjon.fooddelivery.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.SplashActivity
import uz.adkhamjon.fooddelivery.adapters.MyPagerAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentMainLoginBinding

class MainLoginFragment : Fragment() {
    private lateinit var binding: FragmentMainLoginBinding
    private lateinit var myPagerAdapter: MyPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentMainLoginBinding.inflate(inflater, container, false)
//        myPagerAdapter= MyPagerAdapter(requireContext(),childFragmentManager,binding.tablayout.tabCount)
//        binding.viewPager.adapter=myPagerAdapter
//        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tablayout))
//        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                binding.viewPager.currentItem = tab.position
//            }
//            override fun onTabUnselected(tab: TabLayout.Tab) {
//
//            }
//            override fun onTabReselected(tab: TabLayout.Tab) {
//
//            }
//        })
//        binding.viewPager.setOnTouchListener(View.OnTouchListener { v, event -> true })

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(requireContext(), FoodActivity::class.java))
        }
        return binding.root
    }
}