package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.alguojian.aldialog.R;

/**
 * 进行拍照的dialog，包括拍照和打开相册
 *
 * @author alguojian
 * @date 2018/6/1
 */
public class TakePhotoDialog extends BaseDialog {

    private TakePhoto mTakePhoto;

    public TakePhotoDialog(@NonNull Context context) {
        super(context, R.style.HomeDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override
    public void initView() {

        findViewById(R.id.cancel).setOnClickListener(v -> {
            dismiss();
        });

        findViewById(R.id.takePhoto).setOnClickListener(v -> {
            if (mTakePhoto != null) {
                mTakePhoto.takePhoto();
            }
            dismiss();
        });

        findViewById(R.id.searchPhoto).setOnClickListener(v -> {
            if (mTakePhoto != null) {
                mTakePhoto.searchPhoto();
            }
            dismiss();
        });
    }

    @Override
    public void initData() {

    }


    @Override
    public void show() {
        super.show();

        getWindow().setGravity(Gravity.BOTTOM);
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = d.getWidth();
        getWindow().setAttributes(p);
        getWindow().setWindowAnimations(R.style.popWindow);

    }

    @Override
    public int getLayout() {
        return R.layout.take_photo_dialog;
    }

    public TakePhotoDialog setOnTakePhotoListener(TakePhoto takePhotoListener) {
        mTakePhoto = takePhotoListener;
        return this;
    }

    public interface TakePhoto {
        void takePhoto();

        void searchPhoto();
    }
}
