package com.loudz.myandroid.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.loudz.myandroid.extend.CommonAdapter;
import com.loudz.myandroid.extend.ViewHolder;
import com.loudz.myandroidextend.R;

public class MainActivity extends Activity {

    private ListView listview;

    private CommonAdapter listViewAdapter;

    private Button refresh;

    private List<Map<String, String>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {

        listview = (ListView) findViewById(R.id.listview);
        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                refreshListData();
                listViewAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        refreshListData();
        listview.setAdapter(listViewAdapter = new CommonAdapter<Map<String, String>>(this, mData, R.layout.list_item) {

            @Override
            protected void convert(ViewHolder viewHolder, Map<String, String> bean) {
                viewHolder.getView(R.id.item_title, TextView.class).setText(bean.get("title"));
                viewHolder.getView(R.id.item_content, TextView.class).setText(bean.get("content"));
                viewHolder.getView(R.id.item_date, TextView.class).setText(bean.get("date")); 
                viewHolder.getView(R.id.item_phone, TextView.class).setText(bean.get("number"));
            }

        });
    }

    private void refreshListData() {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        Map<String, String> item1 = new HashMap<>();
        item1.put("title", "美女一枝");
        item1.put("content", "上周去骑车的耍，偶遇美女一枚");
        item1.put("date", "20160807");
        item1.put("number", "15520701261");
        mData.add(item1);
        Map<String, String> item2 = new HashMap<>();
        item2.put("title", "周三晚被拉爆");
        item2.put("content", "周三夜骑，遇一公路哥，我在30公里处被拉爆了，来回45公里。");
        item2.put("date", "20160808");
        item2.put("number", "15520701261");
        mData.add(item2);
        Map<String, String> item3 = new HashMap<>();
        item3.put("title", "周四以致");
        item3.put("content", "上班路上遇到蚂蚁搬家，挡住了去路，导致迟到");
        item3.put("date", "20160809");
        item3.put("number", "15520701261");
        mData.add(item3);

    }
}
