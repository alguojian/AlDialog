package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.alguojian.aldialog.R;

/**
 * 加载成功的dialog，显示3秒
 * 2018/5/8
 *
 * @author alguojian
 */

public class SuccessDialog extends BaseDialog {

    private static Handler sHandler = new Handler();
    private String mString = null;

    public SuccessDialog(@NonNull Context context, String text) {
        super(context, R.style.LoadingDialog);
        this.mString = text;
    }

    @Override
    public void initView() {

        TextView viewById = findViewById(R.id.textView);
        viewById.setText(mString);

        sHandler.postDelayed(() -> dismiss(), 3000);

        setCenter();
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.success_dialog;
    }
}
