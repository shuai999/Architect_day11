package cn.novate.architect_day11.simple3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.novate.architect_day11.R;
import cn.novate.architect_day11.simple2.PersonEat;
import cn.novate.architect_day11.simple2.TeacherEat;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 17:06
 * Version 1.0
 * Params:
 * Description:
*/

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView ;
    private List<Integer> mItems;
    private WrapRecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_recyclerview) ;  // activity_main

        mItems = new ArrayList<>();
        for (int i=0;i<100;i++){
            mItems.add(i);
        }

        // 使用原始 RecyclerView，每次都必须 创建RecyclerView，然后写装饰设计模式WrapRecyclerAdapter
        // 把 RecyclerAdapter 包装到 WrapRecyclerAdapter中，然后setAdapter时候 设置 WrapRecyclerAdapter
        // 比较麻烦 ，下边 把RecyclerView封装成WrapRecyclerView
        /*
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view) ;
        // RecyclerView必须设置布局管理，否则没有数据
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        *//*mRecyclerView.setAdapter(new RecyclerAdapter());*//*

        // 采用装饰设计模式，让其支持添加头部和底部
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter() ;
        WrapRecyclerAdapter wrapRecyclerAdapter = new WrapRecyclerAdapter(recyclerAdapter) ;
        mRecyclerView.setAdapter(wrapRecyclerAdapter);
        // 添加头部 下边这两种效果是一样的 ，但是这种写法有问题，就是头部只有一小部分，并没有充满屏幕
        // 原因就是：父布局容器为null，才导致没有充满屏幕的，只需要添加一个父布局容器，把null修改为mRecyclerView就可以了
//        View headView = LayoutInflater.from(this).inflate(R.layout.layout_header_view , null) ;
//        View headView = LayoutInflater.from(this).inflate(R.layout.layout_header_view , null , false) ;
        View headView = LayoutInflater.from(this).inflate(R.layout.layout_header_view , mRecyclerView , false) ;
        wrapRecyclerAdapter.addHeaderView(headView);*/


        //  把RecyclerView封装成WrapRecyclerView
        recycler_view = (WrapRecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(new RecyclerAdapter());
        View headView = LayoutInflater.from(this).inflate(R.layout.layout_header_view , recycler_view , false) ;
        recycler_view.addHeaderView(headView);

    }


    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_rv , parent , false) ;
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.text.setText("position = "+mItems.get(position));

            // 这里是删除RecyclerView 的 item，在这里移除当前item，调用notifyDataSetChanged
            // 然后在WrapRecyclerAdapter的构造方法中 注册观察者registerAdapterDataObserver，
            // 再去调用调用notifyDataSetChanged就可以删除item了
            holder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItems.remove(position) ;
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            public TextView text ;
            public ViewHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.text) ;
            }
        }
    }
}
