package com.example.nguyenhuytoan.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.nguyenhuytoan.entity.UserEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert
    void insertUser(UserEntity user);

    @Query("select * from User")
    List<UserEntity> getAllUser();
}
