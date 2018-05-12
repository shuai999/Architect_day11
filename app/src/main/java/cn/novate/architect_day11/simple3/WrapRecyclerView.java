package cn.novate.architect_day11.simple3;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/12 18:47
 * Version 1.0
 * Params:
 * Description:    封装的 WrapRecyclerView，替代 原始的 RecyclerView
*/

public class WrapRecyclerView extends RecyclerView {

    private WrapRecyclerAdapter mAdapter ;

    public WrapRecyclerView(Context context) {
        super(context);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void setAdapter(Adapter adapter) {
        mAdapter = new WrapRecyclerAdapter(adapter) ;
        super.setAdapter(adapter);
    }

    /**
     * 添加头部
     */
    public void addHeaderView(View view){
        // 必须是：在设置 adapter之后，才能够去设置头部和底部
        if (mAdapter != null){
            mAdapter.addHeaderView(view);
        }
    }


    /**
     * 添加底部
     */
    public void addFooterView(View view){
        if (mAdapter != null){
            mAdapter.addFooterView(view);
        }
    }


    /**
     * 移除头部
     */
    public void removeHeaderView(View view){
        if (mAdapter != null){
            mAdapter.removeHeaderView(view);
        }
    }


    /**
     * 移除底部
     */
    public void removeFooterView(View view){
        if (mAdapter != null){
            mAdapter.removeFooterView(view);
        }
    }
}
