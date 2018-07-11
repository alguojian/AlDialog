package com.alguojian.aldialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.alguojian.aldialog.R;


/**
 * @author ALguojian
 */

public abstract class BaseDialog extends Dialog {

    public BaseDialog(@NonNull Context context, int style) {
        super(context, style);
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
     * 设置宽度全屏，并从下面弹出，添加动画
     */
    public void setCenter() {
        Window w = getWindow();
        w.setWindowAnimations(R.style.common_DialogAnimation);
        w.setGravity(Gravity.CENTER);
    }

    public void setBottomDialog() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        Window w = getWindow();
        w.setWindowAnimations(R.style.bottom_dialog_popWindow);
        w.setGravity(Gravity.BOTTOM);
        ViewGroup.LayoutParams lay = getWindow().getAttributes();
        lay.width = dm.widthPixels;
    }


}
