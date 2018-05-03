package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.alguojian.aldialog.R;
import com.alguojian.aldialog.adapter.ShareAdapter;

import java.util.ArrayList;

/**
 * Created by Hello on 2017/9/27.
 */

public class ShareDialog extends BaseDialog {

    protected GridView gridView;
    private boolean flag;
    private boolean arr;
    private ArrayList<String> list;
    private Context context;

    private onItemClick onItemClick;

    public ShareDialog(@NonNull Context context) {
        super(context, R.style.HomeDialog);
        this.context = context;
    }

    public ShareDialog setOnItemClick(onItemClick onItemClick) {

        this.onItemClick = onItemClick;
        return this;
    }

    /**
     * 返回键消失
     *
     * @param flag
     * @return
     */
    public ShareDialog setDissmissByBack(boolean flag) {

        this.flag = flag;
        return this;
    }

    /**
     * 空白处消失
     *
     * @param arr
     * @return
     */
    public ShareDialog setDissmissByOutside(boolean arr) {

        this.arr = arr;
        return this;
    }

    @Override
    public int getLayout() {
        return R.layout.shareqq_weixin_weibo;
    }

    @Override
    public void initView() {

        gridView = findViewById(R.id.gridView);
        setButtomAndWidth();
        sssssssss(flag, arr);
    }

    @Override
    public void initData() {

        list = new ArrayList<>();
        list.add(context.getString(R.string.weChat));
        list.add(context.getString(R.string.qq));
        list.add(context.getString(R.string.weChatFriends));
        list.add(context.getString(R.string.qzone));
        list.add(context.getString(R.string.sina));

        gridView.setAdapter(new ShareAdapter(context, list));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (onItemClick != null) {
                    onItemClick.onItemClick(i);
                }

            }
        });
    }

    public interface onItemClick {
        void onItemClick(int position);
    }

}
