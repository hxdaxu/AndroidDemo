package com.hqc.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mDataList = new ArrayList<String>();

    public MainListViewAdapter(Context context,String [] dataArray) {
        mContext = context;
        for (int i = 0; i < dataArray.length; i++) {
            mDataList.add(dataArray[i]);
        }
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.itemview_mainlist, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.itemview_mainlist_textview);
            convertView.setTag(viewHolder);
        }
       ((ViewHolder)convertView.getTag()).textView.setText(mDataList.get(position));
        return convertView;
    }

    public class ViewHolder{
        public TextView textView;
    }
}
