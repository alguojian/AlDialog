package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.alguojian.aldialog.R;

import java.lang.reflect.Field;


/**
 * @author ALguojian
 */

public abstract class BaseBottomDialog extends BottomSheetDialog {

    protected Context mContext;
    public BaseBottomDialog(@NonNull Context context,int style) {
        super(context,style);
        this.mContext = context;
        setContentView(LayoutInflater.from(context).inflate(getLayout(),null));
        initView();
        initData();

    }

    /**
     * xml,ID
     *
     * @return
     */
    public abstract int getLayout();

    /**
     * 初始化数据
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

}
