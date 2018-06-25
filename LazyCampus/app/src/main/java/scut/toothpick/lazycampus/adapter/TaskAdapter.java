package scut.toothpick.lazycampus.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.activity.TaskDetailActivity;
import scut.toothpick.lazycampus.entity.Task;

/**
 * Created by dgliang on 2018/6/25.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> mTask;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View taskView;

        TextView task_type;
        TextView task_content;
        TextView task_apply_num;
        TextView task_money;
        TextView task_distance;
        TextView task_credit;
        TextView task_deadline;

        public ViewHolder(View view) {
            super(view);

            taskView = view;

            task_type = (TextView)view.findViewById(R.id.task_type);
            task_content = (TextView)view.findViewById(R.id.task_content);
            task_apply_num = (TextView)view.findViewById(R.id.task_apply_num);
            task_money = (TextView)view.findViewById(R.id.task_money);
            task_distance = (TextView)view.findViewById(R.id.task_distance);
            task_credit = (TextView)view.findViewById(R.id.task_credit);
            task_deadline = (TextView)view.findViewById(R.id.task_deadline);
        }
    }

    public TaskAdapter(List<Task> tasks){
        mTask = tasks;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        holder.taskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Toast.makeText(view.getContext(),"点击了第 "+position+" 个",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(parent.getContext(), TaskDetailActivity.class);
                parent.getContext().startActivity(intent);
            }
        });

        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = mTask.get(position);
        holder.task_type.setText("取快递");
        holder.task_content.setText("在今天17：00前一饭天桥2号柜取两个包裹");
        holder.task_apply_num.setText("申请人数：-");
        holder.task_money.setText("赏金：-元");
        holder.task_distance.setText("发布距离：--");
        holder.task_credit.setText("信用评级：-");
        holder.task_deadline.setText("任务截止时间：2018/06/20 19:00");
    }

    @Override
    public int getItemCount() {
        return mTask.size();
    }

}
