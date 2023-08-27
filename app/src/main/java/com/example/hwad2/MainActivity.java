package com.example.hwad2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button loginButton;
    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editText);
        editTextPassword = findViewById(R.id.editText);
        loginButton = findViewById(R.id.loginButton);
        welcomeText = findViewById(R.id.welcomeText);

        editTextLogin.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();

                if (login.equals("admin") && password.equals("admin")) {
                    welcomeText.setText("Добро пожаловать!");
                    editTextLogin.setVisibility(View.GONE);
                    editTextPassword.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            updateLoginButtonBackground();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void updateLoginButtonBackground() {
        String login = editTextLogin.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (!login.isEmpty() && !password.isEmpty()) {
            loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange));
        } else {
            loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
        }
    }
}