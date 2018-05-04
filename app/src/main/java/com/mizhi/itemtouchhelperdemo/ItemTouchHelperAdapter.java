package com.mizhi.itemtouchhelperdemo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * 类描述：
 *
 * @Author 许少东
 * Created at 2018/5/3.
 */

public class ItemTouchHelperAdapter extends RecyclerView.Adapter<ItemTouchHelperAdapter.MyViewHolde>
        implements ItemHelperCallback {
    private static final String TAG = ItemTouchHelperAdapter.class.getSimpleName();
    private List<String> data;
    private OnItemClickCallback mCallback;

    @Override
    public MyViewHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApplication.mAppContext).inflate(R.layout.item_demo, parent, false);
        return new MyViewHolde(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolde holder, final int position) {
        if (holder instanceof MyViewHolde) {
            holder.mTextView.setText(data.get(position));
            ((MyViewHolde) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mCallback != null){
                        mCallback.onItemClick(data.get(position));
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Log.i(TAG, "-------onItemMove------fromPosition:" + fromPosition);
        Log.i(TAG, "-------onItemMove------toPosition:" + toPosition);
        Collections.swap(data, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        Log.i(TAG, "-------onItemDismiss-----:" + position);
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void setCallback(OnItemClickCallback callback){
        mCallback = callback;
    }

    class MyViewHolde extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyViewHolde(View view) {
            super(view);
            mTextView = view.findViewById(R.id.tv_item_name);
        }
    }

    public interface OnItemClickCallback{
        void onItemClick(String text);
    }
}
