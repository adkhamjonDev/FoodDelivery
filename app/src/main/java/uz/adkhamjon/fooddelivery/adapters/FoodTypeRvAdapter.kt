package uz.adkhamjon.fooddelivery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.adkhamjon.fooddelivery.databinding.TypeCustomItemBinding

class FoodTypeRvAdapter(var context: Context, var list:List<Int>, var onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<FoodTypeRvAdapter.MyViewHolder>(){
    inner class MyViewHolder(var typeCustomItemBinding: TypeCustomItemBinding): RecyclerView.ViewHolder(
        typeCustomItemBinding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TypeCustomItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
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