package uz.adkhamjon.fooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.adkhamjon.fooddelivery.databinding.NotificationItemBinding

class NotificationRvAdapter( var list: List<Int>, var onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<NotificationRvAdapter.MyViewHolder>(){
    inner class MyViewHolder(var notificationItemBinding: NotificationItemBinding): RecyclerView.ViewHolder(
        notificationItemBinding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            NotificationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


    }
    override fun getItemCount(): Int {
        return list.size
    }
    interface OnItemClickListener {
        fun onItem(position:Int)
    }
}