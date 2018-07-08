package scut.toothpick.lazycampus.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.activity.TaskDetailActivity;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.entity.AllState;

/**
 * Created by dgliang on 2018/6/25.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<TaskBean> mTaskBean;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View taskView;

        TextView task_type;
        TextView task_content;
        TextView task_money;
        TextView task_credit;
        TextView task_deadline;

        public ViewHolder(View view) {
            super(view);

            taskView = view;

            task_type = (TextView)view.findViewById(R.id.task_type);
            task_content = (TextView)view.findViewById(R.id.task_content);
            task_money = (TextView)view.findViewById(R.id.task_money);
            task_credit = (TextView)view.findViewById(R.id.task_credit);
            task_deadline = (TextView)view.findViewById(R.id.task_deadline);
        }
    }

    public TaskAdapter(List<TaskBean> taskBeans){
        mTaskBean = taskBeans;
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
                intent.putExtra("taskDetail",new Gson().toJson(mTaskBean.get(position)));
                parent.getContext().startActivity(intent);
            }
        });

        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TaskBean taskBean = mTaskBean.get(position);
        holder.task_type.setText(AllState.title[Integer.parseInt(taskBean.getType())]);
        holder.task_content.setText(taskBean.getContent());
        holder.task_money.setText("赏金："+taskBean.getMoney()+"元");
        holder.task_credit.setText("信用评级："+taskBean.getState());
        holder.task_deadline.setText("发布时间："+taskBean.getPublish_time());
    }

    @Override
    public int getItemCount() {
        return mTaskBean.size();
    }

}
