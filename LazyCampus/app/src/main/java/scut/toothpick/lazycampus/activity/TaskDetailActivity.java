package scut.toothpick.lazycampus.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.entity.AllState;

public class TaskDetailActivity extends AppCompatActivity {

    private TaskBean taskBean;

    TextView taskType;
    TextView taskState;
    TextView taskContent;
    TextView taskPublisher;
    TextView taskCredit;
    TextView taskMoney;
    TextView taskNum;
    TextView taskPublishTime;
    TextView taskDistance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        Intent intent = getIntent();
        String taskJson = intent.getStringExtra("taskDetail");
        taskBean = new Gson().fromJson(taskJson,TaskBean.class);
        initView();

    }
    private void initView(){
        taskType = findViewById(R.id.task_detail_type);
        taskState = findViewById(R.id.task_detail_state);
        taskContent = findViewById(R.id.task_detail_content);
        taskPublisher = findViewById(R.id.task_publisher);
        taskCredit = findViewById(R.id.task_detail_credit);
        taskMoney = findViewById(R.id.task_detail_money);
        taskNum = findViewById(R.id.task_detail_num);
        taskPublishTime = findViewById(R.id.task_detail_deadline);
        taskDistance = findViewById(R.id.task_detail_distance);

        taskType.setText(AllState.title[Integer.parseInt(taskBean.getType())]);
        taskState.setText(AllState.taskState[Integer.parseInt(taskBean.getState())]);
        taskContent.setText(taskBean.getContent());
        taskMoney.setText("赏金："+taskBean.getMoney()+"元");
        taskPublishTime.setText(taskBean.getPublish_time());
        taskPublisher.setText("发布者:"+taskBean.getPublish_id());
    }
}
