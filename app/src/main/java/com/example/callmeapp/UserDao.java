package com.example.callmeapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE email LIKE :email LIMIT 1")
    User findByEmail(String email);

    @Insert
    void insertAll(User... users);

    @Insert
    void insert(User users);

    @Delete
    void delete(User user);
}