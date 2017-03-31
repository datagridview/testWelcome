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

public class SignupActivity extends Activity {

    //定义全局变量
    private static final String nameSpaceAddress="http://tempuri.org/";
    private static final String urlAddress="http://172.25.35.36:8017/WebServiceAnd.asmx";
    private static final String methodNameAddress = "insertclient";
    //private static final String methodNameAddress2 = "selectclient";
    private static final String soapActionAddress = "http://tempuri.org/insertclient";
    //private static final String soapActionAddress2 = "http://tempuri.org/selectclient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //定义线程类型
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //定义用到的控件，并获得值
        final EditText emailText=(EditText) findViewById(R.id.input_email);
        final EditText passwordText1=(EditText) findViewById(R.id.input_password);
        final EditText passwordText2=(EditText) findViewById(R.id.confirm_password);
        Button btnRegister = (Button) findViewById(R.id.btn_register);
        TextView lblLogin=(TextView) findViewById(R.id.link_login);

        //整个的注册事件
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=emailText.getText().toString();
                String pwd1=passwordText1.getText().toString();
                String pwd2=passwordText2.getText().toString();
                if (pwd1.isEmpty() || pwd1.length() < 4 || pwd1.length() > 10||pwd2.isEmpty()
                        || pwd2.length() < 4 || pwd2.length() > 10) {
                    Toast.makeText(SignupActivity.this, "密码长度在4-10位", Toast.LENGTH_SHORT).show();
                }
                else {
                if(pwd1.equals(pwd2)){
                    String result;
                    SoapObject soapObject = new
                            SoapObject(nameSpaceAddress, methodNameAddress);
                    //创建SOAP对象
                    //设置属性，这些属性值通过SOAP协议传送给服务器
                    soapObject.addProperty("a",user);
                    soapObject.addProperty("b",pwd1);
                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                            SoapEnvelope.VER11);
                    envelope.bodyOut = soapObject;
                    envelope.dotNet = true;
                    envelope.setOutputSoapObject(soapObject);
                    HttpTransportSE httpTransportSE = new HttpTransportSE(urlAddress);
                    httpTransportSE.debug=true;
                    SoapObject result1=null;
                    try {
                        //调用服务
                        httpTransportSE.call(soapActionAddress, envelope);
                        result1=(SoapObject)envelope.getResponse();
                        Intent intent1=new Intent(SignupActivity.this,MainActivity.class);
                        startActivity(intent1);
                        finish();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else Toast.makeText(SignupActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lblLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
