package uz.adkhamjon.fooddelivery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.adkhamjon.fooddelivery.databinding.SearchItemBinding

class SearchRvAdapter(var context: Context,var list: List<String>, var onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<SearchRvAdapter.MyViewHolder>(){
    inner class MyViewHolder(var searchItemBinding: SearchItemBinding): RecyclerView.ViewHolder(
        searchItemBinding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(list[position]).into(holder.searchItemBinding.image)
        holder.searchItemBinding.card1.setOnClickListener {
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