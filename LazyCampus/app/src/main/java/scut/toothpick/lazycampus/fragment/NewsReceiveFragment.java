package scut.toothpick.lazycampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.adapter.MyReceiveAdapter;
import scut.toothpick.lazycampus.entity.Task;


public class NewsReceiveFragment extends Fragment {

    private List<Task> taskList = new ArrayList<>();

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

        initList();
        RecyclerView receiveRecyclerView = (RecyclerView)view.findViewById(R.id.receiveRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        receiveRecyclerView.setLayoutManager(manager);
        MyReceiveAdapter adapter = new MyReceiveAdapter(taskList);
        receiveRecyclerView.setAdapter(adapter);
        return view;
    }
    private void initList(){
        for(int i=0;i<6;i++) {
            Task task = new Task();
            taskList.add(task);
        }
    }
}
