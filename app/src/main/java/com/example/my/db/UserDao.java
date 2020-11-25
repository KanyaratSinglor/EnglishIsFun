package com.example.my.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.my.model.User;


@Dao
public interface UserDao {

  //ดึง list ของผู้เล่นจาก database ที่เรียงลำดับตามคะแนน
  @Query("SELECT * FROM users ORDER BY point DESC ")
  User[] getAllUsers();

  @Query("SELECT * FROM users WHERE id = :id")
  User getUserById(int id);

  //เพิ่มผู้เล่น
  @Insert
  void addUser(User... users);

  @Delete
  void deleteUser(User user);

  @Update
  void updateUser(User user);

  @Query("DELETE FROM users")
  void delete();
}
