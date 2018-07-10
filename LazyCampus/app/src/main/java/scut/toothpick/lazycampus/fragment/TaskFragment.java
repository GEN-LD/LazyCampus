package scut.toothpick.lazycampus.fragment;

import android.nfc.Tag;
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
import scut.toothpick.lazycampus.adapter.TaskAdapter;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.bean.UserBean;


public class TaskFragment extends Fragment {

    public static final String TAG = "任务Fragment";

    private List<TaskBean> mTaskBean = new ArrayList<>();
    private UserBean userBean;
    private TaskAdapter adapter;
    private LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_task, container, false);

        getTaskList();
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new TaskAdapter(mTaskBean,userBean);
        Log.d(TAG, "userbean  "+userBean.getStudent_id());
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerTask);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void getTaskList(){
        MainActivity mainActivity = (MainActivity)getActivity();
        mTaskBean = mainActivity.getTaskBeanList();
        userBean = mainActivity.getUser();
        Log.d(TAG,"mTaskBean数量 "+mTaskBean.size());
    }
}
