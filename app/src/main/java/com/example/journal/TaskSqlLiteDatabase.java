package com.example.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TaskSqlLiteDatabase  extends SQLiteOpenHelper {

    public TaskSqlLiteDatabase(@Nullable Context context) {
        super(context, "db_user", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE user (id integer PRIMARY KEY,Name varchar(20),Phone varchar(8))";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete_db = "DROP TABLE IF EXISTS user";
        db.execSQL(delete_db);
        onCreate(db);

    }
    public void CreateUser(User newUser)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("Name",newUser.getName());
        data.put("Phone",newUser.getPhone());
        db.insert("user",null,data);

    }
    public ArrayList<User> ReadALLUser() {
        ArrayList<User> array_user= new ArrayList<>();
//        begin
        SQLiteDatabase db = getReadableDatabase();
        String sql_getAll = "SELECT * FROM user";
        Cursor my_cursor = db.rawQuery(sql_getAll,null);
        if(my_cursor.moveToFirst())
        {
            do {
                int id = my_cursor.getInt(0);
                String User_name = my_cursor.getString(1);
                String User_phone = my_cursor.getString(2);
                array_user.add(new User(id,User_name,User_phone));

            }while(my_cursor.moveToNext());
        }
        return array_user;
        }
        public void UpdateUser( User newUser)
        {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues data = new ContentValues();
            data.put("Name",newUser.getName());
            data.put("Phone",newUser.getPhone());

            db.update("user",data,"id = ?",new String[]{String.valueOf(newUser.getId())});
    }
    public void DeleteUser( User newUser)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put("Name",newUser.getName());
        data.put("Phone",newUser.getPhone());

        db.delete("user","id=?",new String[]{String.valueOf(newUser.getId())});
    }

}
