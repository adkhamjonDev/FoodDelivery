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
import uz.adkhamjon.fooddelivery.adapters.OtherFoodRvAdapter
import uz.adkhamjon.fooddelivery.databinding.FragmentOtherFoodBinding
import uz.adkhamjon.fooddelivery.models.ExampleModel
import uz.adkhamjon.fooddelivery.models.ExampleModel2

class OtherFoodFragment : Fragment() {
    private lateinit var binding:FragmentOtherFoodBinding
    private lateinit var list: ArrayList<ExampleModel2>
    private lateinit var otherFoodRvAdapter: OtherFoodRvAdapter
    private var tittle:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentOtherFoodBinding.inflate(inflater, container, false)
        if(arguments!=null){
            tittle=requireArguments().getString("tittle")as String
        }
        (activity as FoodActivity).setTittle(tittle)
        loadCategory()
        otherFoodRvAdapter= OtherFoodRvAdapter(requireContext(),list,object:OtherFoodRvAdapter.OnItemClickListener{
            override fun onItem(exampleModel: ExampleModel2) {
                findNavController().navigate(R.id.infoFragment, bundleOf("object" to exampleModel))
            }
        })
        binding.recView.adapter=otherFoodRvAdapter
        return binding.root
    }
    private fun loadCategory() {
        list=ArrayList()
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
        list.add(ExampleModel2(name = "Lavash",image = "https://i.pinimg.com/736x/cb/c7/1b/cbc71be3e195319e911d6c6f8816b069.jpg"))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as FoodActivity).hideBottomNav()
        (activity as FoodActivity).hideBell()
    }

    override fun onResume() {
        super.onResume()
        (activity as FoodActivity).hideBottomNav()
        (activity as FoodActivity).hideBell()
    }
    override fun onDestroy() {
        super.onDestroy()
        (activity as FoodActivity).setTittle("")
        (activity as FoodActivity).showBottomNav()
        (activity as FoodActivity).showBell()
    }
}