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


public class TaskFragment extends Fragment {

    private List<Task> mTask = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_task, container, false);

        initTaskList();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerTask);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        TaskAdapter adapter = new TaskAdapter(mTask);
        recyclerView.setAdapter(adapter);

        return view;
    }
    private void initTaskList(){
        Task a1 = new Task();
        mTask.add(a1);
        Task a2 = new Task();
        mTask.add(a2);
        Task a3 = new Task();
        mTask.add(a3);
    }
}
