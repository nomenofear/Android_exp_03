# About

安卓UI组件：ListVIew，AlertDialog，OptionMenu，ActionMode的一些练习。

> ### 一、ListView

 实现效果：

 ![ListView效果](https://github.com/nomenofear/Android_exp_03/raw/master/ListView/img/Snipaste_2019-03-24_19-08-03.png)



ListView单击Toast弹出TextView的文本，并更改背景颜色，松开恢复背景颜色。

这是ListView的布局文件

activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <ListView
        android:id="@+id/listview1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        ></ListView>

</LinearLayout>

activity_main_item.xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="horizontal"
    android:background="@drawable/tvbg">

    <TextView
        android:id="@+id/textview1"
        android:layout_weight="1"
        android:layout_width="wrap_content"
        android:layout_height="50dp"
        android:gravity="center"
        android:textSize="18sp"
        android:textStyle="bold"
       android:textColor="#FF201E1E"
        android:textAlignment="center"
        android:layout_marginLeft="20dp"
        />

    <ImageView
        android:id="@+id/imageview1"
        android:layout_width="47dp"
        android:layout_height="55dp"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_gravity="center"
        android:layout_marginEnd="10dp"
        android:layout_marginRight="10dp"
        android:layout_weight="1"
        android:scaleType="fitCenter"
        android:src="@drawable/dog" />

</RelativeLayout>
```


这是MainActivity，putData()为填充数据的方法返回一个List<Map<String,Object>

```java
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
```

> ### 二、AlertDialog

 实现效果:

 ![AlertDialog](https://github.com/nomenofear/Android_exp_03/raw/master/AlertDialog/img/sp20190324_084533_903.png)

布局代码:

```xml
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imgview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:src="@drawable/head"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="45sp"
        android:layout_marginTop="8dp"
        android:ems="10"
        android:hint="UserName"
        android:inputType="textPersonName"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imgview" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="match_parent"
        android:layout_height="45sp"
        android:layout_marginTop="8dp"
        android:ems="10"
        android:hint="Password"
        android:inputType="textPassword"
        android:textSize="18sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />

    <Button
        android:id="@+id/button"
        android:layout_width="88dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:gravity="center_horizontal"
        android:text="Login"
        android:textSize="16sp"
        app:layout_constraintEnd_toEndOf="@+id/editText2"
        app:layout_constraintHorizontal_bias="0.485"
        app:layout_constraintStart_toStartOf="@+id/editText2"
        app:layout_constraintTop_toBottomOf="@+id/editText2" />
</android.support.constraint.ConstraintLayout>
```

MainActivity:

```java
AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog ad = builder.create();
        
        View view = View.inflate(MainActivity.this,R.layout.login_layout,null);
        ad.setView(view);
        ad.show();

        final EditText etName = (EditText) view.findViewById(R.id.editText);
        final EditText etPwd = (EditText) view.findViewById(R.id.editText2);
        Button btnLogin = (Button) view.findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                String pwd;
                name = etName.getText().toString();
                pwd = etPwd.getText().toString();
                if("".equals(name.trim()) || "".equals(pwd.trim())){
                    Toast.makeText(MainActivity.this,"用户名密码不能为空",Toast.LENGTH_SHORT).show();
                    return ;
                }
               Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
            }
        });
```



> ### 三、OptionMenu

 实现效果：

 ![这是menu](https://github.com/nomenofear/Android_exp_03/raw/master/OptionMenu/img/Snipaste_2019-03-24_20-41-54.png)

 ![更改字体大小](https://github.com/nomenofear/Android_exp_03/raw/master/OptionMenu/img/Snipaste_2019-03-24_09-50-16.png)

 ![普通菜单项Toast弹出文本](https://github.com/nomenofear/Android_exp_03/raw/master/OptionMenu/img/Snipaste_2019-03-24_09-49-51.png)

 ![更改字体颜色](https://github.com/nomenofear/Android_exp_03/raw/master/OptionMenu/img/Snipaste_2019-03-24_09-48-21.png)

Menu的xml配置文件:

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
     <group
          android:id="@+id/group1">
          <item
              android:id="@+id/item1"
              android:orderInCategory="1"
               android:title="字体大小">
               <menu>
               <group android:id="@+id/group_2">
                    <item android:id="@+id/sub_1" android:title="小"/>
                    <item android:id="@+id/sub_2" android:title="中"/>
                    <item android:id="@+id/sub_3" android:title="大"/>
               </group>
               </menu>
          </item>
          <item
               android:id="@+id/item2"
               android:orderInCategory="2"
               android:title="普通菜单项"/>
          <item
               android:id="@+id/item3"
               android:orderInCategory="3"
               android:title="改变颜色">
               <menu>
                    <group>
                         <item android:id="@+id/sub_4" android:title="红色"></item>
                         <item android:id="@+id/sub_5" android:title="黑色"></item>
                    </group>
               </menu>
          </item>
     </group>
</menu>
```



在MainActivity中重写了onCreateOptionsMenu()和onOptionsItemSelected()方法:

```java
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
```



> ### 四、ListView配合ActionMode

 实现效果：

 ![ActionMode](https://github.com/nomenofear/Android_exp_03/raw/master/ActionMode/img/Snipaste_2019-03-24_16-31-35.png)

Menu的配置文件,main.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item android:id="@+id/op_test1"
        android:icon="@mipmap/leftic" android:title="确定"
        app:showAsAction="always"/>
    <item android:id="@+id/op_test2" android:icon="@mipmap/rightic" android:title="删除"
        app:showAsAction="always"/>
</menu>
```

布局文件activity_main_item.xml和activity_main.xml:

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/textView1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TV1"
        android:textSize="40sp" />

</LinearLayout>
```

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <ListView
        android:id="@+id/listview1"
        android:entries="@array/names"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"></ListView>

</LinearLayout>
```

MainActivity:

```java
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
```
***
>要使用ActionMode需要实现ActionMode.Callback接口，并处理ActionMode的生命周期 ：
>onCreateActionMode(ActionMode,menu) 
>onPrepareActionMode(ActionMode,menu) 
>onActionItemClicked(ActionMode,menuItem) onDestroyActionMode(ActionMode)
***
------

#### **end**
