package com.alguojian.aldialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;

import com.alguojian.aldialog.R;


/**
 * @author ALguojian
 */

public abstract class BaseDialog extends Dialog {

    public BaseDialog(@NonNull Context context, int style) {
        super(context, style);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
    }


    /**
     * 初始化数据
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * xml,ID
     * @return
     */
    public abstract int getLayout();

    /**
     * 设置返回键，和dialog焦点外点击事件
     * @param flag
     * @param arr
     */
    public void sssssssss(boolean flag, boolean arr) {

        setCancelable(flag);
        setCanceledOnTouchOutside(arr);

    }

    /**
     * 设置宽度全屏，并从下面弹出，添加动画
     */
    public void setButtomAndWidth() {

        getWindow().setGravity(Gravity.BOTTOM); //显示在底部
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = d.getWidth(); //设置dialog的宽度为当前手机屏幕的宽度
        getWindow().setAttributes(p);
        getWindow().setWindowAnimations(R.style.popWindow);

    }


}
