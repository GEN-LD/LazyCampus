package scut.toothpick.lazycampus.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.bean.ServiceBean;
import scut.toothpick.lazycampus.bean.UserBean;
import scut.toothpick.lazycampus.entity.AllState;

/**
 * Created by dgliang on 2018/7/10.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    public static final String TAG = "服务列表";
    private List<ServiceBean> serviceBeanList = new ArrayList<>();
    private UserBean userBean;
    static class ViewHolder extends RecyclerView.ViewHolder{

        View serviceView;

        TextView name ;
        TextView money ;
        TextView task1 ;
        ImageView go ;

        public ViewHolder(View itemView) {
            super(itemView);
            serviceView = itemView;

            name = serviceView.findViewById(R.id.name);
            money = serviceView.findViewById(R.id.money00);
            task1 = serviceView.findViewById(R.id.taskName1);
            go = serviceView.findViewById(R.id.go);
        }
    }

    public ServiceAdapter(List<ServiceBean> serviceBeanList, UserBean userBean) {
        Log.d(TAG, "适配器服务数量"+serviceBeanList.size());
        this.serviceBeanList = serviceBeanList;
        this.userBean = userBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.serviceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Toast.makeText(view.getContext(),"点击了第 "+position+" 个",Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ServiceAdapter.ViewHolder holder, int position) {
        ServiceBean serviceBean = serviceBeanList.get(position);
        holder.name.setText(serviceBean.getPublisher_id());
        holder.task1.setText(AllState.title[Integer.parseInt(serviceBean.getType())]);

        holder.money.setText("赏金： "+serviceBean.getMoney());
    }

    @Override
    public int getItemCount() {
        return serviceBeanList.size();
    }
}
