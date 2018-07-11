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
import scut.toothpick.lazycampus.adapter.ServiceAdapter;
import scut.toothpick.lazycampus.bean.ServiceBean;
import scut.toothpick.lazycampus.bean.UserBean;


public class FindFragment extends Fragment {

    public static final String TAG = "找人页面";

    private List<ServiceBean> serviceBeanList = new ArrayList<>();
    private UserBean userBean;
    private LinearLayoutManager layoutManager;
    private ServiceAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_find, container, false);

        getList();
        layoutManager = new LinearLayoutManager(getContext());
        Log.d(TAG, "服务list数量："+serviceBeanList.size());
        adapter = new ServiceAdapter(serviceBeanList,userBean);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerService);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }
    private void getList(){
        MainActivity mainActivity = (MainActivity)getActivity();
        serviceBeanList = mainActivity.getServiceBeanList();
        userBean = mainActivity.getUser();
        Log.d(TAG,"服务数量 "+serviceBeanList.size());
    }
}
