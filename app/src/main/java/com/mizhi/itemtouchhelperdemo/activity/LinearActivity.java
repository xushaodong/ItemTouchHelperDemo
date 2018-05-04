package com.mizhi.itemtouchhelperdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.mizhi.itemtouchhelperdemo.ItemHelperCallback;
import com.mizhi.itemtouchhelperdemo.ItemTouchHelperAdapter;
import com.mizhi.itemtouchhelperdemo.R;
import com.mizhi.itemtouchhelperdemo.SimpleItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 *
 * @Author 许少东
 * Created at 2018/5/3.
 */

public class LinearActivity extends BaseActivity implements ItemTouchHelperAdapter.OnItemClickCallback {
    private RecyclerView mRecyclerView;
    private ItemTouchHelperAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_main);
    }

    private void initData() {
        setData();
        adapter = new ItemTouchHelperAdapter();
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
        adapter.setData(data);
        adapter.setCallback(this);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(SimpleItemTouchHelperCallback.LINEAER_LAYOUT,
                new ItemHelperCallback() {
            @Override
            public void onItemMove(int fromPosition, int toPosition) {
                adapter.onItemMove(fromPosition, toPosition);
            }

            @Override
            public void onItemDismiss(int position) {
                adapter.onItemDismiss(position);
            }
        });
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);

    }

    private void setData() {
        for (int i = 0; i < 50; i++) {
            data.add("第" + i + "行数据");
        }
    }

    @Override
    public void onItemClick(String text) {
        showToast(text);
    }
}
