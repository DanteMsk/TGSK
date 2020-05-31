package com.example.tgsk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tgsk.RequestLogic.SentRequest;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button enter;
    private TextView login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        enter = findViewById(R.id.buttonEnter);
        login = findViewById(R.id.userLogin);
        password = findViewById(R.id.userPassword);
        enter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (enterLogic()) {
            Intent intent = new Intent(MainActivity.this, MainActivityStatement.class);
            startActivity(intent);
        }
//        else {
//            Toast.makeText(MainActivity.this, "проблемы с подключением", Toast.LENGTH_LONG).show();
//        }
    }

    private boolean validation() {
        login.setBackgroundColor(Color.rgb(216, 235, 255));
        password.setBackgroundColor(Color.rgb(216, 235, 255));
        if (login.getText().toString().length() != 0 && password.getText().toString().length() != 0) {
            return true;
        } else {
            if (login.getText().toString().length() == 0)
                login.setBackgroundColor(Color.rgb(255, 214, 223));
            if (password.getText().toString().length() == 0)
                password.setBackgroundColor(Color.rgb(255, 214, 223));

            return false;
        }
    }

    private boolean enterLogic() {
        if (validation()) {
            SentRequest sentRequest = new SentRequest();
            sentRequest.setContext(this);
            String JsonLogin = new Gson().toJson(login.getText());
            String JsonPassword = new Gson().toJson(password.getText());
            sentRequest.execute("https://mmit.fccho-moscow.ru:4000/user/sign_in", "user[username]", JsonLogin, "user[password]", JsonPassword);
//            if (sentRequest.getResponseCode() == 200) {
//                return true;
//            } else {
//                Toast.makeText(MainActivity.this, "не правильный логин или пароль", Toast.LENGTH_LONG).show();
//            }

            if (login.getText().toString().equals("user") && password.getText().toString().equals("1")) {
                return true;
            } else {
                Toast.makeText(MainActivity.this, "не правильный логин или пароль", Toast.LENGTH_LONG).show();
            }
        }

        return false;
    }
}