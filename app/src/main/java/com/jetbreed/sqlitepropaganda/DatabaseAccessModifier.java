package com.jetbreed.sqlitepropaganda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessModifier extends SQLiteOpenHelper {

    public static final String JAVAMOVIE = "JAVAMOVIE";
    public static final String DURATION = "DURATION";
    public static final String MOVIENAME = "MOVIENAME";
    public static final String RATINGBAR = "RATINGBAR";
    public static final String YEAR = "YEAR";
    public static final String PYTHONMOVIE = "PYTHONMOVIE";
    public static final String REACTMOVIE = "REACTMOVIE";
    public static final String GENDER = "GENDER";
    public static final String MSSQLMOVIE = "MSSQLMOVIE";
    public static final String MOVIEWREVIEW = "MOVIEWREVIEW";
    public static final String ID = "ID";

    public DatabaseAccessModifier(@Nullable Context context)
    {
        super(context, "moviereview.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + MOVIEWREVIEW + " " +
                "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MOVIENAME + " TEXT, " +
                YEAR + " INT, " +
                DURATION + " INT, " +
                RATINGBAR + " FLOAT, " +
                PYTHONMOVIE + " TEXT, " +
                REACTMOVIE + " TEXT, " +
                GENDER + " TEXT, " +
                MSSQLMOVIE + " TEXT, " +
                JAVAMOVIE + " TEXT" +
                ")";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(MoviewReview moviewReview){
        SQLiteDatabase db = this.getWritableDatabase();

//        StringBuilder sb = new StringBuilder();
//        sb.append("b");
//        sb.append("r");
//        sb.append("y");
//        sb.append("a");
//        sb.append("n");
//
//        System.out.println(sb);

        ContentValues cv = new ContentValues();
        cv.put(JAVAMOVIE, moviewReview.getJavaMovie());
        cv.put(DURATION, moviewReview.getDuration());
        cv.put(MSSQLMOVIE, moviewReview.getMssqlMovie());
        cv.put(REACTMOVIE, moviewReview.getReactMovie());
        cv.put(PYTHONMOVIE, moviewReview.getPythonMovie());
        cv.put(RATINGBAR, moviewReview.getRatingBar());
        cv.put(YEAR, moviewReview.getYear());
        cv.put(MOVIENAME, moviewReview.getmovie_name());
        cv.put(GENDER, moviewReview.isFemale());
        cv.put(GENDER, moviewReview.isMale());

        long insert = db.insert(MOVIEWREVIEW, null, cv);

        if(insert == -1){
            return false;
        }
        else{
            return true;
        }

    }


    public boolean deleteOne(MoviewReview moviewReview){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + MOVIEWREVIEW + " WHERE " + ID + " = " + moviewReview.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }


    public List<MoviewReview> getResultList(){
        List<MoviewReview> resultset = new ArrayList<>();

        String queryAll = "SELECT * FROM " + MOVIEWREVIEW;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryAll, null);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String movie_name = cursor.getString(1);
                int year = cursor.getInt(2);
                int duration = cursor.getInt(3);
                float ratingBar = cursor.getFloat(4);
                String pythonMovie = cursor.getString(5);
                String reactMovie = cursor.getString(6);
                String gender = cursor.getString(7);
                String mssqlMovie = cursor.getString(8);
                String javaMovie = cursor.getString(9);
//                String male = cursor.getString(10);
//                boolean gender = cursor.getInt(9) == 1 ? true : false;

                MoviewReview moviewReview = new MoviewReview(
                        id, movie_name, pythonMovie,
                        reactMovie, mssqlMovie,
                        javaMovie, year, duration,
                        ratingBar, gender, gender
                );
                resultset.add(moviewReview);
            }
            while (cursor.moveToNext());
        }
        else
        { }

        cursor.close();
        db.close();
        return resultset;

        }
    }

