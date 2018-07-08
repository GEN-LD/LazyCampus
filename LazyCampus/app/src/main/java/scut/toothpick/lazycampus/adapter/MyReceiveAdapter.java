package scut.toothpick.lazycampus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.ServiceBean;
import scut.toothpick.lazycampus.bean.TaskBean;
import scut.toothpick.lazycampus.entity.AllState;

/**
 * Created by dgliang on 2018/6/21.
 */

public class MyReceiveAdapter extends RecyclerView.Adapter<MyReceiveAdapter.MyReceiveViewHolder>{

    private List<TaskBean> mTaskBean = new ArrayList<>();
    private List<ServiceBean> serviceBeans = new ArrayList<>();
    static class MyReceiveViewHolder extends RecyclerView.ViewHolder {
        TextView receiveType;
        TextView receiveContent;
        TextView receiveState;
        TextView receiveIsReceive;

        public MyReceiveViewHolder(View view) {
            super(view);
            receiveType = (TextView)view.findViewById(R.id.receiveType);
            receiveContent = (TextView)view.findViewById(R.id.receiveContent);
            receiveState = (TextView)view.findViewById(R.id.receiveState);
            receiveIsReceive = (TextView)view.findViewById(R.id.receiveIsReceive);
        }
    }
    //构造方法
    public MyReceiveAdapter(List<TaskBean> taskBeanList) {
        mTaskBean = taskBeanList;
    }

    @Override
    public MyReceiveAdapter.MyReceiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receive,parent,false);
        MyReceiveAdapter.MyReceiveViewHolder viewHolder = new MyReceiveViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyReceiveViewHolder holder, int position) {
        TaskBean taskBean = mTaskBean.get(position);
        // TODO: 2018/6/21 暂时使用默认数据，以后要改
        holder.receiveType.setText(AllState.title[Integer.parseInt(mTaskBean.get(position).getType())]);
        holder.receiveContent.setText(mTaskBean.get(position).getContent());
        holder.receiveState.setText(AllState.taskState[Integer.parseInt(mTaskBean.get(position).getState())]);
        holder.receiveIsReceive.setText("执行:"+mTaskBean.get(position).getReceive_id());
    }

    @Override
    public int getItemCount() {
        return mTaskBean.size();
    }

}
