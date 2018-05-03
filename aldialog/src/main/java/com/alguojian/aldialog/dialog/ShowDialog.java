package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alguojian.aldialog.R;


/**
 * Created by Hello on 2017/6/29.
 */

public class ShowDialog extends BaseDialog {

    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTv;//消息标题文本
    private TextView messageTv;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private int titleColor;//从外界设置的title文本
    private int messageColor;//从外界设置的title文本
    private int yesColor;//从外界设置的title文本
    private int cancleColor;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    private boolean flag;
    private boolean arr;
    //确定文本和取消文本的显示内容
    private String yesStr, noStr;
    private Context context;

    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器

    public ShowDialog(@NonNull Context context) {
        super(context, R.style.HomeDialog);
        this.context = context;
    }

    /**
     * 返回键消失
     *
     * @param flag
     * @return
     */
    public ShowDialog setDissmissByBack(boolean flag) {

        this.flag = flag;
        return this;
    }


    /**
     * 空白处消失
     *
     * @param arr
     * @return
     */
    public ShowDialog setDissmissByOutside(boolean arr) {

        this.arr = arr;
        return this;
    }

    /**
     * 设置取消按钮的显示内容和监听
     */
    public ShowDialog setNoOnclickListener(onNoOnclickListener onNoOnclickListener) {
        this.noOnclickListener = onNoOnclickListener;
        return this;
    }

    /**
     * 设置确定按钮的显示内容和监听
     */
    public ShowDialog setYesOnclickListener(onYesOnclickListener onYesOnclickListener) {

        this.yesOnclickListener = onYesOnclickListener;
        return this;
    }


    @Override
    public int getLayout() {
        return R.layout.show_dialog;
    }


    /**
     * 初始化界面控件的显示数据
     */
    @Override
    public void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            titleTv.setText(titleStr);
            titleTv.setTextColor(titleColor);
        }
        if (messageStr != null) {
            messageTv.setText(messageStr);
            messageTv.setTextColor(messageColor);
        }
        //如果设置按钮的文字
        if (yesStr != null) {
            yes.setText(yesStr);
            yes.setTextColor(yesColor);
        }
        if (noStr != null) {
            no.setText(noStr);
            no.setTextColor(cancleColor);
        }

        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                    dismiss();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                    dismiss();
                }
            }
        });
    }

    /**
     * 初始化界面控件
     */
    @Override
    public void initView() {

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        titleTv = findViewById(R.id.title);
        messageTv = findViewById(R.id.message);
        sssssssss(flag, arr);
    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public ShowDialog setTitle(String title, int color) {
        titleStr = title;
        titleColor = color;

        return this;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     */
    public ShowDialog setMessage(String message, int color) {
        messageStr = message;
        messageColor = color;

        return this;
    }

    /**
     * 设置右边按钮信息
     *
     * @param yes
     * @param color
     */
    public ShowDialog setYesColor(String yes, int color) {
        yesColor = color;
        yesStr = yes;
        return this;
    }

    /**
     * 设置左边按钮信息
     *
     * @param color
     */
    public ShowDialog setCancleColor(String cancle, int color) {
        cancleColor = color;
        noStr = cancle;
        return this;
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }

}
