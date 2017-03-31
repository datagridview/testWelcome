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
//  定义需要的全局变量
//  EditText emailText=(EditText) findViewById(R.id.input_email);
//  EditText passwordText=(EditText) findViewById(R.id.input_password);
    private static final String nameSpaceAddress="http://tempuri.org/";
    private static final String urlAddress="http://172.25.35.36:8017/WebServiceAnd.asmx";
    private static final String methodNameAddress = "insertclient";
    private static final String methodNameAddress2 = "selectclient";
    private static final String soapActionAddress = "http://tempuri.org/insertclient";
    private static final String soapActionAddress2 = "http://tempuri.org/selectclient";
    Boolean valid;


                @Override
    public void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //初始化欢迎页面
        Intent intent = new Intent(LoginActivity.this,MyWelcomeActivity.class);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //定义按钮、label触发事件
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        final TextView lblSignup=(TextView) findViewById(R.id.link_signup);
        btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //得到控件中的值
                    EditText emailText=(EditText) findViewById(R.id.input_email);
                    EditText passwordText=(EditText) findViewById(R.id.input_password);
                    String user=emailText.getText().toString();
                    String pwd=passwordText.getText().toString();

                    //电子邮件地址的判断
                    //判断层级式先决逻辑
                    if (user.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "请输入有效的电子邮件地址", Toast.LENGTH_SHORT).show();
                        valid = false;
                    }
                    else {
                        if (pwd.isEmpty() || pwd.length() < 4 || pwd.length() > 10) {
                        Toast.makeText(LoginActivity.this, "密码长度在4-10位", Toast.LENGTH_SHORT).show();
                        valid = false;
                        }
                        else {
                            String result;
                            SoapObject soapObject = new
                                    SoapObject(nameSpaceAddress, methodNameAddress2);
                            //创建SOAP对象
                            //设置属性，这些属性值通过SOAP协议传送给服务器

                            soapObject.addProperty("a", user);
                            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                                    SoapEnvelope.VER11);
                            envelope.bodyOut = soapObject;
                            envelope.dotNet = true;
                            envelope.setOutputSoapObject(soapObject);
                            HttpTransportSE httpTransportSE = new HttpTransportSE(urlAddress);
                            httpTransportSE.debug=true;
                            try {
                                //调用服务
                                httpTransportSE.call(soapActionAddress2, envelope);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                            SoapObject object = (SoapObject) envelope.bodyIn;

                           try {
                               result = object.getProperty(0).toString();
                               if(result.equals(pwd)){
                                   //下一个页面的跳转
                                   Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
                                   startActivity(intent1);
                                   finish();
                               }
                               else {
                                   Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                               }
                           }
                           catch(Exception e) {
                                Toast.makeText(LoginActivity.this, "没有该用户", Toast.LENGTH_SHORT).show();
                           }


                        }
                    }


                }
        });

        //label触发事件
        lblSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent1);
                finish();
            }

        });
    }

}
