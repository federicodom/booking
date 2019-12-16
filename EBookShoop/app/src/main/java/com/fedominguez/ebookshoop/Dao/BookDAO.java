package com.fedominguez.ebookshoop.Dao;

import com.fedominguez.ebookshoop.model.Book;
import com.fedominguez.ebookshoop.model.Category;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface BookDAO {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT * FROM  ` books_table`")
    LiveData<List<Book>> getAllBooks();

    @Query("SELECT * FROM  ` books_table` WHERE category_id ==:categoryId")
    LiveData<List<Book>> getAllBooksByCategory(int categoryId);

}
