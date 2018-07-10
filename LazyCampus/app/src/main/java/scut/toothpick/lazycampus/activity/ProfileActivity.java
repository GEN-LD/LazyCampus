package scut.toothpick.lazycampus.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.UserBean;

public class ProfileActivity extends AppCompatActivity {

    private UserBean userBean;
    private TextView pro_sex;
    private TextView pro_phone;
    private TextView ni_name;
    private TextView pro_email;
    private TextView pro_school;
    private TextView pro_college;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        pro_sex = findViewById(R.id.pro_sex);
        pro_phone = findViewById(R.id.pro_phone);
        ni_name = findViewById(R.id.ni_name);
        pro_email = findViewById(R.id.pro_email);
        pro_school = findViewById(R.id.pro_school);
        pro_college = findViewById(R.id.pro_college);

        Intent intent = getIntent();
        String userJson = intent.getStringExtra("user");
        userBean = new Gson().fromJson(userJson,UserBean.class);
        if(Integer.valueOf(userBean.getSex())>0){
            pro_sex.setText("男");
        } else {
            pro_sex.setText("女");
        }
        ni_name.setText(userBean.getName());
        pro_phone.setText(userBean.getPhone_number());
        pro_email.setText(userBean.getEmail());
        pro_school.setText(userBean.getSchool());
        pro_college.setText(userBean.getCollege());
    }
}
