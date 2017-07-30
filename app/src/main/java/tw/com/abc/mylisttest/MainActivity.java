package tw.com.abc.mylisttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private List<Map<String,Object>> data;
    private SimpleAdapter adapter;
    private String[] from ={"txxx","coxx","imxxx"};
    private int[] to ={R.id.item_title,R.id.item_content,R.id.img};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        initListView();
    }
    public void initListView(){

        // 用Map放ListItem 的資料
        Map<String,Object> d0 =new HashMap<>();
        d0.put(from[0],"Title 1");
        d0.put(from[1],"Content 1");
        d0.put(from[2],R.drawable.android);

        Map<String,Object> d1 =new HashMap<>();
        d1.put(from[0],"Title 2");
        d1.put(from[1],"Content 2");
        d0.put(from[2],R.drawable.android);

        // 把Map 放到 List中
        data= new LinkedList<>();
        data.add(d0);
        data.add(d1);

        adapter=new SimpleAdapter(this,data,R.layout.layout_item,from,to);
        list.setAdapter(adapter);
        // 偵測 list 下的Item 被按下時做動作
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.i("geoff","item="+position);
                if(position ==0){
                    // 這裡的 Intent()中,必須用MainActivity.this
                    Intent it = new Intent(MainActivity.this,Page2Activity.class);
                    startActivity(it);
                }

            }
        });
    }
    public void addData(View view){
        Map<String,Object> d0 = new HashMap<>();
        d0.put(from[0],"Title 3");
        d0.put(from[1],"Content 3");
        d0.put(from[2],R.drawable.android);
        data.add(d0);

        adapter.notifyDataSetChanged();
    }
}
