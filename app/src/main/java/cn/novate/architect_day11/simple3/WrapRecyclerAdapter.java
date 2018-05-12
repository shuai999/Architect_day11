package cn.novate.architect_day11.simple3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 17:25
 * Version 1.0
 * Params:
 * Description:    装饰设计模式的 RecyclerView.Adapter - 我们对其进行功能扩展，使其能够支持头部和底部的添加
*/

public class WrapRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    // 原来的 RecyclerView.Adapter，并不支持头部和底部的添加
    private final RecyclerView.Adapter mRealAdapter ;

    ArrayList<View> mHeaderViews;
    ArrayList<View> mFooterViews;



    public WrapRecyclerAdapter(RecyclerView.Adapter adapter){
        this.mRealAdapter = adapter ;


        // 只要MainActivity中调用了 notifyDataSetChanged，
        // 这里就会收到通知，然后在这里也调用 notifyDataSetChanged方法，就能够删除item了
        mRealAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                notifyDataSetChanged();
            }
        });



        mHeaderViews = new ArrayList() ;
        mFooterViews = new ArrayList<>() ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        // 现在问题就是：如果想知道是哪个部分，就必须知道 position，也就是位置，但是目前只有 viewType

        // 头部返回 头部的ViewHolder
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return createHeaderFooterViewHolder(mHeaderViews.get(position));
        }
        // mRealAdapter返回 mRealAdapter的ViewHolder
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                // 直接传 position ,不兼容 万能适配多布局条目
                return mRealAdapter.onCreateViewHolder(parent,mRealAdapter.getItemViewType(adjPosition));
            }
        }
        // 底部返回 底部的ViewHolder
        return createHeaderFooterViewHolder(mFooterViews.get(adjPosition - adapterCount));
    }


    @Override
    public int getItemViewType(int position) {
        // 把 位置postion 作为 viewType
        return position;
    }

    public int getHeadersCount() {
        return mHeaderViews.size();
    }

    public int getFootersCount() {
        return mFooterViews.size();
    }


    private RecyclerView.ViewHolder createHeaderFooterViewHolder(View view) {
        return new RecyclerView.ViewHolder(view){};
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 头部和底部是不需要处理的，只有中间的 mRealAdapter需要处理
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return ;
        }

        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mRealAdapter.onBindViewHolder(holder,position);
            }
        }
    }

    /**
     * 总共返回有多少条 = 头部条数 + 真实的Adapter条数 + 底部条数
     */
    @Override
    public int getItemCount() {
        return mHeaderViews.size() + mRealAdapter.getItemCount() + mFooterViews.size();
    }


    /**
     * 添加头部
     */
    public void addHeaderView(View view){
        if (!mHeaderViews.contains(view)){
            mHeaderViews.add(view) ;
            notifyDataSetChanged();
        }
    }


    /**
     * 添加底部
     */
    public void addFooterView(View view){
        if (!mFooterViews.contains(view)){
            mFooterViews.add(view) ;
            notifyDataSetChanged();
        }
    }


    /**
     * 移除头部
     */
    public void removeHeaderView(View view){
        if(mHeaderViews.contains(view)){
            mHeaderViews.remove(view) ;
            notifyDataSetChanged();
        }
    }


    /**
     * 移除底部
     */
    public void removeFooterView(View view){
        if (mFooterViews.contains(view)){
            mFooterViews.remove(view) ;
            notifyDataSetChanged();
        }
    }
}
