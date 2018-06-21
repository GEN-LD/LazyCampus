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
import scut.toothpick.lazycampus.adapter.TaskAdapter;
import scut.toothpick.lazycampus.entity.Task;


public class NewsPublishFragment extends Fragment {

    private View view;

    private List<Task> taskList = new ArrayList<>();

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

        initTask();
        RecyclerView publishRecyclerView = (RecyclerView)view.findViewById(R.id.publishRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        publishRecyclerView.setLayoutManager(manager);
        TaskAdapter adapter = new TaskAdapter(taskList);
        publishRecyclerView.setAdapter(adapter);

        return view;
    }
    private void initTask(){
        for(int i=0;i<8;i++){
            Task task = new Task();
            taskList.add(task);
        }
    }
}
