
package scut.toothpick.lazycampus.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.ResultBean;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "登录页面";
    private EditText student_id;
    private EditText password;
    private Button signin;
    private ProgressDialog dialog;

    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView(){
        student_id = (EditText)findViewById(R.id.student_id);
        password = (EditText)findViewById(R.id.password);
        signin = (Button)findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSigninReq();
            }
        });
        register = (TextView)findViewById(R.id.login_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    private void sendSigninReq() {
        String id = student_id.getText().toString();
        String pswd = password.getText().toString();
        Log.d(TAG, "id:"+id+"  password:"+pswd);
        if(id.equals("")){
            Toast.makeText(LoginActivity.this,"请输入id",Toast.LENGTH_SHORT).show();
        } else if (pswd.equals("")){
            Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
        } else {
            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setTitle("正在登录");
            dialog.setMessage("Loading...");
            dialog.setCancelable(false);
            dialog.show();
            signinHttpReq(id,pswd);
        }

    }
    private void signinHttpReq(final String id, final String password){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("id",id)
                            .add("password",password)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://123.56.13.200/Toothpick/Home/Campus/signin")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    Log.d(TAG, ""+data);
                    ResultBean bean = new Gson().fromJson(data,ResultBean.class);
                    dialog.dismiss();
                    if(bean.getMsg().equals("success")){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                            }
                        });
                        finish();
                    } else {
                        dialog.dismiss();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
