package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.FoodTypeRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentFoodTypePagerBinding

class FoodTypePagerFragment : Fragment() {
    private lateinit var typeRvAdapter: FoodTypeRvAdapter
    private lateinit var list:ArrayList<Int>
    private lateinit var binding:FragmentFoodTypePagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentFoodTypePagerBinding.inflate(inflater, container, false)
        loadData()
        typeRvAdapter= FoodTypeRvAdapter(requireContext(),list,object :FoodTypeRvAdapter.OnItemClickListener{
            override fun onItem(position: Int) {
//                val fr=activity?.supportFragmentManager?.findFragmentById(R.id.foodTypeFragment)as FoodTypeFragment
//                fr.setSoup()
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