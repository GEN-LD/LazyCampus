package scut.toothpick.lazycampus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import scut.toothpick.lazycampus.R;

/**
 * Created by dgliang on 2018/7/10.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    public static final String TAG = "服务列表";

    public static class ViewHolder extends RecyclerView.ViewHolder{

        View serviceView;

        TextView name = serviceView.findViewById(R.id.name);
        TextView credit = serviceView.findViewById(R.id.grade);
        TextView task1 = serviceView.findViewById(R.id.taskName1);
        TextView task2 = serviceView.findViewById(R.id.taskName2);
        TextView task3 = serviceView.findViewById(R.id.taskName3);
        ImageView go = serviceView.findViewById(R.id.go);

        public ViewHolder(View itemView) {
            super(itemView);
            serviceView = itemView;
        }
    }
    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ServiceAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
