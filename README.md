# DialogHelper

![](http://ouvjn19yd.bkt.clouddn.com/DialogHelper.gif)

1.Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

2.Add the dependency

```
	dependencies {
	
	     compile 'com.github.ALguojian:AlDialog:1.0'
	}

```



### 提示类型的dialog示例：

```
 showDialog
                    .setDissmissByBack(false)
                    .setDissmissByOutside(false)
                    .setMessage("快快来访问我吧", Color.BLACK)
                    .setTitle("提示", Color.parseColor("#57caa1"))
                    .setYesColor("确定", Color.parseColor("#57caa1"))
                    .setCancleColor("取消", Color.parseColor("#555555"))
                    .setYesOnclickListener(new ShowDialog.onYesOnclickListener() {
                        @Override
                        public void onYesClick() {

                            toast("点击确定了哦");

                        }
                    })
                    .setNoOnclickListener(new ShowDialog.onNoOnclickListener() {
                        @Override
                        public void onNoClick() {
                            toast("点击取消了哦");

                        }
                    })
                    .show();
```

### 分享

```
 ShareDialog shareDialog = new ShareDialog(this, MainActivity.this);
            shareDialog
                    .setDissmissByOutside(false)
                    .setDissmissByBack(true)
                    .setOnItemClick(new ShareDialog.onItemClick() {
                        @Override
                        public void onItemClick(int position) {

                            switch (position) {

                                case ShareAdapter.ZERO:
                                    toast("微信分享");
                                    break;

                                case ShareAdapter.ONE:
                                    toast("QQ分享");
                                    break;
                            }
                        }
                    })
                    .show();
```

### loading,两种loading模式

```
 new LoadingDialog(this,1)
                    .setDissmissByOutside(true).setDissMissByBack(true).show();
```

### UpDialog

```
new UpDialog(this).show();

```
