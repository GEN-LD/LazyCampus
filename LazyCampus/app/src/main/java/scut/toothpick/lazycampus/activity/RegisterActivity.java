package scut.toothpick.lazycampus.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.ResultBean;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "注册页面";

    private EditText name;
    private EditText id;
    private EditText password;
    private EditText phone;
    private EditText school;
    private EditText college;
    private Button register;


    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView(){
        name = findViewById(R.id.regi_name);
        id = findViewById(R.id.student_id);
        password = findViewById(R.id.regi_password);
        phone = findViewById(R.id.regi_phone);
        school = findViewById(R.id.regi_school);
        college = findViewById(R.id.regi_college);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNull();
            }
        });
    }

    private void checkNull() {
        Log.d(TAG, "检查空！");
        String sname = name.getText().toString();
        String sid = id.getText().toString();
        String spassword = password.getText().toString();
        String sphone = phone.getText().toString();
        String sschool = school.getText().toString();
        String scollege = college.getText().toString();
        if(sname.equals("")||sid.equals("")||spassword.equals("")||sphone.equals("")){
            Toast.makeText(RegisterActivity.this,"信息填写未完整，请完善信息！",Toast.LENGTH_SHORT).show();
        } else {
            sendHttpRegisterReq(sname,sid,spassword,sphone,sschool,scollege);
        }
    }

    private void sendHttpRegisterReq(final String sname, final String sid, final String spassword, final String sphone, final String sschool, final String scollege) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String ss = sschool.equals("")? "未填":sschool;
                    String sc = scollege.equals("")? "未填":sschool;
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("name",sname)
                            .add("id",sid)
                            .add("password",spassword)
                            .add("phone",sphone)
                            .add("school",ss)
                            .add("college",sc)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://123.56.13.200/Toothpick/Home/Campus/register")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    Log.d(TAG, ""+data);
//                    ResultBean bean = new Gson().fromJson(data,ResultBean.class);
//                    if(bean.getMsg().equals("success")){
//                        dialog.dismiss();
//                        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
//                        startActivity(intent);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(RegisterActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        finish();
//                    } else {
//                        dialog.dismiss();
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(RegisterActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
