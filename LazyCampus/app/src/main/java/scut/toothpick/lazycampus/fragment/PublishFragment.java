package scut.toothpick.lazycampus.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.activity.Publish2Activity;


public class PublishFragment extends Fragment {
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
        buttonpublish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String content=detail.getText().toString();
                String endtime=time.getText().toString();
                String money1=money.getText().toString();
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("content", content).add("money", money1).add("publish_time",endtime).build();
                    Request request = new Request.Builder().url("http://123.56.13.200/Toothpick/Home/Campus/addNewTask").post(requestBody).build();
                    Response response=client.newCall(request).execute();
                    String resposeData=response.body().string();
                    System.out.print(resposeData);
                }
                catch (Exception e){
                    System.out.println(e);
                }
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
}
