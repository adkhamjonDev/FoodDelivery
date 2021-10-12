package uz.adkhamjon.fooddelivery.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.BannerPagerAdapter
import uz.adkhamjon.fooddelivery.adapters.HomeRvRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentHomeBinding
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryList:ArrayList<String>
    private lateinit var categoryList2:ArrayList<String>
    private lateinit var homeRvRvAdapter: HomeRvRvAdapter
    private lateinit var bannerPagerAdapter:BannerPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        loadCategory()
        bannerPagerAdapter= BannerPagerAdapter(requireContext(),categoryList)
        binding.viewpager.adapter=bannerPagerAdapter
        binding.search.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
            (activity as FoodActivity).hideBottomNav()
            (activity as FoodActivity).hideToolbar()
        }
        homeRvRvAdapter= HomeRvRvAdapter(requireContext(),categoryList2,object :HomeRvRvAdapter.OnItemClickListener{
            override fun onItem(position: Int) {

            }
        })
        binding.recView.adapter=homeRvRvAdapter
        return binding.root
    }
    private fun loadCategory() {
        categoryList=ArrayList()
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")

        categoryList2=ArrayList()
        categoryList2.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        categoryList2.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        categoryList2.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        categoryList2.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        categoryList2.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
        categoryList2.add("https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg")
    }
}