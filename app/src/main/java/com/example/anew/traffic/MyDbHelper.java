package com.example.anew.traffic;

/**
 * Created by new on 2018/3/31.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by new on 2018/3/26.
 */

public class MyDbHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK="create table Traffic("
            +"id integer primary key autoincrement,"
            +"road text,"
            +"lukuang text)";


    private Context mContext;
    public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context,name,factory,version);
        mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext,"creat succeeded",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldversion,int newversion)
    {

    }


}
