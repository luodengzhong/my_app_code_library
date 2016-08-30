package com.loudz.myandroid.extend;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewHolder {

    // convertView中包含的控件，第一镒用到后就把引用保存起来，下次用到时就不需要findbyid了，提高了效率。
    private SparseArray<View> mViews;

    private View convertView;

    private int position;

    private ViewHolder() {
    }

    public ViewHolder(Context context, int position, View convertView, ViewGroup parent, int layoutId) {
        this.convertView = convertView;
        this.position = position;
        mViews = new SparseArray<View>();
    }

    public static ViewHolder get(Context context, int position, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, null);
            convertView.setTag(new ViewHolder(context, position, convertView, parent, layoutId));
        }
        return (ViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return this.convertView;
    }

    @SuppressWarnings("unchecked")
    public <T> T getView(int viewId, Class<T> clazz) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public <T extends View> View getView(int viewId) {
        return convertView.findViewById(viewId);
    }
}
