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
import scut.toothpick.lazycampus.adapter.MyReceiveAdapter;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.bean.UserBean;


public class NewsReceiveFragment extends Fragment {
    public static final String TAG = "消息接收页面";
    private List<TaskBean> mTaskBean = new ArrayList<>();
    private List<TaskBean> myTask = new ArrayList<>();
    private UserBean userBean;

    private View view;
    private static NewsReceiveFragment newsReceiveFragment = null;
    public NewsReceiveFragment(){}

    public static NewsReceiveFragment getNewsReceiveFragment(){
        if(newsReceiveFragment == null) {
            newsReceiveFragment = new NewsReceiveFragment();
        }
        return newsReceiveFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_receive,container,false);

        getData();
        initTask();
        RecyclerView receiveRecyclerView = (RecyclerView)view.findViewById(R.id.receiveRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        receiveRecyclerView.setLayoutManager(manager);
        MyReceiveAdapter adapter = new MyReceiveAdapter(myTask);
        receiveRecyclerView.setAdapter(adapter);
        return view;
    }
    private void initTask(){
        Log.d(TAG, "mtask数量"+mTaskBean.size());
        for(int i=0;i<mTaskBean.size();i++){
            if(mTaskBean.get(i).getReceive_id().equals(userBean.getStudent_id())){
                myTask.add(mTaskBean.get(i));
            }
        }
        Log.d(TAG, "mytask数量"+myTask.size());
    }
    private void getData(){
        MainActivity mainActivity = (MainActivity)getActivity();
        mTaskBean = mainActivity.getTaskBeanList();
        userBean = mainActivity.getUser();
        Log.d(TAG,"mTaskBean数量 "+mTaskBean.size());
    }
}
