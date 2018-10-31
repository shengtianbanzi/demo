package com.nyfz.httpdemo;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nyfz.httpdemo.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ServiceListActivity extends AppCompatActivity {

    private ArrayList<Serviceitem> mfruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);

        ListView listView=(ListView)findViewById(R.id.list_view);
        mfruitList=new ArrayList<Serviceitem>();
        initData();
        ServiceitemAdapter itemAdapter=new ServiceitemAdapter(this,R.layout.activity_service_item,mfruitList);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                Toast.makeText(ServiceListActivity.this,"您选择了" + mfruitList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s=   UrlManager.httpUrlConnectionGet("/test2/servlet/Getinfos");
                    JSONObject result = new JSONObject(s);
                    System.out.println(result);
                    JSONArray array = result.getJSONArray("infos");
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Serviceitem apple = new Serviceitem();
                        apple.setName(object.getString("Name"));
                        apple.setPrice(object.getString("Price"));
                        apple.setPhoto(object.getString("Photo"));
                        mfruitList.add(apple);
                    }
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
