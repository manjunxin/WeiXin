package com.example.weixin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weixin.adapters.FragAdapter;
import com.example.weixin.fragment.FaxianFragment;
import com.example.weixin.fragment.MineFragment;
import com.example.weixin.fragment.TongxunluFragment;
import com.example.weixin.fragment.WeiXinFragment;
import com.example.weixin.util.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout weixin_bottom,tongxunlu_bottom,faxian_bottom,mine_bottom,weixintop;
    WeiXinFragment weiXinFragment;
    TongxunluFragment tongxunluFragment;
    FaxianFragment faxianFragment;
    MineFragment mineFragment;

    List<Fragment> fragmentList = new ArrayList<>();

    //刷新
    SwipeRefreshLayout swipeRefreshLayout;

    //页面滑动
    ViewPager viewPager;
    FragAdapter fragAdapter ;
    TextView title ;
    public  void log(Object a){
        Log.d("显示", a+"");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inity();

        viewPager = findViewById(R.id.weixin_item);
        fragAdapter = new FragAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        viewPager.setAdapter(fragAdapter);
        viewPager.setCurrentItem(0);//初始设置ViewPager选中第一帧

        weixin_bottom.setBackgroundColor(Color.parseColor("#36a8ff"));
        log(viewPager.getAdapter());

        //滑动
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                changeColor(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        title =findViewById(R.id.weixinsize);
        weixintop=findViewById(R.id.weixin_top);

        //下拉刷新
        swipeRefreshLayout=findViewById(R.id.SwLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
    }
    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        weiXinFragment.update();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    //底部变色
    private void changeColor(int position) {
        if (position==0){
            title.setText("微信");
            weixintop.setVisibility(View.VISIBLE);
            weixin_bottom.setBackgroundColor(Color.parseColor("#36a8ff"));
            tongxunlu_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            faxian_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            mine_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }else if (position==1){
            title.setText("通讯录");
            weixintop.setVisibility(View.VISIBLE);
            weixin_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            tongxunlu_bottom.setBackgroundColor(Color.parseColor("#36a8ff"));
            faxian_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            mine_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }else if (position==2){
            title.setText("发现");
            weixintop.setVisibility(View.VISIBLE);
            weixin_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            tongxunlu_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            faxian_bottom.setBackgroundColor(Color.parseColor("#36a8ff"));
            mine_bottom.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }else if (position==3){
            weixintop.setVisibility(View.GONE);
            weixin_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            tongxunlu_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            faxian_bottom.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            mine_bottom.setBackgroundColor(Color.parseColor("#36a8ff"));
        }
    }

    public  void inity(){
        //碎片
        weiXinFragment = new WeiXinFragment();
        tongxunluFragment=new TongxunluFragment();
        faxianFragment=new FaxianFragment();
        mineFragment=new MineFragment();

        //添加进去
        fragmentList.add(weiXinFragment);
        fragmentList.add(tongxunluFragment);
        fragmentList.add(faxianFragment);
        fragmentList.add(mineFragment);

        weixin_bottom = findViewById(R.id.bottom_weixin);
        tongxunlu_bottom=findViewById(R.id.bottom_tongxunlu);
        faxian_bottom=findViewById(R.id.bottom_faxian);
        mine_bottom=findViewById(R.id.bottom_mine);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bottom_weixin:
                viewPager.setCurrentItem(0);
                break;
            case R.id.bottom_tongxunlu:
                viewPager.setCurrentItem(1);
                break;
            case R.id.bottom_faxian:
                viewPager.setCurrentItem(2);
                break;
            case R.id.bottom_mine:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "onclick add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "onclick remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }

        return true;
    }

   /* private void initData() {
        List<User> list = new ArrayList<>();
        String[] allUserNames = getResources().getStringArray(R.array.arrUsernames);
        for (String allUserName : allUserNames) {
            User user = new User();
            user.setUsername(allUserName);
            String convert = ChineseToPinyinHelper.getInstance().getPinyin(allUserName).toUpperCase();
            user.setPinyin(convert);
            String substring = convert.substring(0, 1);
            if (substring.matches("[A-Z]")) {
                user.setFirstLetter(substring);
            }else{
                user.setFirstLetter("#");
            }
            list.add(user);
        }
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User lhs, User rhs) {
                if (lhs.getFirstLetter().contains("#")) {
                    return 1;
                } else if (rhs.getFirstLetter().contains("#")) {
                    return -1;
                }else{
                    return lhs.getFirstLetter().compareTo(rhs.getFirstLetter());
                }
            }
        });
    }*/
}