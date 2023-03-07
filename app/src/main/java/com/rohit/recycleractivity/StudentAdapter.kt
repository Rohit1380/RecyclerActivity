package com.rohit.recycleractivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohit.recycleractivity.databinding.ItemRvLayoutBinding

class StudentAdapter (val studentlist:ArrayList<StudentModel>,var clickInterface:ClickInterface):RecyclerView.Adapter<StudentAdapter.viewHolder>() {
    class viewHolder(val binding:ItemRvLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding=ItemRvLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.tvName.text=studentlist[position].name
        holder.binding.tvRollNo.text=studentlist[position].rollNo
        holder.itemView.setOnClickListener {
            clickInterface.editClick(position)
        }
    }
    override fun getItemCount(): Int {

        return studentlist.size
    }
}