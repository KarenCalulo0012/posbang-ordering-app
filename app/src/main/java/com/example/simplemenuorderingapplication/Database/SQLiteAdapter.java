package com.example.simplemenuorderingapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.simplemenuorderingapplication.Model.Categories;
import com.example.simplemenuorderingapplication.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class SQLiteAdapter extends SQLiteOpenHelper {

    // Database Information
    static final String DB_NAME = "simpleOrderApp.db";

    // Table Name
    public static final String CATEGORY_TABLE = "category";
    public static final String FOOD_TABLE = "food";
    public static final String FOOD_ORDER_TABLE = "foodOrder";
    public static final String ORDER_TABLE = "orders";
    public static final String DISCOUNT_TABLE = "discount";

    // Common column names
    private static final String KEY_ID = "id";

    // CATEGORY Table - column names
    private static final String KEY_CATEGORY_NAME = "category_name";
    public static final String KEY_CATEGORY_PIC = "category_pic";

    // FOOD Table - column names
    private static final String KEY_FOOD_NAME = "food_name";
    public static final String KEY_CATEGORY_ID = "category_id";
    public static final String KEY_FOOD_PRICE = "food_price";
    public static final String KEY_FOOD_TAX = "food_tax";
    public static final String KEY_FOOD_PIC = "food_pic";

    // FOOD_ORDER Table - column names
    private static final String KEY_FOOD_ID = "food_id";
    private static final String KEY_ORDER_ID = "order_id";
    private static final String KEY_FOOD_ORDER_QTY = "quantity";

    // ORDERS Table - column names
    private static final String KEY_DISCOUNT_ID = "discount_id";
    private static final String KEY_ORDER_TOTAL = "total";
    private static final String KEY_ORDER_TAX = "tax_total";

    // DISCOUNT Table - column names
    private static final String KEY_DISCOUNT_TYPE = "discount_type";
    private static final String KEY_DISCOUNT_PERCENT = "percent";

    // database version
    static final int DB_VERSION = 1;

    List<Categories> categoriesList = new ArrayList<>();


    public SQLiteAdapter(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String category_table = "CREATE TABLE "+ CATEGORY_TABLE +"(id INTEGER PRIMARY KEY, category_name TEXT, category_pic BLOB)";
        String food_table = "CREATE TABLE "+FOOD_TABLE +"(id INTEGER PRIMARY KEY,category_id INTEGER, food_name TEXT, food_price REAL,food_tax REAL,food_pic BLOB)";
        String food_order_table = "CREATE TABLE "+ FOOD_ORDER_TABLE +"(id INTEGER PRIMARY KEY, food_id INTEGER, order_id INTEGER,quantity INTEGER)";
        String order_table = "CREATE TABLE "+ ORDER_TABLE +"(id INTEGER PRIMARY KEY,discount_id INTEGER, total REAL, tax_total REAL)";
        String discount_table = "CREATE TABLE "+ DISCOUNT_TABLE +"(id INTEGER PRIMARY KEY, discount_type TEXT, percent REAL)";

        db.execSQL(category_table);
        db.execSQL(food_table);
        db.execSQL(food_order_table);
        db.execSQL(order_table);
        db.execSQL(discount_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ CATEGORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ FOOD_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ FOOD_ORDER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ ORDER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ DISCOUNT_TABLE);
        onCreate(db);
    }

    public boolean insertCategory(Categories categories){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY_NAME,categories.getCategoryName());
        values.put(KEY_CATEGORY_PIC,categories.getImage());
        long res = db.insert(CATEGORY_TABLE, null, values);
        if (res ==-1) return false;
        else return true;
    }

}
