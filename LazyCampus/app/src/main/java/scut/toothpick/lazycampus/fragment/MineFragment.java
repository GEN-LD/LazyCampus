package scut.toothpick.lazycampus.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.activity.MainActivity;
import scut.toothpick.lazycampus.activity.ProfileActivity;
import scut.toothpick.lazycampus.bean.UserBean;


public class MineFragment extends Fragment {

    private Button toMyProfile;
    LinearLayout toPro;
    LinearLayout exitLayout;
    UserBean userBean;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, container, false);
        getData();

        toPro = view.findViewById(R.id.toProfile);
        toPro.setClickable(true);
        toPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                String userJson = new Gson().toJson(userBean);
                intent.putExtra("user",userJson);
                startActivity(intent);
            }
        });
        exitLayout = view.findViewById(R.id.exitLayout);
        exitLayout.setClickable(true);
        exitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("确认退出吗");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(),"退出成功！",Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
        return view;
    }

    private void getData(){
        MainActivity mainActivity = (MainActivity)getActivity();
        userBean = mainActivity.getUser();
    }
}
