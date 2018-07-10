package scut.toothpick.lazycampus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import scut.toothpick.lazycampus.R;

public class Publish2Activity extends AppCompatActivity {

    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish2);
        final EditText misson1=findViewById(R.id.misson1editText);
        final EditText misson2=findViewById(R.id.misson2editText);
        final EditText misson3=findViewById(R.id.misson3editText);
        Button buttonconfirm=findViewById(R.id.buttonconfirm);
        final Spinner spinner1=findViewById(R.id.spinner1);
        final Spinner spinner2=findViewById(R.id.spinner2);
        final Spinner spinner3=findViewById(R.id.spinner3);
        data_list = new ArrayList<String>();
        data_list.add("取快递");
        data_list.add("拿外卖");
        data_list.add("课程辅导");
        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner1.setAdapter(arr_adapter);
        spinner2.setAdapter(arr_adapter);
        spinner3.setAdapter(arr_adapter);
        buttonconfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String misson11=misson1.getText().toString();
                String misson22=misson2.getText().toString();
                String misson33=misson3.getText().toString();
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("content", "detail").add("money", "money1").build();
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
    }
}
