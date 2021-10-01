package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.NotificationRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private lateinit var binding:FragmentNotificationBinding
    private lateinit var notificationRvAdapter: NotificationRvAdapter
    private lateinit var list: ArrayList<Int>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentNotificationBinding.inflate(inflater, container, false)
        list= ArrayList()
        for (i in 0 until 10){
            list.add(1)
        }
        notificationRvAdapter= NotificationRvAdapter(list,object:NotificationRvAdapter.OnItemClickListener{
            override fun onItem(position: Int) {

            }
        })
        binding.recView.adapter=notificationRvAdapter
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }
    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).showToolbar()
        (activity as FoodActivity).showBottomNav()
    }

    override fun onResume() {
        super.onResume()
        (activity as FoodActivity).hideToolbar()
        (activity as FoodActivity).hideBottomNav()
    }
}