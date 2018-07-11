package scut.toothpick.lazycampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.activity.MainActivity;
import scut.toothpick.lazycampus.adapter.NewsTaskAdapter;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.bean.UserBean;


public class NewsPublishFragment extends Fragment {

    public static final String TAG = "消息发布页面";
    private List<TaskBean> mTaskBean = new ArrayList<>();
    private List<TaskBean> myTask = new ArrayList<>();
    private List<UserBean> alluser = new ArrayList<>();
    private UserBean userBean;

    private View view;

    private List<TaskBean> taskBeanList = new ArrayList<>();

    private static NewsPublishFragment newsPublishFragment = null;
    public NewsPublishFragment(){}

    public static NewsPublishFragment getNewsPublishFragment(){
        if(newsPublishFragment == null) {
            newsPublishFragment = new NewsPublishFragment();
        }
        return newsPublishFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_publish,container,false);

        getData();
        initTask();
        RecyclerView publishRecyclerView = (RecyclerView)view.findViewById(R.id.publishRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        publishRecyclerView.setLayoutManager(manager);
        NewsTaskAdapter adapter = new NewsTaskAdapter(myTask,alluser,userBean);
        publishRecyclerView.setAdapter(adapter);

        return view;
    }
    private void initTask(){
        Log.d(TAG, "mtask数量"+mTaskBean.size());
        for(int i=0;i<mTaskBean.size();i++){
            if(mTaskBean.get(i).getPublish_id().equals(userBean.getStudent_id())){
                myTask.add(mTaskBean.get(i));
            }
        }
        Log.d(TAG, "mytask数量"+myTask.size());
    }
    private void getData(){
        MainActivity mainActivity = (MainActivity)getActivity();
        mTaskBean = mainActivity.getTaskBeanList();
        userBean = mainActivity.getUser();
        alluser = mainActivity.getAlluser();
        Log.d(TAG,"mTaskBean数量 "+mTaskBean.size());
    }
}
