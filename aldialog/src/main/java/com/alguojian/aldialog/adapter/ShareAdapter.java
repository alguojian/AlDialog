package com.alguojian.aldialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.alguojian.aldialog.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hello on 2017/9/27.
 */

public class ShareAdapter extends BaseAdapter {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    private List<String> list = new ArrayList<>();
    private LayoutInflater inflater;

    public ShareAdapter(Context context, List<String> list) {

        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;

        if (view == null) {

            view = inflater.inflate(R.layout.share_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.textView = (TextView) view.findViewById(R.id.textView);
            view.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(list.get(i));

        switch (i) {

            case ZERO:
                viewHolder.imageView.setImageResource(R.drawable.share_wechat);
                break;

            case ONE:
                viewHolder.imageView.setImageResource(R.drawable.sharetoqq);
                break;

            case TWO:
                viewHolder.imageView.setImageResource(R.drawable.share_weixinfriend);
                break;

            case THREE:
                viewHolder.imageView.setImageResource(R.drawable.share_qqkongjian);
                break;

            case FOUR:
                viewHolder.imageView.setImageResource(R.drawable.share_weibo);
                break;

            default:
                break;
        }

        return view;
    }


    private class ViewHolder {
        private ImageView imageView;
        private TextView textView;

    }
}
