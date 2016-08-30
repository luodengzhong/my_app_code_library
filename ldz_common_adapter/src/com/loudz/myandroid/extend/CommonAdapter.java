package com.loudz.myandroid.extend;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;

    protected List mDatas;

    protected LayoutInflater mInflater;

    protected int mItemLayoutId;

    private <T> CommonAdapter() {

    }

    public <T> CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
        mContext = context;
        mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.get(mContext, position, convertView, parent, mItemLayoutId);
        convert(viewHolder, (T) mDatas.get(position));
        return viewHolder.getConvertView();
    }

    protected abstract void convert(ViewHolder viewHolder, T bean);

}
