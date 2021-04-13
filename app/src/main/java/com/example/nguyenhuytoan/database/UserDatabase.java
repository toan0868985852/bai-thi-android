package com.example.nguyenhuytoan.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nguyenhuytoan.dao.UserDao;
import com.example.nguyenhuytoan.entity.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase userDatabase;

    public abstract UserDao userDao();

    public static UserDatabase getUserDatabase(Context context){
        if (userDatabase == null){
            userDatabase = Room.databaseBuilder(context,
                    UserDatabase.class, "User.db").allowMainThreadQueries().build();
        }
        return userDatabase;
    }
}
