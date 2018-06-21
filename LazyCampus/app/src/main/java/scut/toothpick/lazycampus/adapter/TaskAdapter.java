package scut.toothpick.lazycampus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.entity.Task;

/**
 * Created by dgliang on 2018/6/21.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.PublishViewHolder> {

    private List<Task> mTask = new ArrayList<>();

    static class PublishViewHolder extends RecyclerView.ViewHolder {
        View taskView;

        TextView publishType;
        TextView publishContent;
        TextView publishState;
        TextView publishIsReceive;

        public PublishViewHolder(View view) {
            super(view);
            taskView = view;
            publishType = (TextView)view.findViewById(R.id.publishType);
            publishContent = (TextView)view.findViewById(R.id.publishContent);
            publishState = (TextView)view.findViewById(R.id.publishState);
            publishIsReceive = (TextView)view.findViewById(R.id.publishIsReceive);
        }
    }
    //构造方法
    public TaskAdapter(List<Task> taskList) {
        mTask = taskList;
    }

    @Override
    public PublishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publish,parent,false);
        final PublishViewHolder viewHolder = new PublishViewHolder(view);

        viewHolder.taskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(view.getContext(),"点击了第 "+position+" 个",Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PublishViewHolder holder, int position) {
        Task task = mTask.get(position);
        // TODO: 2018/6/21 暂时使用默认数据，以后要改
        holder.publishType.setText("取快递");
        holder.publishContent.setText("12点前二饭马路边取两个快递");
        holder.publishState.setText("进行中");
        holder.publishIsReceive.setText("执行:牙签盒");
    }

    @Override
    public int getItemCount() {
        return mTask.size();
    }

}
