package com.example.contextmenu;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.listview1);
        //  String[] name= {"LV1","LV2","LV3"};
        // registerForContextMenu(lv);
        //多选用MultiChoiceModeListener
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.parseColor("#36adcf"));

                startActionMode(new MyActionModeCallback());
                return false;
            }
        });
    }

    private class MyActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // ActionMode创建，定义menu菜单。
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.main, menu);

            /* 实现左侧视图的自定义
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_actionmode_custom_view, null, false);
             mode.setCustomView(view);*/
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // ActionMode工作前的预先处理
            mode.setTitle("1 selected");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // menu菜单Item点击回调
            if (item.getItemId() == R.id.op_test2) {

                Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                mode.finish();
            }
            else if(item.getItemId() == R.id.op_test1){
                Toast.makeText(MainActivity.this,"Finish",Toast.LENGTH_SHORT).show();
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // ActionMode模式结束处理（点击左侧取消，或者点击返回键结束ActionMode模式）。
            // ActionMode.finish()执行后会结束ActionMode模式，此时会执行这里。

        }
    }


  /*  private class MyCallback implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.op_test1:
                    Toast.makeText(MainActivity.this,"warning!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.op_test2:
                    Toast.makeText(MainActivity.this,"favourite!",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }*/
}



           /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
    }
*/



