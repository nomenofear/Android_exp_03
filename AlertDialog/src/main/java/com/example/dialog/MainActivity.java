package com.example.dialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }
}
