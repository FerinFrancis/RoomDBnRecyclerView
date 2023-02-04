package com.example.practiceroomdb.repository

import androidx.lifecycle.LiveData
import com.example.practiceroomdb.data.UserDao
import com.example.practiceroomdb.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}