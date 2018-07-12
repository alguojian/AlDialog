package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.GridView;

import com.alguojian.aldialog.R;
import com.alguojian.aldialog.adapter.ShareAdapter;

import java.util.ArrayList;

/**
 * Created by Hello on 2017/9/27.
 */

public class ShareDialog extends BaseBottomDialog {

    protected GridView gridView;
    private ArrayList<String> list;

    private OnListItemClick onItemClick;

    public ShareDialog(@NonNull Context context) {
        super(context,R.style.noWindowBottomSheetDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public ShareDialog setOnListItemClick(OnListItemClick onItemClick) {

        this.onItemClick = onItemClick;
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.shareqq_weixin_weibo;
    }

    @Override
    public void initView() {

        gridView = findViewById(R.id.gridView);
    }

    @Override
    public void initData() {

        list = new ArrayList<>();
        list.add(mContext.getString(R.string.weChat));
        list.add(mContext.getString(R.string.qq));
        list.add(mContext.getString(R.string.weChatFriends));
        list.add(mContext.getString(R.string.qzone));
        list.add(mContext.getString(R.string.sina));

        gridView.setAdapter(new ShareAdapter(mContext, list));

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {

            if (onItemClick != null) {
                onItemClick.onListItemClick(i);
            }

        });
    }

    public interface OnListItemClick {
        void onListItemClick(int position);
    }

}
