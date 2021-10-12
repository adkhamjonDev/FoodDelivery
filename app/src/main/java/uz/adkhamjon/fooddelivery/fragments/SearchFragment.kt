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
import uz.adkhamjon.fooddelivery.adapters.SearchRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchRvAdapter: SearchRvAdapter
    private lateinit var list: ArrayList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=FragmentSearchBinding.inflate(inflater, container, false)
        loadCategory()
        binding.back.setOnClickListener {
            findNavController().popBackStack()
            (activity as FoodActivity).showBottomNav()
            (activity as FoodActivity).showToolbar()
        }
        searchRvAdapter= SearchRvAdapter(requireContext(),list,object: SearchRvAdapter.OnItemClickListener{
            override fun onItem(position: Int) {
                findNavController().navigate(R.id.infoFragment)
                (activity as FoodActivity).hideToolbar()
                (activity as FoodActivity).hideBottomNav()
            }
        })
        binding.recView.adapter=searchRvAdapter
        return binding.root
    }
    private fun loadCategory() {
        list=ArrayList()
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        list.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as FoodActivity).hideToolbar()
    }
    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).showToolbar()
    }

    override fun onResume() {
        super.onResume()
        (activity as FoodActivity).hideToolbar()
    }
}