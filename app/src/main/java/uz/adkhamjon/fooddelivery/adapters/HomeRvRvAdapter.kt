package uz.adkhamjon.fooddelivery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.adkhamjon.fooddelivery.databinding.FoodItemBinding
import uz.adkhamjon.fooddelivery.databinding.NotificationItemBinding
import uz.adkhamjon.fooddelivery.models.MainRvAdapterModel

class HomeRvRvAdapter(var context: Context, var list:List<MainRvAdapterModel>,var onItemClickListener: OnItemClickListener):
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
        Glide.with(context).load(list[position].image).into(holder.foodItemBinding.image)
        holder.foodItemBinding.name.text=list[position].name
        holder.itemView.setOnClickListener {
            onItemClickListener.onItem(list[position].name!!,position)
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }
    interface OnItemClickListener {
        fun onItem(str:String,pos:Int)
    }
}