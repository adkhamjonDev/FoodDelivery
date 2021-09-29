package uz.adkhamjon.fooddelivery.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.adkhamjon.fooddelivery.fragments.LoginFragment
import uz.adkhamjon.fooddelivery.fragments.SignUpFragment

class MyPagerAdapter(private val myContext: Context, fm: FragmentManager,
                     private var totalTabs: Int)
    : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LoginFragment()
            }
            1 -> {
                SignUpFragment()
            }
            else -> LoginFragment()
        }
    }
}