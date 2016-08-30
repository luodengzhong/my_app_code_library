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
        item1.put("title", "��Ůһ֦");
        item1.put("content", "����ȥ�ﳵ��ˣ��ż����Ůһö");
        item1.put("date", "20160807");
        item1.put("number", "15520701261");
        mData.add(item1);
        Map<String, String> item2 = new HashMap<>();
        item2.put("title", "����������");
        item2.put("content", "����ҹ���һ��·�磬����30���ﴦ�������ˣ�����45���");
        item2.put("date", "20160808");
        item2.put("number", "15520701261");
        mData.add(item2);
        Map<String, String> item3 = new HashMap<>();
        item3.put("title", "��������");
        item3.put("content", "�ϰ�·���������ϰ�ң���ס��ȥ·�����³ٵ�");
        item3.put("date", "20160809");
        item3.put("number", "15520701261");
        mData.add(item3);

    }
}
