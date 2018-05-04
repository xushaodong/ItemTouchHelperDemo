package com.mizhi.itemtouchhelperdemo;

/**
 * 类描述：
 *
 * @Author 许少东
 * Created at 2018/5/3.
 */

public interface ItemHelperCallback {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);


}
