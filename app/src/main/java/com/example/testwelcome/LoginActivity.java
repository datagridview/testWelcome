package com.example.testwelcome;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Activity {

//    EditText emailText=(EditText) findViewById(R.id.input_email);
//    EditText passwordText=(EditText) findViewById(R.id.input_password);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(LoginActivity.this, MyWelcomeActivity.class);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        TextView lblSignup=(TextView) findViewById(R.id.link_signup);
        btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(LoginActivity.this,SignupActivity.class);
                    startActivity(intent1);
                    finish();
                }
        });
        lblSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent1);
                finish();
            }

        });
    }

//    public void login() {
//
//    //        if (!validate()) {
//    //            onLoginFailed();
//    //            return;
//    //        }
//    //
//    //        btnLogin.setEnabled(false);
//    //
//    //        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
//    //                R.style.AppTheme);
//    //        progressDialog.setIndeterminate(true);
//    //        progressDialog.setMessage("登录中...");
//    //        progressDialog.show();
//    //
//    //
//    //        new android.os.Handler().postDelayed(
//    //                new Runnable() {
//    //                    public void run() {
//    //                        // On complete call either onLoginSuccess or onLoginFailed
//    //                        onLoginSuccess();
//    //                        // onLoginFailed();
//    //                        progressDialog.dismiss();
//    //                    }
//    //                }, 3000);
//                Intent intent1=new Intent(LoginActivity.this,SignupActivity.class);
//                startActivity(intent1);
//    }
//
//    public boolean validate() {
//        boolean valid = true;
//
//        String email = emailText.getText().toString();
//        String password = passwordText.getText().toString();
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            emailText.setError("请输入有效的电子邮件地址");
//            valid = false;
//        } else {
//            emailText.setError(null);
//        }
//
//        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            passwordText.setError("密码长度在4-10位");
//            valid = false;
//        } else {
//            passwordText.setError(null);
//        }
//
//        return valid;
//    }
//    public void onLoginFailed() {
//        Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();
//    }
//
//    public void onLoginSuccess() {
//        finish();
//    }
//
//    public void login() {
//
////        if (!validate()) {
////            onLoginFailed();
////            return;
////        }
////
////        btnLogin.setEnabled(false);
////
////        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
////                R.style.AppTheme);
////        progressDialog.setIndeterminate(true);
////        progressDialog.setMessage("登录中...");
////        progressDialog.show();
////
////
////        new android.os.Handler().postDelayed(
////                new Runnable() {
////                    public void run() {
////                        // On complete call either onLoginSuccess or onLoginFailed
////                        onLoginSuccess();
////                        // onLoginFailed();
////                        progressDialog.dismiss();
////                    }
////                }, 3000);
//            Intent intent1=new Intent(LoginActivity.this,SignupActivity.class);
//            startActivity(intent1);
//    }
//
//    public boolean validate() {
//        boolean valid = true;
//
//        String email = emailText.getText().toString();
//        String password = passwordText.getText().toString();
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            emailText.setError("请输入有效的电子邮件地址");
//            valid = false;
//        } else {
//            emailText.setError(null);
//        }
//
//        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            passwordText.setError("密码长度在4-10位");
//            valid = false;
//        } else {
//            passwordText.setError(null);
//        }
//
//        return valid;
//    }
//    public void onLoginFailed() {
//        Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();
//    }
//
//    public void onLoginSuccess() {
//        finish();
//    }
}
