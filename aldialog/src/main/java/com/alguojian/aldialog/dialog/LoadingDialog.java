package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alguojian.aldialog.R;


/**
 * @author ALguojian
 */

public class LoadingDialog extends BaseDialog {

    private static final int ONE = 1;
    private boolean flag = true;
    private boolean arr = true;
    private int mPosition = 1;

    public LoadingDialog(@NonNull Context context, int position) {

        super(context, R.style.LoadingDialog);
        this.mPosition = position;

    }


    /**
     * 返回键消失
     *
     * @param flag
     * @return
     */
    public LoadingDialog setDissmissByBack(boolean flag) {

        this.flag = flag;
        return this;
    }

    /**
     * 空白处消失
     *
     * @param arr
     * @return
     */
    public LoadingDialog setDissmissByOutside(boolean arr) {

        this.arr = arr;
        return this;
    }


    @Override
    public void initView() {
        sssssssss(flag, arr);

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        //1是默认圆环，2是菊花
        return ONE == mPosition ? R.layout.loading_dialog : R.layout.loading2_dialog;
    }
}
