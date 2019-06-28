/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-28 16:15
 * Description: 个人信息Dao
 */
package com.wpf.bookreaderkotlin.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserInfoDao {

    /**
     * 新增一位用户
     */
    @Insert
    fun addUser(userInfo: UserInfo)

    /**
     * 删除一位用户
     */
    @Delete
    fun deleteUser(userInfo: UserInfo)

    /**
     * 更新一位用户
     */
    @Update
    fun updateUser(userInfo: UserInfo)

    /**
     * 根据id查询用户信息
     */
    @Query("SELECT * FROM UserInfo WHERE id = (:id)")
    fun getUserById(id: Long): LiveData<UserInfo>

    /**
     * 根据用户名查询用户信息
     */
    @Query("SELECT * FROM UserInfo WHERE name = (:name)")
    fun getUserByName(name: String): LiveData<UserInfo>
}