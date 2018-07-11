package scut.toothpick.lazycampus.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.activity.TaskDetailActivity;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.bean.UserBean;
import scut.toothpick.lazycampus.entity.AllState;

/**
 * Created by dgliang on 2018/6/21.
 */

public class NewsTaskAdapter extends RecyclerView.Adapter<NewsTaskAdapter.PublishViewHolder> {

    private List<TaskBean> mTaskBean = new ArrayList<>();
    private List<UserBean> alluser = new ArrayList<>();
    private UserBean userBean;

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
    public NewsTaskAdapter(List<TaskBean> taskBeanList,List<UserBean> userBeans,UserBean userBean) {
        mTaskBean = taskBeanList;
        alluser = userBeans;
        this.userBean = userBean;
    }

    @Override
    public PublishViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publish,parent,false);
        final PublishViewHolder viewHolder = new PublishViewHolder(view);

        viewHolder.taskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(view.getContext(),"点击了第 "+position+" 个",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(parent.getContext(), TaskDetailActivity.class);
                intent.putExtra("taskDetail",new Gson().toJson(mTaskBean.get(position)));
                intent.putExtra("user",new Gson().toJson(userBean));
                parent.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PublishViewHolder holder, int position) {
        TaskBean taskBean = mTaskBean.get(position);
        // TODO: 2018/6/21 暂时使用默认数据，以后要改
        holder.publishType.setText(AllState.title[Integer.parseInt(mTaskBean.get(position).getType())]);
        holder.publishContent.setText(mTaskBean.get(position).getContent());
        holder.publishState.setText(AllState.taskState[Integer.parseInt(mTaskBean.get(position).getState())]);
        holder.publishIsReceive.setText("发布:"+mTaskBean.get(position).getPublish_id());
    }

    @Override
    public int getItemCount() {
        return mTaskBean.size();
    }

}
