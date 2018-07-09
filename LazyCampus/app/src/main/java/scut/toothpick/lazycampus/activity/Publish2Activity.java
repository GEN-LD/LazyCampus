package scut.toothpick.lazycampus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import scut.toothpick.lazycampus.R;

public class Publish2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish2);
        final EditText misson1=findViewById(R.id.misson1editText);
        final EditText misson2=findViewById(R.id.misson2editText);
        final EditText misson3=findViewById(R.id.misson3editText);
        Button buttonconfirm=findViewById(R.id.buttonconfirm);
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
