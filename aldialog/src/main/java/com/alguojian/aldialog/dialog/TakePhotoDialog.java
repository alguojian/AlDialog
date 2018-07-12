package com.alguojian.aldialog.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alguojian.aldialog.R;

/**
 * 进行拍照的dialog，包括拍照和打开相册
 *
 * @author alguojian
 * @date 2018/6/1
 */
public class TakePhotoDialog extends BaseBottomDialog {

    private TakePhoto mTakePhoto;

    public TakePhotoDialog(@NonNull Context context) {
        super(context,R.style.noWindowBottomSheetDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override
    public int getLayout() {
        return R.layout.take_photo_dialog;
    }

    @Override
    public void initView() {

        findViewById(R.id.cancel).setOnClickListener(v -> dismiss());

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

    public TakePhotoDialog setOnTakePhotoListener(TakePhoto takePhotoListener) {
        mTakePhoto = takePhotoListener;
        return this;
    }

    public interface TakePhoto {
        void takePhoto();

        void searchPhoto();
    }
}
