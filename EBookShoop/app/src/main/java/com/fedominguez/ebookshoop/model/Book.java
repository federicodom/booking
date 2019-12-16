package com.fedominguez.ebookshoop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = " books_table" , foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id",
        childColumns = "category_id", onDelete = CASCADE))
public class Book extends BaseObservable {


    @PrimaryKey(autoGenerate = true)
    private int bookId;

    @ColumnInfo(name = "book_name")
    private String bookName;

    @ColumnInfo(name = "unit_price")
    private String unitPrice;

    @ColumnInfo(name = "category_id")
    private int categoryId;

    public Book() {
    }

    public Book(int bookId, String bookName, String unitPrice, int categoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
        notifyPropertyChanged(BR.bookId);
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(BR.bookName);
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        notifyPropertyChanged(BR.unitPrice);
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);
    }

    @Bindable
    public int getBookId() {
        return bookId;
    }
    @Bindable
    public String getBookName() {
        return bookName;
    }
    @Bindable
    public String getUnitPrice() {
        return unitPrice;
    }
    @Bindable
    public int getCategoryId() {
        return categoryId;
    }
}
