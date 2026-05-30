package com.example.exam2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private boolean backPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setEnabled(false);

        TextWatcher watcher = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString();
                boolean emailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches();
                boolean passwordValid = password.length() >= 6;
                btnLogin.setEnabled(emailValid && passwordValid);
            }
        };

        etEmail.addTextChangedListener(watcher);
        etPassword.addTextChangedListener(watcher);

        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ModeActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedOnce) {
            super.onBackPressed();
            return;
        }
        backPressedOnce = true;
        Snackbar.make(findViewById(android.R.id.content), "Press back again to exit", Snackbar.LENGTH_SHORT).show();
        new android.os.Handler().postDelayed(() -> backPressedOnce = false, 2000);
    }
}
