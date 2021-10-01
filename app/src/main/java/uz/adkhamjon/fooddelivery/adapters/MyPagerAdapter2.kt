package uz.adkhamjon.fooddelivery.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.adkhamjon.fooddelivery.fragments.LoginFragment
import uz.adkhamjon.fooddelivery.fragments.SignUpFragment
import uz.adkhamjon.fooddelivery.fragments.TypePagerFragment
import androidx.fragment.app.FragmentActivity

import androidx.annotation.NonNull




class MyPagerAdapter2(var list: List<String>,fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return TypePagerFragment()
    }

}