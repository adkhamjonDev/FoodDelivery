package uz.adkhamjon.fooddelivery.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.adkhamjon.fooddelivery.fragments.FoodTypePagerFragment


class MyPagerAdapter(fragmentActivity: FragmentActivity,var list:List<String>): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
       return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return FoodTypePagerFragment()
    }

}