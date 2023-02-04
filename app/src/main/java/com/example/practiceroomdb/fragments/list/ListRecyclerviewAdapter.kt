package com.example.practiceroomdb.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceroomdb.R
import com.example.practiceroomdb.model.User
import com.example.practiceroomdb.databinding.CustomRowBinding

class ListRecyclerviewAdapter: RecyclerView.Adapter<ListRecyclerviewAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        val binding: CustomRowBinding = holder.getBinding()
        binding.idTxt.text = currentItem.id.toString()
        binding.firstNameTxt.text = currentItem.firstName.toString()
        binding.lastNameTxt.text = currentItem.lastName.toString()
        binding.ageTxt.text = currentItem.age.toString()

        binding.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var binding: CustomRowBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }

        fun getBinding(): CustomRowBinding = binding!!


    }
}