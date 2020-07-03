package com.ourdreamit.pathao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button loginBT;
    EditText userName;
    EditText userPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        loginBT = findViewById(R.id.loginButton);

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userNameInput = userName.getText().toString();
                String userPassInput = userPassword.getText().toString();

                if (userNameInput.equals("Anis")) {

                    Toast.makeText(LoginActivity.this, "Your Name is: "+userNameInput, Toast.LENGTH_LONG).show();

                } else if (userPassInput.equals("123")) {

                    Toast.makeText(LoginActivity.this, "Your password looks ok.", Toast.LENGTH_LONG).show();

                } else if (!userNameInput.isEmpty() && !userPassInput.isEmpty()) {

                    Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                    startActivity(intent);

                }
            }
        });

        userName = findViewById(R.id.username);
        userPassword = findViewById(R.id.userPassword);


    }
}