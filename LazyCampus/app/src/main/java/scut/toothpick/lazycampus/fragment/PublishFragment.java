package scut.toothpick.lazycampus.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.activity.MainActivity;
import scut.toothpick.lazycampus.activity.Publish2Activity;
import scut.toothpick.lazycampus.bean.ResultBean;
import scut.toothpick.lazycampus.bean.UserBean;


public class PublishFragment extends Fragment {

    private UserBean userBean;
    public static final String TAG = "发布页面";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_publish, container, false);

        Button buttonpublish=view.findViewById(R.id.buttonpublish);
        Button buttonto=view.findViewById(R.id.earnbutton);
        EditText name=view.findViewById(R.id.editText);
        final EditText detail=view.findViewById(R.id.detaileditText);
        final EditText money=view.findViewById(R.id.moneyeditText);
        final EditText time=view.findViewById(R.id.timeeditText);
        getUser();
        buttonpublish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String content = detail.getText().toString();
                String endtime = time.getText().toString();
                String money1 = money.getText().toString();
                //获取当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
                //请求
                sendAddTaskReq(content,date,money1);
            }
        });
        buttonto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), Publish2Activity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void getUser(){
        MainActivity mainActivity = (MainActivity)getActivity();
        userBean = mainActivity.getUser();

    }
    private void sendAddTaskReq(final String content, final String endtime, final String money1){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "money "+money1);
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("content", content)
                            .add("money", money1)
                            .add("publish_time",endtime)
                            .add("publish_id",userBean.getStudent_id())
                            .build();
                    Request request = new Request.Builder()
                            .url("http://123.56.13.200/Toothpick/Home/Campus/addNewTask")
                            .post(requestBody)
                            .build();
                    Response response=client.newCall(request).execute();
                    String resposeData=response.body().string();
                    ResultBean bean = new Gson().fromJson(resposeData,ResultBean.class);
                    if(bean.getMsg().equals("success")) {
//                        Toast.makeText(getContext(),"发布成功！",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "发布成功");
                    } else {
//                        Toast.makeText(getContext(),"发布失败！",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "发布失败");
                    }
                    Log.d(TAG, resposeData);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
