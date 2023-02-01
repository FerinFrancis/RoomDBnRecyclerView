package com.example.practiceroomdb.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practiceroomdb.R
import com.example.practiceroomdb.data.User
import com.example.practiceroomdb.data.UserViewModel
import com.example.practiceroomdb.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.addBtn.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }

    private fun insertDataToDatabase() {
        val firstName = binding.addFirstNameEt.text.toString()
        val lastName = binding.addLastNameEt.text.toString()
        val age = binding.addAgeEt.text.toString()

        if(inputCheck(firstName, lastName, age)){
            val user = User(0,firstName,lastName,age.toInt())
            mUserViewModel.addUser(user)
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireActivity(),"Please fill all fields",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName:String, age: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(age))
    }

}