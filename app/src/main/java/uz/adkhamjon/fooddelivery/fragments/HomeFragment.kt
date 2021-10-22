package uz.adkhamjon.fooddelivery.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.BannerPagerAdapter
import uz.adkhamjon.fooddelivery.adapters.HomeRvRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentHomeBinding
import uz.adkhamjon.fooddelivery.models.MainRvAdapterModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryList:ArrayList<String>
    private lateinit var categoryList2:ArrayList<MainRvAdapterModel>
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
        homeRvRvAdapter= HomeRvRvAdapter(requireContext(),categoryList2,object :HomeRvRvAdapter.OnItemClickListener{
            override fun onItem(str:String,pos:Int) {
                if(pos==0){
                    findNavController().navigate(R.id.foodTypeFragment, bundleOf("tittle" to str))
                }
                else{
                    findNavController().navigate(R.id.otherFoodFragment, bundleOf("tittle" to str))
                    (activity as FoodActivity).showToolbar()
                }
            }
        })
        binding.recView.adapter=homeRvRvAdapter

        binding.search.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
            (activity as FoodActivity).hideBottomNav()
            (activity as FoodActivity).hideToolbar()
        }

        return binding.root
    }
    private fun loadCategory() {
        categoryList=ArrayList()
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")
        categoryList.add("https://novsushi.ru/upload/iblock/7af/7afd7836ad18a657b1c3e035b355e663.jpg")

        categoryList2=ArrayList()
        categoryList2.add(MainRvAdapterModel("Business Lunch","https://im0-tub-ru.yandex.net/i?id=f3083c8c0bbbf91d263a4ae16439e17e-l&n=13"))
        categoryList2.add(MainRvAdapterModel("Main Dish","https://avatars.mds.yandex.net/i?id=acdd15462f1f68467fac190105b55fab-5232562-images-thumbs&n=13"))
        categoryList2.add(MainRvAdapterModel("Soups","https://avatars.mds.yandex.net/i?id=2a0000017a1158bed3f5e548e43fd5f74a91-4599703-images-thumbs&n=13"))
        categoryList2.add(MainRvAdapterModel("Salads","https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        categoryList2.add(MainRvAdapterModel("Drinks","https://avatars.mds.yandex.net/i?id=de94931e75d7ce0a8279d92bf19140c3-5442367-images-thumbs&n=13"))
        categoryList2.add(MainRvAdapterModel("Snacks","https://avatars.mds.yandex.net/i?id=2a00000179de1ab51ed213537f471128664e-4305079-images-thumbs&n=13"))



        }

}