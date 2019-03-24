package com.example.exp_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview1);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,putData(),R.layout.activity_main_item,
                new String[]{"Name","Photo"},new int[] {R.id.textview1,R.id.imageview1});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(R.id.textview1);

                Toast.makeText(MainActivity.this, tv.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        //  listView.setAdapter(simpleAdapter);
    }

    public List<Map<String,Object>> putData() {
        //
        Map<String, Object> item1 = new HashMap<String,Object>();
        item1.put("Name", "Monkey");
        item1.put("Photo", R.drawable.monkey);

        Map<String, Object> item2 = new HashMap<String,Object>();
        item2.put("Name", "Lion");
        item2.put("Photo", R.drawable.lion);

        Map<String, Object> item3 = new HashMap<String,Object>();
        item3.put("Name", "Cat");
        item3.put("Photo", R.drawable.cat);

        Map<String, Object> item4 = new HashMap<String,Object>();
        item4.put("Name", "Dog");
        item4.put("Photo", R.drawable.dog);

        Map<String, Object> item5 = new HashMap<String,Object>();
        item5.put("Name", "Elephant");
        item5.put("Photo", R.drawable.elephant);
        Map<String, Object> item6 = new HashMap<String,Object>();
        item6.put("Name", "Tiger");
        item6.put("Photo", R.drawable.tiger);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        return list;
    }

}
