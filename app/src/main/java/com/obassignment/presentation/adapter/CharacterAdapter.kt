package com.obassignment.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.obassignment.databinding.CharacterItemBinding
import com.obassignment.domain.model.charaterlistModel.ResultModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private var listener: ((ResultModel) -> Unit)?=null
    var list = mutableListOf<ResultModel>()

    fun setContent(list: MutableList<ResultModel>){
        this.list = list
        notifyDataSetChanged()
    }


    class MyViewHolder(val viewHolder: CharacterItemBinding):
        RecyclerView.ViewHolder(viewHolder.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.MyViewHolder {
       val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding)
    }

    fun itemClickListener(result: (ResultModel) -> Unit){
      listener = result
    }

    override fun onBindViewHolder(holder: CharacterAdapter.MyViewHolder, position: Int) {
        holder.viewHolder.result = this.list[position]
        holder.viewHolder.root.setOnClickListener {
            listener?.let {
                it(this.list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return  this.list.size
    }
}