package scut.toothpick.lazycampus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import scut.toothpick.lazycampus.fragment.FindFragment;
import scut.toothpick.lazycampus.fragment.MineFragment;
import scut.toothpick.lazycampus.fragment.NewsFragment;
import scut.toothpick.lazycampus.fragment.PublishFragment;
import scut.toothpick.lazycampus.fragment.TaskFragment;

public class MainActivity extends AppCompatActivity {

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

}
