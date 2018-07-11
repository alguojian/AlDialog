package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;

import com.alguojian.aldialog.R;


/**
 * @author ALguojian
 */

public class LoadingDialog extends BaseDialog {

    private static final int ONE = 1;
    private int mPosition = 1;
    private Context mContext;

    /**
     * 是否要全屏
     */
    private boolean mBoolean = false;

    public LoadingDialog(@NonNull Context context, int position) {

        super(context, R.style.LoadingDialog);
        this.mPosition = position;
        this.mContext = context;
    }

    @Override
    public void initView() {

    }

    public LoadingDialog(@NonNull Context context, int position, boolean flag) {
        super(context, R.style.LoadingDialog);
        this.mPosition = position;
        this.mBoolean = flag;
        this.mContext = context;
    }

    @Override
    public void show() {
        super.show();

        if (mBoolean) {
            Window window = this.getWindow();

            //设置窗口的属性，以便设设置
            WindowManager.LayoutParams layoutParams = window.getAttributes();

            layoutParams.x = 0;
            layoutParams.y = 0;

            Point size = new Point();
            this.getWindow().getWindowManager().getDefaultDisplay().getSize(size);
            layoutParams.width = size.x;
            layoutParams.height = size.y;
            window.setAttributes(layoutParams);
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        //1是默认圆环，2是菊花

        if (ONE == mPosition) {
            if (mBoolean)
                return R.layout.loading_dialog_full_screen;
            return R.layout.loading_dialog;
        }
        return mBoolean ? R.layout.loading2_dialog_full_screen : R.layout.loading2_dialog;
    }
}
