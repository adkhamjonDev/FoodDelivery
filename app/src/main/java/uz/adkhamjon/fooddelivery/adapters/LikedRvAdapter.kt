package uz.adkhamjon.fooddelivery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.adkhamjon.fooddelivery.databinding.LikedItemBinding
import uz.adkhamjon.fooddelivery.databinding.SearchItemBinding
import uz.adkhamjon.fooddelivery.models.ExampleModel2

class LikedRvAdapter(var context: Context, var list: List<ExampleModel2>, var onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<LikedRvAdapter.MyViewHolder>(){
    inner class MyViewHolder(var likedItemBinding: LikedItemBinding): RecyclerView.ViewHolder(
        likedItemBinding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LikedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(list[position].image).into(holder.likedItemBinding.image)
        holder.likedItemBinding.card1.setOnClickListener {
            onItemClickListener.onItem(list[position])
        }
        holder.likedItemBinding.unLike.setOnClickListener {
            onItemClickListener.onItemRemove(position,list[position])
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }
    interface OnItemClickListener {
        fun onItem(exampleModel2:ExampleModel2)
        fun onItemRemove(pos:Int,exampleModel2:ExampleModel2)
    }
}