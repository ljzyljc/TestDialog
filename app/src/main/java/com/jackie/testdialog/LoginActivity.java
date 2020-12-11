package com.jackie.testdialog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/13
 */
public class LoginActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnLogin;
    private EditText username,password;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        textView = findViewById(R.id.tvLoginSuccess);
        btnLogin = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = String.format(username.getText().toString());
                Log.i(TAG, "onClick: ================"+u + "    |"+"jackie123@gmail.com");
                Log.i(TAG, "onClick: ================"+password.getText().toString() + "    |"+"123456");
                // && password.getText().toString().equals("123456")
                if (u.equals("jackie123@gmail.com")){
                    textView.setText("登录成功");
                } else {
                    textView.setText("登录失败");
                }
            }
        });

    }
}
