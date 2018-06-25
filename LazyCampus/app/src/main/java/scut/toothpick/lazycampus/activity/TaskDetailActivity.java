package scut.toothpick.lazycampus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import scut.toothpick.lazycampus.R;

public class TaskDetailActivity extends AppCompatActivity {

    TextView taskType;
    TextView taskState;
    TextView taskContent;
    TextView taskPublisher;
    TextView taskCredit;
    TextView taskMoney;
    TextView taskNum;
    TextView taskDeadline;
    TextView taskDistance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        taskType = findViewById(R.id.task_detail_type);
        taskState = findViewById(R.id.task_detail_state);
        taskContent = findViewById(R.id.task_detail_content);
        taskPublisher = findViewById(R.id.task_publisher);
        taskCredit = findViewById(R.id.task_detail_credit);
        taskMoney = findViewById(R.id.task_detail_money);
        taskNum = findViewById(R.id.task_detail_num);
        taskDeadline = findViewById(R.id.task_detail_deadline);
        taskDistance = findViewById(R.id.task_detail_distance);
    }
}
