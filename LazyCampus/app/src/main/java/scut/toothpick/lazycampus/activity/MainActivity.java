package scut.toothpick.lazycampus.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.BottomBar;
import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.ServiceBean;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.bean.UserBean;
import scut.toothpick.lazycampus.entity.AllState;
import scut.toothpick.lazycampus.fragment.FindFragment;
import scut.toothpick.lazycampus.fragment.MineFragment;
import scut.toothpick.lazycampus.fragment.NewsFragment;
import scut.toothpick.lazycampus.fragment.PublishFragment;
import scut.toothpick.lazycampus.fragment.TaskFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "首页";

    private String[] stateType = {"已发布","已接单","已完成","已超时"};

    public UserBean user;
    public List<TaskBean> taskBeanList = new ArrayList<>();
    public List<ServiceBean> serviceBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        getData();

    }

    private void getData(){
        Intent intent = getIntent();
        String jsonUser = intent.getStringExtra("user0");
        String jsonTask = intent.getStringExtra("task");
        String jsonService = intent.getStringExtra("service");
        user = new Gson().fromJson(jsonUser,UserBean.class);
        taskBeanList = new Gson().fromJson(jsonTask,new TypeToken<List<TaskBean>>(){}.getType());
        serviceBeanList = new Gson().fromJson(jsonService,new TypeToken<List<ServiceBean>>(){}.getType());
        Log.d(TAG, String.valueOf(taskBeanList.size()));

    }

    public List<TaskBean> getTaskBeanList(){
        return taskBeanList;
    }
    public List<ServiceBean> getServiceBeanList(){
        return serviceBeanList;
    }

    public UserBean getUser() {
        return user;
    }

    private void initFragment(){
        BottomBar bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#888888", "#000000")
                .addItem(NewsFragment.class,"消息",
                        R.drawable.tabbar_news_default,
                        R.drawable.tabbar_news_selected)
                .addItem(TaskFragment.class,"任务",
                        R.drawable.tabbar_task_default,
                        R.drawable.tabbar_task_selected)
                .addItem(PublishFragment.class,"发布",
                        R.drawable.tabbar_publish_default,
                        R.drawable.tabbar_publish_selected)
                .addItem(FindFragment.class,"找人",
                        R.drawable.tabbar_find_default,
                        R.drawable.tabbar_find_selected)
                .addItem(MineFragment.class,"我的",
                        R.drawable.tabbar_mine_default,
                        R.drawable.tabbar_mine_selected)
                .build();
    }
}
