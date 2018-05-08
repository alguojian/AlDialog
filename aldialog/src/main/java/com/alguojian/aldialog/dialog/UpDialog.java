package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alguojian.aldialog.R;

/**
 * @author ALguojian
 */

public class UpDialog extends BaseDialog {

    private boolean flag;
    private boolean arr;
    public UpDialog(@NonNull Context context) {
        super(context, R.style.HomeDialog);
    }

    /**
     * 返回键消失
     * @param flag
     * @return
     */
    public UpDialog setDissmissByBack(boolean flag) {

        this.flag = flag;
        return this;
    }

    /**
     * 空白处消失
     *
     * @param arr
     * @return
     */
    public UpDialog setDissmissByOutside(boolean arr) {

        this.arr = arr;
        return this;
    }


    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.loading2_dialog;
    }

}
