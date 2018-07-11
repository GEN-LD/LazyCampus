package scut.toothpick.lazycampus.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.ResultBean;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.bean.UserBean;
import scut.toothpick.lazycampus.entity.AllState;

public class TaskDetailActivity extends AppCompatActivity {

    public static final String TAG = "任务详情页面";

    private TaskBean taskBean;
    private UserBean user;

    private TextView taskType;
    private TextView taskDetailState;
    private TextView taskContent;
    private TextView taskPublisher;
    private TextView taskCredit;
    private TextView taskMoney;
    private TextView task_receiveid;
    private TextView taskPublishTime;
    private TextView taskDistance;

    private TextView taskState;
    private Button jiedan;
    private Button yijiedan;
    private Button yiwancheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        Intent intent = getIntent();
        String taskJson = intent.getStringExtra("taskDetail");
        String userJson = intent.getStringExtra("user");
        taskBean = new Gson().fromJson(taskJson, TaskBean.class);
        user = new Gson().fromJson(userJson, UserBean.class);
        Log.d(TAG, "user的id  " + user.getStudent_id());
        initView();

    }

    private void initView() {
        taskType = findViewById(R.id.task_detail_type);
        taskDetailState = findViewById(R.id.task_detail_state);
        taskContent = findViewById(R.id.task_detail_content);
        taskPublisher = findViewById(R.id.task_publisher);
        taskCredit = findViewById(R.id.task_detail_credit);
        taskMoney = findViewById(R.id.task_detail_money);
        task_receiveid = findViewById(R.id.task_detail_receiveid);
        taskPublishTime = findViewById(R.id.task_detail_deadline);
        taskDistance = findViewById(R.id.task_detail_distance);
        taskState = findViewById(R.id.task_state);

        taskType.setText(AllState.title[Integer.parseInt(taskBean.getType())]);
        taskDetailState.setText(AllState.taskState[Integer.parseInt(taskBean.getState())]);
        taskContent.setText(taskBean.getContent());
        taskMoney.setText("赏金：" + taskBean.getMoney() + "元");
        taskPublishTime.setText(taskBean.getPublish_time());
        taskPublisher.setText("发布者:" + taskBean.getPublish_id());

        jiedan = findViewById(R.id.task_detail_jiedan0);
        jiedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showJiedanDialog();

            }
        });
        yijiedan = findViewById(R.id.task_detail_yijiedan);
        yijiedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWanchengDialog();
            }
        });
        yiwancheng = findViewById(R.id.task_detail_yiwancheng);
        yiwancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        int flag = Integer.parseInt(taskBean.getState());
        if (Integer.parseInt(taskBean.getState()) == 0) {
            jiedan.setVisibility(View.VISIBLE);
            yijiedan.setVisibility(View.GONE);
            yiwancheng.setVisibility(View.GONE);
        } else if (flag == 1) {
            jiedan.setVisibility(View.GONE);
            yijiedan.setVisibility(View.VISIBLE);
            yiwancheng.setVisibility(View.GONE);
        } else {
            jiedan.setVisibility(View.GONE);
            yijiedan.setVisibility(View.GONE);
            yiwancheng.setVisibility(View.VISIBLE);
        }

    }

    private void sendJiedan() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    final String taskJson = new Gson().toJson(taskBean);
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("task_json", taskJson)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://123.56.13.200/Toothpick/Home/Campus/receiveTask")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String resposeData = response.body().string();
                    ResultBean bean = new Gson().fromJson(resposeData, ResultBean.class);
                    if (bean.getMsg().equals("success")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jiedan.setVisibility(View.GONE);
                                yiwancheng.setVisibility(View.GONE);
                                yijiedan.setVisibility(View.VISIBLE);
                                taskState.setText("进行中");

                            }
                        });
                    } else {
                    }
                    Log.d(TAG, resposeData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sendWancheng() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    String taskJson = new Gson().toJson(taskBean);
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("task_json", taskJson)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://123.56.13.200/Toothpick/Home/Campus/receiveTask")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String resposeData = response.body().string();
                    ResultBean bean = new Gson().fromJson(resposeData, ResultBean.class);
                    if (bean.getMsg().equals("success")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jiedan.setVisibility(View.GONE);
                                yiwancheng.setVisibility(View.VISIBLE);
                                yijiedan.setVisibility(View.GONE);
                                taskState.setText("已结束");

                            }
                        });
                    } else {
                    }
                    Log.d(TAG, resposeData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showJiedanDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(TaskDetailActivity.this);
        dialog.setTitle("确认接单吗？(将与发布者取得联系)");
        dialog.setCancelable(false);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                taskBean.setState(String.valueOf(1));
                taskDetailState.setText(AllState.taskState[Integer.parseInt(taskBean.getState())]);
                //获取当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
                taskBean.setReceive_time(date);
                Log.d(TAG, "id  " + user.getStudent_id());
                taskBean.setReceive_id(user.getStudent_id());
                sendJiedan();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }
    private void showWanchengDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(TaskDetailActivity.this);
        dialog.setTitle("确认完成任务了吗？");
        dialog.setCancelable(false);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                taskBean.setState(String.valueOf(2));
                taskDetailState.setText(AllState.taskState[Integer.parseInt(taskBean.getState())]);
                //获取当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
                taskBean.setFinish_time(date);
                sendWancheng();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }
}
