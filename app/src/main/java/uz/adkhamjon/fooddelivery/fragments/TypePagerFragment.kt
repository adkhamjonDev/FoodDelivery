package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.HomeRvRvAdapter
import uz.adkhamjon.fooddelivery.adapters.NotificationRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentTypePagerBinding

class TypePagerFragment : Fragment() {
    private lateinit var binding: FragmentTypePagerBinding
    private lateinit var homeRvRvAdapter: HomeRvRvAdapter
    private lateinit var list: ArrayList<Int>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=FragmentTypePagerBinding.inflate(inflater, container, false)
        list= ArrayList()
        for (i in 0 until 10){
            list.add(1)
        }
        homeRvRvAdapter= HomeRvRvAdapter(list,object: HomeRvRvAdapter.OnItemClickListener{
            override fun onItem(position: Int) {
                findNavController().navigate(R.id.infoFragment)
                (activity as FoodActivity).hideToolbar()
                (activity as FoodActivity).hideBottomNav()
            }
        })
        binding.recView.adapter=homeRvRvAdapter
        return binding.root
    }
}