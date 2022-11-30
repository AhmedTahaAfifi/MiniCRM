package com.example.minicrm.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.minicrm.R
import com.example.minicrm.database.model.MiniCrm
import com.example.minicrm.databinding.ItemCustomarBinding


class CustomerAdapter(private var items:List<MiniCrm?>?): RecyclerView.Adapter<CustomerAdapter.ViewHolder> (){
    class ViewHolder(private val viewDataBinding: ItemCustomarBinding):RecyclerView.ViewHolder(viewDataBinding.root){
        fun bind(customer: MiniCrm?){
            viewDataBinding.item = customer
            viewDataBinding.invalidateAll()


        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewDataBinding:ItemCustomarBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_customar,parent,false)

        return ViewHolder(viewDataBinding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items!![position])
        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(position,holder.bind(items!![position]))
        }
        }

    @SuppressLint("NotifyDataSetChanged")
    fun changeData(newItems:MutableList<MiniCrm>) {
        items = newItems
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return items?.size?:0
    }

   lateinit var onClickListener: OnClickListener

   interface OnClickListener {
       fun onItemClick(position: Int, itemView: Unit)
   }

}


