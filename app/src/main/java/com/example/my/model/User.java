package com.example.my.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "users")
public class User {

  @PrimaryKey(autoGenerate = true)
  public final int id;

  @ColumnInfo(name = "nick_name")
  public final String name;

  @ColumnInfo(name = "point")
  public final int point;

  public User(int id, String name, int point) {
    this.id = id;
    this.name = name;
    this.point = point;
  }


}
