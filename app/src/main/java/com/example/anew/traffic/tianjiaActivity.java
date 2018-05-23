package com.example.anew.traffic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class tianjiaActivity extends AppCompatActivity {
    private static final String DB_TABLE = "Traffic";
    private MyDbHelper dbHelper;
    private SQLiteDatabase mydb;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianjia);

        text = (TextView) findViewById(R.id.text);

        dbHelper = new MyDbHelper(this, "Traffic.db", null, 1);
        mydb = dbHelper.getWritableDatabase();

        Cursor c=mydb.query(true,DB_TABLE,new String[]{"road","lukuang"},null,null,null,null,null,null);
        if(c==null)
            return;
        if(c.getCount()==0){
            text.setText(" ");
            Toast.makeText(tianjiaActivity.this,"没有数据",Toast.LENGTH_SHORT).show();
        }
        else{
            c.moveToFirst();
            text.setText(c.getString(0)+c.getString(1));
            while (c.moveToNext())
                text.append("\n"+c.getString(0)+c.getString(1));
        }
    }




}
