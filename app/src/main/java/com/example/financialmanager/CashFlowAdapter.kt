package com.example.financialmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialmanager.databinding.ItemRowCashFlowBinding

class CashFlowAdapter(private val itemList: List<CashFlowItem>): RecyclerView.Adapter<CashFlowAdapter.ViewHolder>() {
    class ViewHolder(private val binding:ItemRowCashFlowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CashFlowItem){
            binding.textTitle.text = item.name
            binding.textAmount.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowCashFlowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

}