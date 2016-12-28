package com.example.testwelcome;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class LoginActivity extends Activity {

//    EditText emailText=(EditText) findViewById(R.id.input_email);
//    EditText passwordText=(EditText) findViewById(R.id.input_password);
private static final String nameSpaceAddress="http://tempuri.org/";
    private static final String urlAddress="http://172.20.10.5:8017/WebServiceAnd.asmx";
    private static final String methodNameAddress = "insertclient";
    private static final String methodNameAddress2 = "selectclient";
    private static final String soapActionAddress = "http://tempuri.org/insertclient";
    private static final String soapActionAddress2 = "http://tempuri.org/selectclient";
    Boolean valid;


                @Override
    public void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Intent intent = new Intent(LoginActivity.this,MyWelcomeActivity.class);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        final TextView lblSignup=(TextView) findViewById(R.id.link_signup);
        btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText emailText=(EditText) findViewById(R.id.input_email);
                    EditText passwordText=(EditText) findViewById(R.id.input_password);
                    String user=emailText.getText().toString();
                    String pwd=passwordText.getText().toString();
                    if (user.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "请输入有效的电子邮件地址", Toast.LENGTH_SHORT).show();
                        valid = false;
                        } else {
                        if (pwd.isEmpty() || pwd.length() < 4 || pwd.length() > 10) {
                        Toast.makeText(LoginActivity.this, "密码长度在4-10位", Toast.LENGTH_SHORT).show();
                        valid = false;
                    } else {
                            String result;


                            SoapObject soapObject = new
                                    SoapObject(nameSpaceAddress, methodNameAddress2);//创建SOAP对象
                            //设置属性，这些属性值通过SOAP协议传送给服务器

                            soapObject.addProperty("a", user);


                            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                                    SoapEnvelope.VER11);
                            envelope.bodyOut = soapObject;
                            envelope.dotNet = true;

                            envelope.setOutputSoapObject(soapObject);
                            HttpTransportSE httpTransportSE = new HttpTransportSE(urlAddress);
                            httpTransportSE.debug=true;
                            //SoapObject result1=null;
                            try {
                                //调用服务
                                httpTransportSE.call(soapActionAddress2, envelope);
                                // result1=(SoapObject)envelope.getResponse();
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                            SoapObject object = (SoapObject) envelope.bodyIn;
                           try
                           {
                               result = object.getProperty(0).toString();
                               if(result.equals(pwd)){
                                   Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
                                   startActivity(intent1);

                                   finish();
                               }
                               else
                               {
//                       lblSignup.setText("不一样");

                                   Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                               }
                           }
                           catch(Exception e)
                            {
                                Toast.makeText(LoginActivity.this, "没有该用户", Toast.LENGTH_SHORT).show();
                            }


                    }
                        }


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
