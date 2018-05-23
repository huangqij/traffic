package com.example.anew.traffic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyDbHelper dbHelper;
    private SQLiteDatabase mydb;
    private TextView textView;
    private EditText editname;
    private EditText edittext;
    private Button add;
    private Button button;

    private static final String DB_TABLE = "Traffic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.jilv);
        TextPaint paint = textView.getPaint();
        paint.setFakeBoldText(true);

        editname = (EditText) findViewById(R.id.editname);
        edittext = (EditText) findViewById(R.id.edittext);
        add = (Button) findViewById(R.id.add);
       button=(Button) findViewById(R.id.button);


        dbHelper = new MyDbHelper(this, "Traffic.db", null, 1);
        mydb = dbHelper.getWritableDatabase();

        add.setOnClickListener(btnaddonclick);
        button.setOnClickListener(btnonclick);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mydb.close();
    }

    private View.OnClickListener btnaddonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues newRow = new ContentValues();
            newRow.put("road", editname.getText().toString());
            newRow.put("lukuang", edittext.getText().toString());

            mydb.insert(DB_TABLE, null, newRow);
            editname.setText("");
            edittext.setText("");
        }
    };
    private View.OnClickListener btnonclick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent=new Intent(MainActivity.this,tianjiaActivity.class);
            startActivity(intent);
        }
    };


}
