package com.example.menu;

import android.content.ClipData;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Infalte the menu
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item2){
            Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id == R.id.sub_1){
            TextView tv = (TextView) findViewById(R.id.textview1);
            tv.setTextSize(10);
            return true;
        }
        else if(id == R.id.sub_2){
            TextView tv = (TextView) findViewById(R.id.textview1);
            tv.setTextSize(16);
            return true;
        }
        else if(id == R.id.sub_3){
            TextView tv = (TextView) findViewById(R.id.textview1);
            tv.setTextSize(20);
            return true;
        }
        else if(id == R.id.sub_4){
            TextView tv = (TextView) findViewById(R.id.textview1);
            tv.setTextColor(Color.RED);
            return true;
        }
        else if(id == R.id.sub_5){
            TextView tv = (TextView) findViewById(R.id.textview1);
            tv.setTextColor(Color.BLACK);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
