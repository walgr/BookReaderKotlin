/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-28 16:16
 * Description: 个人信息存储操作类
 */
package com.wpf.bookreaderkotlin.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class UserInfoRepository private constructor(private val userInfoDao: UserInfoDao) {

    fun getUserById(id: Long): LiveData<UserInfo> = userInfoDao.getUserById(id)

    fun getUserByName(name: String): LiveData<UserInfo> = userInfoDao.getUserByName(name)

    suspend fun addUser(userInfo: UserInfo) {
        withContext(IO) {
            userInfoDao.addUser(userInfo)
        }
    }

    suspend fun deleteUser(userInfo: UserInfo) {
        withContext(IO) {
            userInfoDao.deleteUser(userInfo)
        }
    }

    suspend fun updateUser(userInfo: UserInfo) {
        withContext(IO) {
            userInfoDao.updateUser(userInfo)
        }
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: UserInfoRepository? = null

        fun getInstance(userInfoDao: UserInfoDao) =
            instance ?: synchronized(this) {
                instance ?: UserInfoRepository(userInfoDao).also { instance = it }
            }
    }
}