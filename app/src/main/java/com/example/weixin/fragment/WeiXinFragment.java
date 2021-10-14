package com.example.weixin.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.weixin.adapters.MyAdapter;
import com.example.weixin.R;
import com.example.weixin.util.WeiXin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeiXinFragment extends Fragment {
    List<WeiXin> list;
    ListView listView;
    View views;
    MyAdapter myAdapter;

    Random random=new Random();
    List<WeiXin> arrlist=new ArrayList<WeiXin>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weixin_message, container, false);
        listView = view.findViewById(R.id.list_view);
        this.views = view;
        init();
        return view;
    }





    public void init(){
        list=new ArrayList<WeiXin>();
        for (int i=0; i<8; i++){
            WeiXin wx1=new WeiXin(R.drawable.w1,"世俗","下班了，该吃饭了！！！","15:15");
            list.add(wx1);
            WeiXin wx2=new WeiXin(R.drawable.w2,"灭世","任务是啥？","15:01");
            list.add(wx2);
            WeiXin wx3=new WeiXin(R.drawable.w3,"找到月亮","做一个微信页面","14:50");
            list.add(wx3);
            WeiXin wx4=new WeiXin(R.drawable.w4,"遇到宇航员","争取拿到100%","14:35");
            list.add(wx4);
            WeiXin wx5=new WeiXin(R.drawable.w5,"M659","下班了，中午了","12:00");
            list.add(wx5);
            WeiXin wx6=new WeiXin(R.drawable.w6,"文凤","摸鱼ing","11:14");
            list.add(wx6);
            WeiXin wx7=new WeiXin(R.drawable.w7,"九海","清醒，清醒，要开始上班了","08:00");
            list.add(wx7);
            WeiXin wx8=new WeiXin(R.drawable.w8,"老六","早上起来了，该吃早饭了！！！","07:15");
            list.add(wx8);
        }
        update();
    }


        public void update() {
            arrlist.clear();
            for (int i = 0; i < 50; i++) {
                int n = random.nextInt(list.size());
                arrlist.add(list.get(n));
        }
            myAdapter = new MyAdapter(views.getContext(),arrlist);
            listView.setAdapter(myAdapter);
    }

}