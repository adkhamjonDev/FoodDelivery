package uz.adkhamjon.fooddelivery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.adkhamjon.fooddelivery.databinding.FoodItemBinding
import uz.adkhamjon.fooddelivery.databinding.NotificationItemBinding

class HomeRvRvAdapter(var context: Context, var list:List<String>,var onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<HomeRvRvAdapter.MyViewHolder>(){
    inner class MyViewHolder(var foodItemBinding: FoodItemBinding): RecyclerView.ViewHolder(
        foodItemBinding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            FoodItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(list[position]).into(holder.foodItemBinding.image)
        holder.foodItemBinding.card1.setOnClickListener {
            onItemClickListener.onItem(position)
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }
    interface OnItemClickListener {
        fun onItem(position:Int)
    }
}