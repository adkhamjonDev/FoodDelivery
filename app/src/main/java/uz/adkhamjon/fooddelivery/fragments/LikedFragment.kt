package uz.adkhamjon.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import uz.adkhamjon.fooddelivery.FoodActivity
import uz.adkhamjon.fooddelivery.R
import uz.adkhamjon.fooddelivery.adapters.LikedRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentLikedBinding
import uz.adkhamjon.fooddelivery.db.AppDataBase
import uz.adkhamjon.fooddelivery.models.ExampleModel2

class LikedFragment : Fragment() {
    private lateinit var binding: FragmentLikedBinding
    private lateinit var appDataBase: AppDataBase
    private lateinit var list:ArrayList<ExampleModel2>
    private lateinit var likedRvAdapter: LikedRvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentLikedBinding.inflate(inflater, container, false)
        appDataBase= AppDataBase.getInstance(requireContext())
        list= ArrayList(appDataBase.scannerDao().getAllLiked())
        likedRvAdapter= LikedRvAdapter(requireContext(),list,
            object:LikedRvAdapter.OnItemClickListener{
                override fun onItem(exampleModel: ExampleModel2) {
                    //findNavController().navigate(R.id.infoFragment, bundleOf("object" to exampleModel))
                }

                override fun onItemRemove(pos:Int,exampleModel2: ExampleModel2) {
                    appDataBase.scannerDao().removeLiked(exampleModel2)
                    list.remove(exampleModel2)
                    likedRvAdapter.notifyItemRemoved(pos)
                }
            })
        if(appDataBase.scannerDao().getAllLiked().isNotEmpty()){
            binding.noLikedLayout.visibility=View.GONE
            binding.recView.visibility=View.VISIBLE
        }else{
            binding.noLikedLayout.visibility=View.VISIBLE
            binding.recView.visibility=View.GONE

        }
        binding.recView.adapter=likedRvAdapter
        return binding.root
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