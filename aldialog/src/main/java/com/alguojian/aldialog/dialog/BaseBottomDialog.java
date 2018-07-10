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
    public BaseBottomDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
        setContentView(LayoutInflater.from(context).inflate(getLayout(),null));
        initView();
        initData();

    }


    public void setNoScroll(BottomSheetDialog bottomSheetDialog){
        try {
            Field mBehaviorField = bottomSheetDialog.getClass().getDeclaredField("mBehavior");
            mBehaviorField.setAccessible(true);
            final BottomSheetBehavior behavior = (BottomSheetBehavior) mBehaviorField.get(bottomSheetDialog);
            behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                }
            });
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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
