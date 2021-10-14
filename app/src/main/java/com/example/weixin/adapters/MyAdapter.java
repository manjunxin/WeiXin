package com.example.weixin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weixin.R;
import com.example.weixin.util.WeiXin;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<WeiXin> list;

    public MyAdapter(Context context, List<WeiXin> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView  = LayoutInflater.from(context).inflate(R.layout.weixin_item,null);
        ImageView imageView= convertView.findViewById(R.id.weixin_photo);
        TextView txt = convertView.findViewById(R.id.weixin_name);
        TextView txt1 = convertView.findViewById(R.id.weixin_message);
        TextView time = convertView.findViewById(R.id.weixin_time);
        WeiXin fruit = list.get(position);
        imageView.setImageResource(fruit.getImage());
        txt.setText(fruit.getName());
        txt1.setText(fruit.getMessage());
        time.setText(fruit.getTime());
        return convertView;
    }
}
