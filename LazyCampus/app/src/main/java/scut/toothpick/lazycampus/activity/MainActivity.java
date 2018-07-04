package scut.toothpick.lazycampus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.BottomBar;
import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.entity.StateType;
import scut.toothpick.lazycampus.entity.TaskType;
import scut.toothpick.lazycampus.fragment.FindFragment;
import scut.toothpick.lazycampus.fragment.MineFragment;
import scut.toothpick.lazycampus.fragment.NewsFragment;
import scut.toothpick.lazycampus.fragment.PublishFragment;
import scut.toothpick.lazycampus.fragment.TaskFragment;

public class MainActivity extends AppCompatActivity {
    private List<TaskType> taskTypeList = new ArrayList<>();
    private String[] stateType = {"已发布","已接单","已完成","已超时"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    //初始化枚举类型
    private void init(){
        taskTypeList.clear();
        TaskType t0 = new TaskType(0,"取快递","#000000");
        TaskType t1 = new TaskType(1,"打印复印","#000000");
        TaskType t2 = new TaskType(2,"代课","#000000");
        TaskType t3 = new TaskType(3,"拿外卖","#000000");
        taskTypeList.add(t0);
        taskTypeList.add(t1);
        taskTypeList.add(t2);
        taskTypeList.add(t3);

    }
}
