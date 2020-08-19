package com.yono.applicationscanner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    MaterialButton btnLogin;
    TextInputEditText etUsername, etPassword;
    TextInputLayout lyUsername, lyPassword;
    NetworckChecker jaringan;
    SharedPreferences sharedPreferences;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        btnLogin = findViewById(R.id.login_button);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        lyUsername = findViewById(R.id.username);
        lyPassword = findViewById(R.id.password);
        jaringan = new NetworckChecker();

        sharedPreferences = getSharedPreferences(MainActivity.MY_SHARED_STATUS, Context.MODE_PRIVATE);

        if (!jaringan.getJaringan()){
            new Utils().PesanToast(this, R.string.tidak_ada_jaringan);
        }

    }

    public void ActionLogin(View view) {
        if (jaringan.getJaringan()){
            if (TextUtils.isEmpty(etUsername.getText().toString()) && TextUtils.isEmpty(etPassword.getText().toString())){
                lyUsername.setError("Username tidak boleh kosong!");
                lyPassword.setError("Password tidak boleh kosong!");
            }else if (TextUtils.isEmpty(etUsername.getText().toString())){
                lyPassword.setError(null);
                lyUsername.setError("Username tidak boleh kosong!");
            }else if (TextUtils.isEmpty(etPassword.getText().toString())){
                lyUsername.setError(null);
                lyPassword.setError("Password tidak boleh kosong!");
            }else {
                new Utils().LoadingDialog(this, "Sedang Login...");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(MainActivity.STATUS_LOGIN, true);
                editor.commit();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

            }
        }else{
            new Utils().PesanToast(this, R.string.tidak_ada_jaringan);
        }
    }
}
