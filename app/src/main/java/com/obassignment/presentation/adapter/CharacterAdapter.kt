package com.obassignment.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.obassignment.databinding.CharacterItemBinding
import com.obassignment.domain.model.charaterlistmodel.ResultModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private var listener: ((ResultModel) -> Unit)? = null
    private var list = mutableListOf<ResultModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setContent(list: MutableList<ResultModel>) {
        list.also { this.list = it }
        notifyDataSetChanged()
    }

    class MyViewHolder(val viewHolder: CharacterItemBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    fun itemClickListener(result: (ResultModel) -> Unit) {
        listener = result
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewHolder.result = this.list[position]
        holder.viewHolder.root.setOnClickListener {
            listener?.let {
                it(this.list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}