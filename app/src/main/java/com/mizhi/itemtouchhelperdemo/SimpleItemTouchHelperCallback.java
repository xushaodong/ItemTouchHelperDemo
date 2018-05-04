package com.mizhi.itemtouchhelperdemo;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * 类描述：
 *
 * @Author 许少东
 * Created at 2018/5/3.
 */

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    public static final int LINEAER_LAYOUT = 1;
    public static final int GRID_LAYOUT = 2;
    private ItemHelperCallback callback;
    private int type = 1;
    private int dragFlags;
    private int swipeFlags;

    public SimpleItemTouchHelperCallback(int type,ItemHelperCallback callback) {
        this.callback = callback;
        this.type = type;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (type == LINEAER_LAYOUT) {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        } else if (type == GRID_LAYOUT) {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                    ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            swipeFlags = 0;
        }
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        callback.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        callback.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView,
                            RecyclerView.ViewHolder viewHolder, float dX, float dY,
                            int actionState, boolean isCurrentlyActive) {

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            float width = (float) viewHolder.itemView.getWidth();
            float alpha = 1.0f - Math.abs(dX) / width;
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setTranslationX(dX);
        } else {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY,
                    actionState, isCurrentlyActive);
        }
    }

}
