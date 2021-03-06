package tw.com.abc.mylisttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {
    private ListView list;
    private String[] data={"Android","iOS","Windows","UNIX"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        list=(ListView)findViewById(R.id.page2_list);
        initListView();
    }
    private void initListView(){
        list.setAdapter(new MyAdapter());
    }
    private class MyAdapter extends BaseAdapter{
        private LayoutInflater inflater;

        MyAdapter(){
            inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return data.length;
        }

        //getView 版面
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                //if(position%2 == 0){
                    convertView=inflater.inflate(R.layout.layout2_item,null);
                    TextView tv=(TextView) (convertView.findViewById(R.id.item2_tv));
                    tv.setText(data[position]);
                //}
            //}else{
            //    convertView=inflater.inflate(R.layout.)
            }
            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }
    }
}
