package scut.toothpick.lazycampus.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
    private EditText email;
    private Button register;
    private RadioButton man;

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
        man = findViewById(R.id.regi_man);
        email = findViewById(R.id.regi_email);
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
        String semail = email.getText().toString();
        if(sname.equals("")||sid.equals("")||spassword.equals("")||sphone.equals("")){
            Toast.makeText(RegisterActivity.this,"信息填写未完整，请完善信息！",Toast.LENGTH_SHORT).show();
        } else {
            dialog = new ProgressDialog(RegisterActivity.this);
            dialog.setTitle("注册账号中");
            dialog.setMessage("Loading...");
            dialog.setCancelable(false);
            dialog.show();
            int sex = 0;
            if(man.isChecked()){
                sex = 1;
            }
            sendHttpRegisterReq(sname,sid,spassword,sphone,sschool,scollege,sex,semail);
        }
    }

    private void sendHttpRegisterReq(final String sname, final String sid, final String spassword,
                                     final String sphone, final String sschool, final String scollege,
                                     final int sex,final String email) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String ss = sschool.equals("")? "未填":sschool;
                    String sc = scollege.equals("")? "未填":sschool;
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("name",sname)
                            .add("student_id",sid)
                            .add("password",spassword)
                            .add("phone_number",sphone)
                            .add("school",ss)
                            .add("college",sc)
                            .add("email",email)
                            .add("sex", String.valueOf(sex))
                            .build();
                    Request request = new Request.Builder()
                            .url("http://123.56.13.200/Toothpick/Home/Campus/register")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    Log.d(TAG, ""+data);
                    ResultBean bean = new Gson().fromJson(data,ResultBean.class);
                    dialog.dismiss();
                    if(bean.getCode() == 2){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,"注册失败！用户已存在，无需再次注册",Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else if (bean.getCode() == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,"注册成功！请用新账号登录",Toast.LENGTH_SHORT).show();
                            }
                        });
                        finish();
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,"注册失败！请再重试一次",Toast.LENGTH_SHORT).show();
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
