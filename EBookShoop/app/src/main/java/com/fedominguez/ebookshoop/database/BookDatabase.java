package com.fedominguez.ebookshoop.database;

import android.content.Context;
import android.os.AsyncTask;

import com.fedominguez.ebookshoop.Dao.BookDAO;
import com.fedominguez.ebookshoop.Dao.CategoryDAO;
import com.fedominguez.ebookshoop.model.Book;
import com.fedominguez.ebookshoop.model.Category;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Category.class, Book.class},version = 1)
public abstract class  BookDatabase extends RoomDatabase {

    public abstract CategoryDAO categoryDAO();
    public  abstract BookDAO bookDAO();

    private static BookDatabase instance;

    private static  synchronized  BookDatabase getInstance(Context context){

        if( instance == null ){
            instance = Room.databaseBuilder(context,BookDatabase.class,"books_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;

    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };


    private static class InitialDataAsyncTask extends AsyncTask<Void,Void,Void>
}
